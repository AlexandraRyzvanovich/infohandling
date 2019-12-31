package com.epam.parser;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import com.epam.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends Parser {
    private final String BY_SENTENCES_REGEX = "([^.!?]+)";
    private static final Logger LOGGER = LogManager.getLogger();

    public ParagraphParser(Parser successor) {
        setSuccessor(successor);
    }

    @Override
    public Component parse(String paragraph) throws ParserException {
        Component paragraphComponent = new Composite();
        List<String> sentencesList = findSentences(paragraph);
        for (String sentence : sentencesList) {
            if (getSuccessor() != null) {
                Component sentenceComponent = getSuccessor().parse(sentence);
                paragraphComponent.add(sentenceComponent);
            } else {
                throw new ParserException("Successor not found. Impossible to continue parsing");
            }
        }
        LOGGER.info("Paragraph parsed successfully");
        return paragraphComponent;
    }

    private List<String> findSentences (String paragraph) {
        List<String> sentences = new ArrayList<>();
        Pattern pattern = Pattern.compile(BY_SENTENCES_REGEX);
        Matcher matcher = pattern.matcher(paragraph);
        while (matcher.find()) {
            sentences.add(matcher.group());
        }
        return sentences;
    }
}

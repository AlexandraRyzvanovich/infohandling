package com.epam.parser;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import com.epam.exception.ComponentException;
import sun.tools.jstat.ParserException;

public class TextParser extends Parser {
    private final String BY_PARAGRAPH_REGEX = "\\n";

    @Override
    public Component parse(String text) throws ParserException, ComponentException {
        Component textComponent = new Composite();
        String[] paragraphs = text.split(BY_PARAGRAPH_REGEX);
        for (String paragraph  : paragraphs) {
            if(getSuccessor()!=null){
                Component paragraphComponent = getSuccessor().parse(paragraph);
                textComponent.add(paragraphComponent);
            }else {
                throw new ParserException("Successor not found. Impossible to continue parsing");
            }
        }
        return textComponent;
    }
}

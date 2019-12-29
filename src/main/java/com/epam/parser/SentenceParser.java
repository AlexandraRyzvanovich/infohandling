package com.epam.parser;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import com.epam.entity.Leaf;
import com.epam.entity.LeafType;
import com.epam.exception.ComponentException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SentenceParser extends Parser {
    private final static String LEXEM_REGEX = "";
    private final static String WORD_REGEX = "";

    @Override
    public Component parse(String sentence) throws ComponentException {
        Component sentenceComponent = new Composite();
        List<String> lexicalItems = findLexicalItems(sentence);
        for (String lexicalItem : lexicalItems ) {
            Leaf lexicalItemLeaf;
            if(lexicalItem.matches(WORD_REGEX)){
                lexicalItemLeaf = Leaf.getLeaf(lexicalItem, LeafType.WORD);
            }else {
                lexicalItemLeaf = Leaf.getLeaf(lexicalItem, LeafType.EXPRESSION);
            }
            sentenceComponent.add(lexicalItemLeaf);
        }
        return sentenceComponent;
    }

    private List<String> findLexicalItems(String sentence){
        List<String> lexicalItems = new ArrayList<>();
        Pattern pattern = Pattern.compile(LEXEM_REGEX);
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()){
            lexicalItems.add(matcher.group());
        }
        return lexicalItems;
    }
}

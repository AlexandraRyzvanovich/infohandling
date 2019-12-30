package com.epam.parser;

import com.epam.entity.Component;
import com.epam.exception.ParserException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TextParserTest {
    private TextParser textParser;

    @BeforeClass
    public void setUp(){
        textParser = new TextParser();

    }
    @Test
    public void textParserTestShouldReturnCompositeLength() throws ParserException {
        String givenText = "First paragraph. Bla bla bla" + "\n" + "Second paragraph" + "\n" + "Third";
        Component component = textParser.parse(givenText);
        System.out.println(component.getComponent());
    }
}

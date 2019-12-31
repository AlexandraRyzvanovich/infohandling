package com.epam.parser;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import com.epam.exception.ParserException;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParagraphParserTest {
    private ParagraphParser paragraphParser;

    @Mock
    Parser sentenceParser = mock(SentenceParser.class);


    @BeforeClass
    public void setUp(){
        paragraphParser = new ParagraphParser(sentenceParser);
    }

    @DataProvider
    public Object[][] provideData(){
        String paragraphText = "I'm the first sentence. I'm the second sentence! I'm the third sentence.";
        Component expectedParagraphComponent = new Composite();
        Component sentence1 = new Composite();
        sentence1.add(TestDataProvider.LEAF_SENTENCE_ONE);
        Component sentence2 = new Composite();
        sentence2.add(TestDataProvider.LEAF_SENTENCE_TWO);
        Component sentence3 = new Composite();
        sentence3.add(TestDataProvider.LEAF_SENTENCE_THREE);
        expectedParagraphComponent.add(sentence1);
        expectedParagraphComponent.add(sentence2);
        expectedParagraphComponent.add(sentence3);
        return new Object[][]{
                { sentence1, sentence2, sentence3, expectedParagraphComponent, paragraphText}
        };
    }

    @Test(dataProvider = "provideData")
    public void testParagraphParserShouldReturnComponentSizeThreeWhenCheckParagraphComponentLength(Component sentence1,
                                        Component sentence2, Component sentence3, Component expectedParagraphComponent,
                                                                                                    String paragraphText ) throws ParserException {
        //given
        when(sentenceParser.parse(TestDataProvider.SENTENCE_ONE)).thenReturn(sentence1);
        when(sentenceParser.parse(TestDataProvider.SENTENCE_TWO)).thenReturn(sentence2);
        when(sentenceParser.parse(TestDataProvider.SENTENCE_THREE)).thenReturn(sentence3);
        //when
        Component actualParagraphComponent = paragraphParser.parse(paragraphText);
        //then
        Assert.assertEquals(actualParagraphComponent.getComponent().size(), expectedParagraphComponent.getComponent().size());
    }
}

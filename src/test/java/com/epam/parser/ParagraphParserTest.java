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
        expectedParagraphComponent.add(TestDataProvider.LEAF_SENTENCE_ONE);
        expectedParagraphComponent.add(TestDataProvider.LEAF_SENTENCE_TWO);
        expectedParagraphComponent.add(TestDataProvider.LEAF_SENTENCE_THREE);
        return new Object[][]{
                { expectedParagraphComponent, paragraphText}
        };
    }

    @Test(dataProvider = "provideData")
    public void testParagraphParserShouldReturnComponentSizeThreeWhenCheckParagraphComponentLength( Component expectedParagraphComponent,
                                                                                                    String paragraphText ) throws ParserException {
        //given
        when(sentenceParser.parse(TestDataProvider.SENTENCE_ONE)).thenReturn(TestDataProvider.LEAF_SENTENCE_ONE);
        when(sentenceParser.parse(TestDataProvider.SENTENCE_TWO)).thenReturn(TestDataProvider.LEAF_SENTENCE_TWO);
        when(sentenceParser.parse(TestDataProvider.SENTENCE_THREE)).thenReturn(TestDataProvider.LEAF_SENTENCE_THREE);
        //when
        Component actualParagraphComponent = paragraphParser.parse(paragraphText);
        //then
        Assert.assertEquals(actualParagraphComponent.getComponent(), expectedParagraphComponent.getComponent());
    }
}

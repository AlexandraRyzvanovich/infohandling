package com.epam.parser;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SentenceParserTest {
    private SentenceParser sentenceParser;

    @BeforeClass
    public void setUp(){
        sentenceParser = new SentenceParser();
    }

    @DataProvider
    public Object[][] provideTestDataForSentenceParser(){
        Component expectedSentenceComponent = new Composite();
        expectedSentenceComponent.add(TestDataProvider.LEAF_WORD_ONE);
        expectedSentenceComponent.add(TestDataProvider.LEAF_WORD_TWO);
        String sentence = "Word happy";
        return new Object[][]{
                {sentence, expectedSentenceComponent}
        };
    }

    @Test(dataProvider = "provideTestDataForSentenceParser")
    public void SentenceParserTestShouldReturnTrueWhenReturnTrueWhenSentenceParsedSuccessfully(String sentence, Component expectedSentenceComponent){
        //given

        //when
        Component actualComponent = sentenceParser.parse(sentence);
        //then
        Assert.assertEquals(actualComponent.getComponent(), expectedSentenceComponent.getComponent());
    }
}

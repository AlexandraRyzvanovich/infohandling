package com.epam.factory;

import com.epam.exception.SorterException;
import com.epam.sorter.ParagraphBySentenceCountSorter;
import com.epam.sorter.Sorter;
import com.epam.sorter.WordLengthInSentenceSorter;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SorterFactoryTest {
    private static final String WORDS_IN_SENTENCE_SORTER = "Words in sentence sorter";
    private static final String PARAGRAPH_SORTER = "Paragraph sorter";
    private static final String NON_EXISTENT_SORTER = "Unknown sorter";
    SorterFactory factory;

    @BeforeClass
    public void setUp(){
        factory = new SorterFactory();
    }

    @Test
    public void testSorterFactoryShouldReturnSentenceSorterWhenValidSorterNameGiven() throws SorterException {
        //when
        Sorter sentenceSorter = factory.createSorter(WORDS_IN_SENTENCE_SORTER);
        //then
        Assert.assertEquals(sentenceSorter.getClass(), new WordLengthInSentenceSorter().getClass());
    }

    @Test
    public void testSorterFactoryShouldReturnParagraphWhenValidSorterNameGiven() throws SorterException {
        //when
        Sorter sentenceSorter = factory.createSorter(PARAGRAPH_SORTER);
        //then
        Assert.assertEquals(sentenceSorter.getClass(), new ParagraphBySentenceCountSorter().getClass());
    }

    @Test(expectedExceptions = SorterException.class)
    public void testSorterFactoryShouldReturnSorterExceptionWhenNonExistentSorterNameGiven() throws SorterException{
        factory.createSorter(NON_EXISTENT_SORTER);
    }
}

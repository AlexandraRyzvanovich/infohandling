package com.epam.factory;

import com.epam.exception.SorterException;
import com.epam.sorter.ParagraphBySentenceCountSorter;
import com.epam.sorter.Sorter;
import com.epam.sorter.WordLengthInSentenceSorter;

public class SorterFactory {
    private static final String WORDS_IN_SENTENCE_SORTER = "Words in sentence sorter";
    private static final String PARAGRAPH_SORTER = "Paragraph sorter";

    public Sorter createSorter(String sorterName) throws SorterException {
        switch (sorterName){
            case (WORDS_IN_SENTENCE_SORTER):
                return new WordLengthInSentenceSorter();
            case (PARAGRAPH_SORTER):
                return new ParagraphBySentenceCountSorter();
            default:
                throw new SorterException("Such sorter wasn't found. Please, try later:) ");
        }
    }
}

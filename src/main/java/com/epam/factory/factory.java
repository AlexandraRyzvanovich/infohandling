package com.epam.factory;

import com.epam.exception.SorterException;
import com.epam.sorter.ParagraphBySentenceCountSorter;
import com.epam.sorter.Sorter;
import com.epam.sorter.WordLengthInSentenceSorter;

public class factory {
    private static final String SENTENCE_SORTER = "Sentence sorter";
    private static final String PARAGRAPH_SORTER = "Paragraph sorter";
    Sorter sorter;

    public Sorter createSorter(String sorterName) throws SorterException {
        switch (sorterName){
            case (SENTENCE_SORTER):
                return sorter = new WordLengthInSentenceSorter();
            case (PARAGRAPH_SORTER):
                return sorter = new ParagraphBySentenceCountSorter();
            default:
                throw new SorterException("Such sorter wasn't found. Please, try later:) ");
        }
    }
}

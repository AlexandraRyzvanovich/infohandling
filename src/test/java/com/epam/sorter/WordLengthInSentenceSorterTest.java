package com.epam.sorter;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import com.epam.entity.Leaf;
import com.epam.entity.LeafType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WordLengthInSentenceSorterTest {
    private WordLengthInSentenceSorter wordLengthInSentenceSorter;
    private static final Component MIDDLE_WORD = new Leaf("longer", LeafType.WORD);
    private static final Component SHORT_WORD = new Leaf("short", LeafType.WORD);
    private static final Component LONG_WORD = new Leaf("veryLong", LeafType.WORD);

    @BeforeClass
    public void setUp() {
        wordLengthInSentenceSorter = new WordLengthInSentenceSorter();
    }

    @DataProvider
    public Object[][] provideTestData() {
        Component givenComposite = new Composite();
        givenComposite.add(MIDDLE_WORD);
        givenComposite.add(SHORT_WORD);
        givenComposite.add(LONG_WORD);
        Component expectedComposite = new Composite();
        expectedComposite.add(LONG_WORD);
        expectedComposite.add(MIDDLE_WORD);
        expectedComposite.add(SHORT_WORD);

        return new Object[][]{
                {givenComposite, expectedComposite},
        };
    }

    @Test(dataProvider = "provideTestData")
    public void sortWordsInSentenceByLengthReturnTrueWhenSortedComponentIsValid(Component givenComposite,
                                                                                Component expectedResult) {
        //when
        Component actualResult = wordLengthInSentenceSorter.sort(givenComposite);
        //then
        Assert.assertEquals(actualResult, expectedResult);
    }
}

package com.epam.sorter;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import com.epam.entity.Leaf;
import com.epam.entity.LeafType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SentenceSorterByWordsCountTest {
    private WordsCountInSentenceSorter wordsCountInSentenceSorter;

    @BeforeClass
    public void setUp() {
        wordsCountInSentenceSorter = new WordsCountInSentenceSorter();
    }

    @DataProvider
    public Object[][] provideTestData() {
        Component givenComposite = new Composite();
        Component leaf1 = new Leaf("longer", LeafType.WORD);
        givenComposite.add(leaf1);
        Component leaf2 = new Leaf("short", LeafType.WORD);
        givenComposite.add(leaf2);
        Component leaf3 = new Leaf("veryLong", LeafType.WORD);
        givenComposite.add(leaf3);
        Component expectedComposite = new Composite();
        expectedComposite.add(leaf3);
        expectedComposite.add(leaf2);
        expectedComposite.add(leaf1);

        return new Object[][]{
                {givenComposite, expectedComposite},
        };
    }

    @Test(dataProvider = "provideTestData")
    public void sortWordsInSentenceByLengthReturnTrueWhen(Component givenComposite, Component expectedResult) {
        //given
        //when
        Component actualResult = wordsCountInSentenceSorter.sort(givenComposite);
        //then
        Assert.assertEquals(String.valueOf(actualResult.getComponent().get(0)), String.valueOf(expectedResult.getComponent().get(0)));
    }
}

package com.epam.sorter;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import com.epam.entity.Leaf;
import com.epam.entity.LeafType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParagraphBySentenceCountSorterTest {
    private ParagraphBySentenceCountSorter paragraphBySentenceCountSorter;
    private static final Component SENTENCE_ONE = new Leaf("I'm the first sentence. ", LeafType.SENTENCE);
    private static final Component SENTENCE_TWO = new Leaf("I'm the second sentence.", LeafType.SENTENCE);
    private static final Component SENTENCE_THREE = new Leaf("I'm the third sentence.", LeafType.SENTENCE);
    private static final Component SENTENCE_FOUR = new Leaf("I'm the fourth sentence", LeafType.SENTENCE);

    @BeforeClass
    public void setUp() {
        paragraphBySentenceCountSorter = new ParagraphBySentenceCountSorter();
    }

    @DataProvider
    public Object[][] provideTestData() {
        Component paragraph1 = new Composite();
        paragraph1.add(SENTENCE_ONE);
        paragraph1.add(SENTENCE_TWO);
        Component paragraph2 = new Composite();
        paragraph2.add(SENTENCE_ONE);
        paragraph2.add(SENTENCE_TWO);
        paragraph2.add(SENTENCE_THREE);
        Component paragraph3 = new Composite();
        paragraph3.add(SENTENCE_ONE);
        paragraph3.add(SENTENCE_TWO);
        paragraph3.add(SENTENCE_THREE);
        paragraph3.add(SENTENCE_FOUR);
        Component givenTextComponent = new Composite();
        givenTextComponent.add(paragraph1);
        givenTextComponent.add(paragraph2);
        givenTextComponent.add(paragraph3);
        Component expectedSortedText = new Composite();
        expectedSortedText.add(paragraph3);
        expectedSortedText.add(paragraph2);
        expectedSortedText.add(paragraph1);

        return new Object[][]{
                {givenTextComponent, expectedSortedText},
        };
    }

    @Test(dataProvider = "provideTestData")
    public void testParagraphSorterShouldReturnTrueWhenSortedComponentIsValid(Component givenTextComponent, Component expectedResult){
        //when
        Component actualResult = paragraphBySentenceCountSorter.sort(givenTextComponent);
        //then
        Assert.assertEquals(actualResult, expectedResult);
    }
}

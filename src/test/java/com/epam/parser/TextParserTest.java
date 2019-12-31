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

import static com.epam.parser.TestDataProvider.LEAF_SENTENCE_TWO;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TextParserTest {
    private TextParser textParser;

    @Mock
    Parser paragraphParser = mock(ParagraphParser.class);

    @BeforeClass
    public void setUp(){
        textParser = new TextParser(paragraphParser);
    }

    @DataProvider
    public Object[][] dataProviderTextComponentLengthThree(){
        String text = "I'm the first sentence." + "\n" + "I'm the second sentence." +
                "\n" + "I'm the third sentence.";
        Component firstParagraph = new Composite();
        firstParagraph.add(TestDataProvider.LEAF_SENTENCE_ONE);
        Component secondParagraph = new Composite();
        secondParagraph.add(TestDataProvider.LEAF_SENTENCE_TWO);
        Component thirdParagraph = new Composite();
        thirdParagraph.add(TestDataProvider.LEAF_SENTENCE_THREE);
        Component expectedTextComponent = new Composite();
        expectedTextComponent.add(firstParagraph);
        expectedTextComponent.add(secondParagraph);
        expectedTextComponent.add(thirdParagraph);

        return new Object[][]{
                {firstParagraph, secondParagraph, thirdParagraph, expectedTextComponent, text},
        };
    }

    @Test(dataProvider = "dataProviderTextComponentLengthThree")
    public void textParserTestShouldReturnSizeThreeWhenCheckTextComponentLength(Component firstParagraph, Component secondParagraph,
                                                          Component thirdParagraph, Component expectedTextComponent, String text ) throws ParserException {
        //given
        when(paragraphParser.parse(TestDataProvider.SENTENCE_ONE)).thenReturn(firstParagraph);
        when(paragraphParser.parse(TestDataProvider.SENTENCE_TWO)).thenReturn(secondParagraph);
        when(paragraphParser.parse(TestDataProvider.SENTENCE_THREE)).thenReturn(thirdParagraph);
        //when
        Component actualTextComponent = textParser.parse(text);
        //then
        Assert.assertEquals(actualTextComponent.getComponent(), expectedTextComponent.getComponent());
    }

    @DataProvider
    public Object[][] dataProviderTextComponentLengthTwo(){
        String text = "I'm the first sentence." + "I'm the second sentence." +
                "\n" + "I'm the third sentence.";
        Component firstParagraph = new Composite();
        firstParagraph.add(TestDataProvider.LEAF_SENTENCE_ONE);
        firstParagraph.add(LEAF_SENTENCE_TWO);
        Component secondParagraph = new Composite();
        secondParagraph.add(TestDataProvider.LEAF_SENTENCE_THREE);
        Component expectedTextComponent = new Composite();
        expectedTextComponent.add(firstParagraph);
        expectedTextComponent.add(secondParagraph);

        return new Object[][]{
                {firstParagraph, secondParagraph, expectedTextComponent, text},
        };
    }

    @Test(dataProvider = "dataProviderTextComponentLengthTwo")
    public void textParserTestShouldReturnSizeTwoWhenCheckTextComponentLength(Component firstParagraph, Component secondParagraph,
                                                                              Component expectedTextComponent, String text ) throws ParserException {
        //given
        when(paragraphParser.parse(TestDataProvider.SENTENCE_ONE + TestDataProvider.SENTENCE_TWO)).thenReturn(firstParagraph);
        when(paragraphParser.parse(TestDataProvider.SENTENCE_THREE)).thenReturn(secondParagraph);
        //when
        Component actualTextComponent = textParser.parse(text);
        //then
        Assert.assertEquals(actualTextComponent.getComponent(), expectedTextComponent.getComponent());
    }
}

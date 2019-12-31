package com.epam.parser;

import com.epam.entity.Component;
import com.epam.entity.Composite;
import com.epam.entity.Leaf;
import com.epam.entity.LeafType;
import com.epam.exception.ParserException;
import org.mockito.Mock;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;

public class TextParserTest {
    private TextParser textParser;
    private static final String text = "I'm the first sentence. I'm the second sentence." +
            "\n" + "I'm the third sentence. I'm the fourth sentence.";
    private static final Component SENTENCE_ONE = Leaf.getLeaf("I'm the first sentence. ", LeafType.SENTENCE);
    private static final Component SENTENCE_TWO = Leaf.getLeaf("I'm the second sentence.", LeafType.SENTENCE);
    private static final Component SENTENCE_THREE = Leaf.getLeaf("I'm the third sentence.", LeafType.SENTENCE);
    private static final Component SENTENCE_FOUR = Leaf.getLeaf("I'm the fourth sentence", LeafType.SENTENCE);
    Component firstParagraph;
    Component secondParagraph;

    @Mock
    Parser paragraphParser = new ParagraphParser();

    @BeforeClass
    public void setUp(){
        textParser = new TextParser();
    }

    @DataProvider
    public Object[][] dataProvider(){
        firstParagraph = new Composite();
        firstParagraph.add(SENTENCE_ONE);
        firstParagraph.add(SENTENCE_TWO);
        secondParagraph = new Composite();
        secondParagraph.add(SENTENCE_THREE);
        secondParagraph.add(SENTENCE_FOUR);
        return new Object[][]{
                {firstParagraph, secondParagraph},
        };
    }

    @Test()
    public void textParserTestShouldReturnCompositeLength() {
        textParser.setSuccessor(paragraphParser);



    }
}

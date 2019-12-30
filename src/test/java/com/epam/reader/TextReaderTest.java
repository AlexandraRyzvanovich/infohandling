package com.epam.reader;

import com.epam.exception.ReaderException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TextReaderTest {
    private final String VALID_FILE_PATH = "src/test/resources/text";
    private final String INVALID_FILE_PATH = "src/test/resources/invalidPath";
    private TextReader textReader;

    @BeforeClass
    public void setUp(){
        textReader = new TextReader();
    }

    @Test
    public void textReaderTestShouldReturnTrueOnSizeResultAndLineComparingWhenValidPathGiven() throws ReaderException {
        //given
        int linesCount = 10;
        String secondLine = "counting expressions like: [ 8 2 7 4 + * -]. End of first paragraph.";
        //when
        List<String> actualResult = textReader.read(VALID_FILE_PATH);
        //then
        Assert.assertEquals(actualResult.size(), linesCount);
        Assert.assertEquals(actualResult.get(1), secondLine);
    }
    @Test(expectedExceptions = ReaderException.class)
    public void textReaderShouldReturnIOExceptionWhenInvalidPathGiven() throws ReaderException {
        //when
        textReader.read(INVALID_FILE_PATH);
    }
}

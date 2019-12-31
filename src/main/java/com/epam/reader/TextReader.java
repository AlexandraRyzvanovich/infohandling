package com.epam.reader;

import com.epam.exception.ReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {
    private static final Logger LOGGER = LogManager.getLogger();

    public List<String> read(String filePath) throws ReaderException {
        List<String> lines;
        Path path = Paths.get(filePath);

        try (Stream<String> lineStream = Files.lines(path)) {

            lines = lineStream.collect(Collectors.toList());

        } catch (IOException ex) {
            throw new ReaderException("Invalid file path given for reader", ex.getCause() );
        }
        LOGGER.info("File was read successfully");
        return lines;
    }
}

package com.epam.reader;

import com.epam.exception.ReaderException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {
    public List<String> read(String filePath) throws ReaderException {
        List<String> lines;
        Path path = Paths.get(filePath);

        try (Stream<String> lineStream = Files.lines(path)) {

            lines = lineStream.collect(Collectors.toList());

        } catch (IOException ex) {
            throw new ReaderException("Invalid file path given for reader", ex.getCause() );
        }
        return lines;
    }
}

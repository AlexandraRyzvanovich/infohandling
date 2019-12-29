package com.epam.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {
    public List<String> read(String filePath){
        List<String> lines = new ArrayList<>();
        Path path = Paths.get(filePath);

        try (Stream<String> lineStream = Files.lines(path)) {

            lines = lineStream.collect(Collectors.toList());

        } catch (IOException ignored) {
        }
        return lines;
    }
}

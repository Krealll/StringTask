package com.krealll.day5.reader;

import com.krealll.day5.exception.FileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReader {

    public List<String> readFile(String filePath) throws FileException {
        Path path = Paths.get(filePath);
        if(Files.notExists(path)){
            throw new FileException("File doesn't exist");
        }
        try(Stream<String> lines =Files.lines(path)) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new FileException("Incorrect file data");
        }
    }

}

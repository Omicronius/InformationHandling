package com.epam.informationhandling.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TextReader {
    private static Logger logger = LogManager.getLogger(TextReader.class);

    public String readText(String pathToFile) {
        String text = null;
        try {
            text = Files.lines(Paths.get(pathToFile)).collect(Collectors.joining());
        } catch (NoSuchFileException e) {
            logger.log(Level.FATAL, "The file has not been found.");
            throw new RuntimeException();
        } catch (IOException e) {
            logger.log(Level.FATAL, "The IOException is occured.");
            throw new RuntimeException();
        }
        return text;
    }
}

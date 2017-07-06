package com.epam.informationhandling.runner;

import com.epam.informationhandling.chain.ISeparator;
import com.epam.informationhandling.chain.TextSeparator;
import com.epam.informationhandling.composite.Component;
import com.epam.informationhandling.manipulator.TextManipulator;
import com.epam.informationhandling.reader.TextReader;


public class Runner {
    private static final String FILE_NAME = "text.txt";

    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        String content = textReader.readTextFromFile(FILE_NAME);

        ISeparator separator = new TextSeparator();
        Component text = separator.separate(content);
        System.out.println(text);

        TextManipulator textManipulation = new TextManipulator();


    }
}

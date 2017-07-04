package com.epam.informationhandling;

import com.epam.informationhandling.chain.ChainParser;
import com.epam.informationhandling.chain.LeafParser;
import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.entity.ComponentType;
import com.epam.informationhandling.util.TextReader;

public class Runner {
    private static String pathToFile = "text.txt";

    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        String content = textReader.readText(pathToFile);

        ChainParser leafParser = new LeafParser();
        ChainParser sentenceParser = new ChainParser(leafParser, ComponentType.WORD);
        ChainParser paragraphParser = new ChainParser(sentenceParser, ComponentType.SENTENCE);
        ChainParser textParser = new ChainParser(paragraphParser, ComponentType.PARAGRAPH);

        Component composite = textParser.parse(content);
        System.out.println();
    }
}

package com.epam.informationhandling.chain;

import com.epam.informationhandling.composite.Component;
import com.epam.informationhandling.composite.TextComposite;

import static com.epam.informationhandling.composite.ComponentType.PARAGRAPH;


public class ParagraphSeparator implements ISeparator {
    private static final ISeparator separator = new SentenceSeparator();
    private static final String SENTENCE_TERMINATOR = "(?<=[.!?])";

    public Component separate(String paragraph) {
        Component textComposite = new TextComposite(PARAGRAPH);
        for (String part : paragraph.split(SENTENCE_TERMINATOR)) {
            textComposite.add(separator.separate(part.trim()));
        }
        return textComposite;
    }
}

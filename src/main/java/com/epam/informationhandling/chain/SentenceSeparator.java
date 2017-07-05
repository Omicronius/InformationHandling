package com.epam.informationhandling.chain;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.entity.ComponentType;
import com.epam.informationhandling.entity.TextComposite;

public class SentenceSeparator implements ISeparator {
    private ISeparator separator = new LexemeSeparator();
    private static final String LEXEME_REGEX = " ";

    public Component separate(String sentence) {
        Component textComposite = new TextComposite(ComponentType.SENTENCE);
        for (String part : sentence.split(LEXEME_REGEX)) {
            textComposite.add(separator.separate(part));
        }
        return textComposite;
    }
}

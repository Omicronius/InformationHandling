package com.epam.informationhandling.chain;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.entity.ComponentType;
import com.epam.informationhandling.entity.TextComposite;

public class ParagraphSeparator implements ISeparator {
    private ISeparator separator = new SentenceSeparator();
    private static final String SENTENCE_REGEX = "(?<=[.!?])";

    public Component separate(String paragraph) {
        Component textComposite = new TextComposite(ComponentType.PARAGRAPH);
        for (String part : paragraph.split(SENTENCE_REGEX)) {
            if (!part.isEmpty()) {
                textComposite.add(separator.separate(part));
            }
        }
        return textComposite;
    }
}

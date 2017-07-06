package com.epam.informationhandling.chain;

import com.epam.informationhandling.composite.Component;
import com.epam.informationhandling.composite.TextComposite;

import static com.epam.informationhandling.composite.ComponentType.TEXT;

public class TextSeparator implements ISeparator {
    private static final ISeparator separator = new ParagraphSeparator();
    private static final String NEW_LINE = "(?=[\\t])";

    public Component separate(String text) {
        Component textComposite = new TextComposite(TEXT);
        for (String part : text.split(NEW_LINE)) {
            textComposite.add(separator.separate(part));
        }
        return textComposite;
    }
}

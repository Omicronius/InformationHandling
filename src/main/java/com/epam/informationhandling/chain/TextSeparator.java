package com.epam.informationhandling.chain;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.entity.ComponentType;
import com.epam.informationhandling.entity.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextSeparator implements ISeparator {
    private ISeparator separator = new ParagraphSeparator();
    private static final String PARAGRAPH_REGEX = "(?<=\\t).+";

    public Component separate(String text) {
        Component textComposite = new TextComposite(ComponentType.TEXT);
        Pattern pattern = Pattern.compile(PARAGRAPH_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String str = matcher.group();
            textComposite.add(separator.separate(matcher.group()));
        }
        return textComposite;
    }
}

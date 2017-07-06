package com.epam.informationhandling.chain;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.entity.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.informationhandling.entity.ComponentType;
import com.epam.informationhandling.entity.TextLeaf;

public class LexemeSeparator implements ISeparator {
    private static final String WORD_REGEX = "(\\w+)";
    private static final String MATH_EXPRESSION_REGEX = "(?<=[—, '.!?])|(?=[—, '.!?])";
    private static final String PUNCTUATION_REGEX = "\\p{Punct}";

    public Component separate(String lexeme) {
        Component textComposite = new TextComposite(ComponentType.LEXEME);
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(lexeme);
        if (matcher.matches()) {
            textComposite.add(new TextLeaf(ComponentType.WORD, lexeme));
        } else if (Pattern.compile(MATH_EXPRESSION_REGEX).matcher(lexeme).matches()) {
            textComposite.add(new TextLeaf(ComponentType.NUMERIC_EXPRESSION, lexeme));
        } else {
            if (matcher.find()) {
                String word = matcher.group();
                textComposite.add(new TextLeaf(ComponentType.WORD, word));
            }
            Matcher m = Pattern.compile(PUNCTUATION_REGEX).matcher(lexeme);
            if (m.find()) {
                String punctuation = m.group();
                textComposite.add(new TextLeaf(ComponentType.WORD, punctuation));
            }
        }
        return textComposite;
    }


}

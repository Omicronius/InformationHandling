package com.epam.informationhandling.chain;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.entity.TextComposite;

import java.util.regex.Pattern;
import com.epam.informationhandling.entity.ComponentType;
import com.epam.informationhandling.entity.TextLeaf;

public class LexemeSeparator implements ISeparator {
    private final String WORD_REGEX = "([A-Za-z0-9-]+)";
    private final String MATH_EXPRESSION_REGEX = "(?<=[—, '.!?])|(?=[—, '.!?])";
    private final String PUNCT_REGEX = "(?=[[:punct:]]))";

    public Component separate(String lexeme) {
        Component textComposite = new TextComposite(ComponentType.LEXEME);

        Pattern pattern = Pattern.compile(WORD_REGEX);
                if (Pattern.compile(WORD_REGEX).matcher(lexeme).matches()) {
                    textComposite.add(new TextLeaf(ComponentType.WORD, lexeme));
                } else if (Pattern.compile(MATH_EXPRESSION_REGEX).matcher(lexeme).matches()) {
                    textComposite.add(new TextLeaf(ComponentType.LEXEME, lexeme));
                } else {
                    //todo
                }
        return textComposite;
    }
}

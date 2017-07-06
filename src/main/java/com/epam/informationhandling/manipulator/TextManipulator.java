package com.epam.informationhandling.manipulator;

import com.epam.informationhandling.composite.Component;

import java.util.Iterator;

import static com.epam.informationhandling.composite.ComponentType.WORD;

public class TextManipulator {

    public void removeCertainLexeme(Component textComposite, int length, String firstLetter) {
        for (Component paragraph : textComposite.getComponents()) {
            for (Component sentence : paragraph.getComponents()) {
                Iterator iterator = sentence.getComponents().iterator();
                while (iterator.hasNext()) {
                    Component lexeme = (Component) iterator.next();
                    if (WORD.equals(lexeme.getType()) &&
                            lexeme.toString().length() == length &&
                            lexeme.toString().toLowerCase().startsWith(firstLetter.toLowerCase())) {
                        iterator.remove();
                    }
                }
            }
        }
    }

}

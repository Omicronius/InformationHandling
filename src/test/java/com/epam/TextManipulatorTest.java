package com.epam;

import com.epam.informationhandling.chain.ISeparator;
import com.epam.informationhandling.chain.TextSeparator;
import com.epam.informationhandling.composite.Component;
import com.epam.informationhandling.manipulator.TextManipulator;
import org.junit.Before;
import org.junit.Test;

public class TextManipulatorTest {
    private TextManipulator textManipulator;
    private Component textComposite;

    @Before
    public void init() {
        textManipulator = new TextManipulator();
        ISeparator separator = new TextSeparator();
        String text = "Too good to be true.";
        textComposite = separator.separate(text);
    }

    @Test
    public void removeLexemeTest() {
        textManipulator.removeCertainLexeme(textComposite, 2, "t");
        System.out.println(textComposite);
    }


}

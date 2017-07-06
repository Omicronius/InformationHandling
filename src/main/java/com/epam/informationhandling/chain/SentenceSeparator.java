package com.epam.informationhandling.chain;

import com.epam.informationhandling.composite.Component;
import com.epam.informationhandling.composite.TextComposite;
import com.epam.informationhandling.composite.TextLeaf;
import com.epam.informationhandling.interpreter.Client;

import java.util.regex.Pattern;

import static com.epam.informationhandling.composite.ComponentType.*;

public class SentenceSeparator implements ISeparator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+)");
    private static final String WORD_DELIMITER = "(?<=[—, '.!?])|(?=[—, '.!?])";

    public Component separate(String sentence) {
        Component textComposite = new TextComposite(SENTENCE);
        for (String part : sentence.split(WORD_DELIMITER)) {
            part = part.trim();
            if (!part.isEmpty()) {
                if (Pattern.compile(WORD_DELIMITER).matcher(part).find()) {
                    textComposite.add(new TextLeaf(part, PUNCTUATION));
                } else if (NUMBER_PATTERN.matcher(part).find()) {
                    Client interpreter = new Client(part);
                    part = interpreter.calculate().toString();
                    textComposite.add(new TextLeaf(part, NUMBER));
                } else {
                    textComposite.add(new TextLeaf(part, WORD));
                }
            }
        }
        return textComposite;
    }
}

package com.epam.informationhandling.chain;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.entity.ComponentType;
import com.epam.informationhandling.entity.TextComposite;
import com.epam.informationhandling.entity.TextLeaf;
import com.epam.informationhandling.util.RegexHolder;

public class LeafParser extends ChainParser {

    public LeafParser() {
        type = ComponentType.WORD;
        regex = RegexHolder.defineRegexByType(type);
    }

    public Component parse(String sentence) {
        Component textComposite = new TextComposite(type);
        for (String part : sentence.split(regex)) {
            part = part.trim();
            if (!part.isEmpty()) {
                textComposite.add(new TextLeaf(type, part));
            }
        }
        return textComposite;
    }
}

package com.epam.informationhandling.chain;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.entity.ComponentType;
import com.epam.informationhandling.entity.TextComposite;
import com.epam.informationhandling.util.RegexHolder;

public class ChainParser {
    ChainParser parser;
    ComponentType type;
    String regex;

    public ChainParser() {
    }

    public ChainParser(ChainParser parser, ComponentType type) {
        this.parser = parser;
        this.type = type;
        regex = RegexHolder.defineRegexByType(type);
    }

    public Component parse(String content) {
        Component textComposite = new TextComposite(type);
        for (String part : content.split(regex)) {
            part = part.trim();
            textComposite.add(parser.parse(part));
        }
        return textComposite;
    }
}


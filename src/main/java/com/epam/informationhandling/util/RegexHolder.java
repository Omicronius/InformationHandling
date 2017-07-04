package com.epam.informationhandling.util;

import com.epam.informationhandling.entity.ComponentType;

import java.util.HashMap;

public class RegexHolder {
    private static HashMap<ComponentType, String> regexMap = new HashMap<>();

    private RegexHolder() {
    }

    static {
        regexMap.put(ComponentType.PARAGRAPH, "\n");
        regexMap.put(ComponentType.SENTENCE, "(?<=[.!?])");
        regexMap.put(ComponentType.WORD, "(?<=[—, '])");
    }

    public static String defineRegexByType(ComponentType type) {
        return regexMap.get(type);
    }
}

package com.epam.informationhandling.util;

import com.epam.informationhandling.entity.Type;

public class RegexHandler {

    public static String defineRegex(Type type) {
        String result;
        switch (type) {
            case PARAGRAPH:
                result = "/t";
                break;
            default:
                result = "";
        }
        return result;
    }
}

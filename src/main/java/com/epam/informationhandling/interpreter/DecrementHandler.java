package com.epam.informationhandling.interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DecrementHandler {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("(\\d+)");
    private static final Pattern DECREMENT_PATTERN = Pattern.compile("(\\d+--|--\\d+)");

    public static String decrement(String expression) {
        Matcher decrementPatternMatcher = DECREMENT_PATTERN.matcher(expression);

        while (decrementPatternMatcher.find()) {
            String oldExpression = decrementPatternMatcher.group();

            Matcher numberPatternMatcher = NUMERIC_PATTERN.matcher(oldExpression);
            numberPatternMatcher.find();

            Integer newExpression = Integer.parseInt(numberPatternMatcher.group()) - 1;

            expression = expression.replace(oldExpression, newExpression.toString());
        }
        return expression;
    }
}

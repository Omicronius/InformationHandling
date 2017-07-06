package com.epam.informationhandling.interpreter;

class TerminalExpressionMultiply extends AbstractMathExpression {

    public void interpret(Context context) {
        context.pushValue(context.popValue() * context.popValue());
    }

    @Override
    public String toString() {
        return "*";
    }
}

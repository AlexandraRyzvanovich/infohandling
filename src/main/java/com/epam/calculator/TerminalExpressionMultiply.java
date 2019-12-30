package com.epam.calculator;

public class TerminalExpressionMultiply implements MathExpression {
    @Override public void interpret(Context c) {
        c.pushValue(c.popValue() * c.popValue());
    }
}

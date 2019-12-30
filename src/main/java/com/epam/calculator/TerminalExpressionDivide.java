package com.epam.calculator;

public class TerminalExpressionDivide implements MathExpression {
    @Override
    public void interpret(Context c) {
        c.pushValue((c.popValue() / c.popValue()));
    }
}

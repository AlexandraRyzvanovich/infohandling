package com.epam.calculator;

public class NonTerminalExpressionNumber implements MathExpression {
    private int number;

    public NonTerminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context c) {
        c.pushValue(number);
    }
}

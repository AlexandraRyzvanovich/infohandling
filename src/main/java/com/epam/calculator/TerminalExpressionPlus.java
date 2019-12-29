package com.epam.calculator;

public class TerminalExpressionPlus implements AbstractMathExpression {
    @Override public void interpret(Context c) {
        c.pushValue(c.popValue() + c.popValue());
    }
}

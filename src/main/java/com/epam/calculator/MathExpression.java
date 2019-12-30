package com.epam.calculator;

@FunctionalInterface
public interface MathExpression {
    void interpret(Context context);
}

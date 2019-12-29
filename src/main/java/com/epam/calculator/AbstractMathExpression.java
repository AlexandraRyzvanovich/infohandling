package com.epam.calculator;

@FunctionalInterface
public interface AbstractMathExpression {
    void interpret(Context context);
}

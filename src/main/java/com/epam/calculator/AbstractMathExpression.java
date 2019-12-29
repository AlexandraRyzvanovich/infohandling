package com.epam.calculator;

@FunctionalInterface
public interface AbstractMathExpression {
    public abstract void interpret(Context context);
}

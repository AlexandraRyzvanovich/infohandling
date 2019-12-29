package com.epam.calculator;

import com.epam.exception.CalculatorException;

import java.util.ArrayList;
import java.util.List;

public class ExpressionCalculator {
    private List<AbstractMathExpression> listExpression;

    public ExpressionCalculator(String expression) throws CalculatorException {
        listExpression = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) throws CalculatorException {
        for (String lexeme : expression.split("\\p{Blank}+")) {
            if (lexeme.isEmpty()) {
                continue;
            }
        char temp = lexeme.charAt(0);
        switch (temp) {
            case '+':
                listExpression.add(new TerminalExpressionPlus());
                break;
            case '-':
                listExpression.add(new TerminalExpressionMinus());
                break;
            case '*':
                listExpression.add(new TerminalExpressionMultiply());
                break;
            case '/':
                listExpression.add(new TerminalExpressionDivide());
                break;
            default:
                throw new CalculatorException("no such operation");
        }
    }
}

    public Number calculate() {
        Context context = new Context();
        for (AbstractMathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}

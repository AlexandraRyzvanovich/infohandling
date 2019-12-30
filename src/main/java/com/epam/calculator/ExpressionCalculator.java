package com.epam.calculator;

import java.util.ArrayList;
import java.util.List;

public class ExpressionCalculator {
    private final static String LEXEME_REGEX = "\\s";
    private final static String NUMBER_REGEX = "[:digit:]?";
    private final List<MathExpression> listExpression;

    public ExpressionCalculator(String expression) {
        listExpression = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        for (String lexeme : expression.split(LEXEME_REGEX)) {
            if (lexeme.isEmpty()) {
                continue;
            }
        char temp = lexeme.charAt(0);
        switch (temp) {
            case '+':
                listExpression.add((Context c) -> c.pushValue(c.popValue() + c.popValue()));
                break;
            case '-':
                listExpression.add((Context c) -> c.pushValue(c.popValue() - c.popValue()));
                break;
            case '*':
                listExpression.add((Context c) ->  c.pushValue(c.popValue() * c.popValue()));
                break;
            case '/':
                listExpression.add((Context c) -> c.pushValue((c.popValue() / c.popValue())));
                break;
            default:
                if(lexeme.matches(NUMBER_REGEX)){
                    listExpression.add(
                            new NonTerminalExpressionNumber(Integer.valueOf(lexeme)));
                }
        }
    }
}

    public Number calculate() {
        Context context = new Context();
        for (MathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}

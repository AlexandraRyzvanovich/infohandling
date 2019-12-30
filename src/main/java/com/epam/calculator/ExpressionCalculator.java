package com.epam.calculator;

import java.util.ArrayList;

public class ExpressionCalculator {
    private final static String LEXEME_REGEX = "\\s+";
    private final static String NUMBER_REGEX = "-?[0-9]+";
    private ArrayList<MathExpression> listExpression;

    public ExpressionCalculator(String expression) {
        listExpression = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        for (String lexeme : expression.split(LEXEME_REGEX)) {
        switch (lexeme) {
            case "+":
                listExpression.add((Context c) -> c.pushValue(c.popValue() + c.popValue()));
                break;
            case "-":
                listExpression.add((Context c) -> c.pushValue(c.popValue() - c.popValue()));
                break;
            case "*":
                listExpression.add((Context c) -> c.pushValue(c.popValue() * c.popValue()));
                break;
            case "/":
                listExpression.add((Context c) -> c.pushValue(c.popValue() / c.popValue()));
                break;
            default:
                if(lexeme.matches(NUMBER_REGEX)){
                    listExpression.add(
                            new NonTerminalExpressionNumber(Integer.valueOf(lexeme)));
                }
        }
    }
}

    public int calculate() {
        Context context = new Context();
        for (MathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}

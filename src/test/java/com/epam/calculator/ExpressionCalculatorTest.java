package com.epam.calculator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpressionCalculatorTest {
    private ExpressionCalculator calculator;

    @Test
    public void calculatorTestShouldReturnFourteenWhenValidPositiveExpressionGiven(){
        //given
        String expression = " 8 2 7 4 + * -";
        calculator = new ExpressionCalculator(expression);
        int expectedResult = 14;
        //when
        int actualResult = calculator.calculate();
        //then
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void calculatorTestShouldReturnMinusOneWhenNegativeExpressionGiven(){
        String expression = "-5 -2 / 9 + 8 - ";
        calculator = new ExpressionCalculator(expression);
        int expectedResult = -1;
        //when
        int actualResult = calculator.calculate();
        //then
        Assert.assertEquals(actualResult, expectedResult);
    }

}

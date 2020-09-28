package com.example.labpertama;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void validateCalculation() {
        Calculator calculator = new Calculator();
        String input = "123+123";
        boolean output = calculator.validateCalculation(input);
        assertEquals(true, output);
    }

    @Test
    public void calculate() {
        Calculator calculator = new Calculator();
        String input = "123+123";
        int output = calculator.calculate(input);
        assertEquals(246, output);
    }
}
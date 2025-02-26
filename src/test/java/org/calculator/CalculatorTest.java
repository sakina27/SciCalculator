package org.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testSquareRoot() {
        assertEquals(5.0, Calculator.squareRoot(25), 0.0001);
    }

    @Test
    public void testFactorial() {
        assertEquals(120, Calculator.factorial(5));
    }

    @Test
    public void testNaturalLog() {
        assertEquals(0.0, Calculator.naturalLog(1), 0.0001);
    }

    @Test
    public void testPower() {
        assertEquals(16.0, Calculator.power(2, 4), 0.0001);
    }
}

package it.unibo.sweng.tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void testComputeEmptyString() {
        Calculator calculator = new Calculator();
        int value = calculator.compute("");
        assertEquals(-1, value);
    }

    @Test
    public void testComputeNullExpression() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, 
            () -> calculator.compute(null));
    }

    @Test
    public void testComputeSingleValue() {
        Calculator calculator = new Calculator();
        int value = calculator.compute("123");
        assertEquals(123, value);
    }

    @Test
    public void testComputeSingleValueTooLong() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, 
            () -> calculator.compute("4321"));
    }

    @Test
    public void testComputeSingleNegaiveValue() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, 
            () -> calculator.compute("-97"));
    }

    @Test
    public void testComputeSingleOperation() {
        Calculator calculator = new Calculator();
        int value = calculator.compute("12+23");
        assertEquals(35, value);
    }

    @Test
    public void testComputeTwoOperationsMissingOperand() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, 
            () -> calculator.compute("23-12*"));
    }

    @Test
    public void testComputeTwoOperations() {
        Calculator calculator = new Calculator();
        int value = calculator.compute("12+24*2");
        assertEquals(72, value);
    }

    @Test
    public void testComputeLongExpression() {
        Calculator calculator = new Calculator();
        int value = calculator.compute("12+24*2-11/6");
        assertEquals(10, value);
    }

    @Test
    public void testComputeDivisionByZero() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, 
            () -> calculator.compute("12+2/0"));
    }

    @Test
    public void testComputeWithNegativeResult() {
        Calculator calculator = new Calculator();
        int value = calculator.compute("12+3-24");
        assertEquals(-9, value);
    }
}

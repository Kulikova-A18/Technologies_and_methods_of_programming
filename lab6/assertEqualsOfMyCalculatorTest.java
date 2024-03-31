

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class assertEqualsOfMyCalculatorTest
{
    MyCalculator calculator = new MyCalculator();

    @Test
    public void testSubtract() {
        assertEquals(calculator.subtract(5, 3), 2.0, 0.0001, "Test subtraction with true value");
    }

    @Test
    public void testMultiply() {
        assertEquals(calculator.multiply(2, 3), 6.0, 0.0001, "Test multiplication with true value");
    }

    @Test
    public void testDivide() {
        assertEquals(calculator.divide(6, 3), 2.0, 0.0001, "Test division with true value");
    }

    @Test
    public void testPower() {
        assertEquals(calculator.power(2, 3), 8.0, 0.0001, "Test power with true value");
    }

    @Test
    public void testLogarithm() {
        assertEquals(calculator.logarithm(100, 10), 2.0, 0.0001, "Test logarithm withtrue value");
    }
}

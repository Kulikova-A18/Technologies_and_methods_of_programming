

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FALSEOfMyCalculatorTest
{
    MyCalculator calculator = new MyCalculator();

    @Test
    public void testSubtract() {
        assertEquals(calculator.subtract(5, 3), 3.0, "Test subtraction with false value");
    }

    @Test
    public void testMultiply() {
        assertEquals(calculator.multiply(2, 3), 5.0, "Test multiplication with false value");
    }

    @Test
    public void testDivide() {
        assertEquals(calculator.divide(6, 3), 3.0, "Test division with false value");
    }

    @Test
    public void testPower() {
        assertEquals(calculator.power(2, 3), 9.0, "Test power with false value");
    }

    @Test
    public void testLogarithm() {
        assertEquals(calculator.logarithm(100, 10), 3.0, "Test logarithm withfalse value");
    }
}

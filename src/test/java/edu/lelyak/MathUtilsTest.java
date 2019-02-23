package edu.lelyak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Nazar_Lelyak.
 */
class MathUtilsTest {

    private MathUtils mathUtils;

    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

    @Test
    void testAdd() {
        int expected = 2;
        int actual = mathUtils.add(1, 1);

        assertEquals(expected, actual,
                "Add method should add two numbers");
    }

    @Test
    void testCircleArea() {
         assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),
                 "Should return right the circle area");
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(5, 0),
                "Divide by 0 should throw Arithmetic exception");
    }
}
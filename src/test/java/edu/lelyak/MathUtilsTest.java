package edu.lelyak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
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

    @Nested
    class AddTest {
        @Test
        void testAddingTwoPositives() {
            assertEquals(4, mathUtils.add(2, 2),
                    "Add method should return the sum of two numbers");
        }

        @Test
        void testAddingTwoNegatives() {
            assertEquals( -2, mathUtils.add(-1, -1),
                    "Add method should return the sum of two numbers");
        }

        @Test
        void testAddingAPositiveAndANegative() {
            assertEquals( 0, mathUtils.add(-1 , 1),
                    "Add method should return the sum of two numbers");
        }
    }

    @Test
    void testMultiply() {
        assertAll(
                () -> assertEquals( 0, mathUtils.multiply(1, 0)),
                () -> assertEquals( 1, mathUtils.multiply(1, 1)),
                () -> assertEquals( 6, mathUtils.multiply(2, 3))
        );
    }
}
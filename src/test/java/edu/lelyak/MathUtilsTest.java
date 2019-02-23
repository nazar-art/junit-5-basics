package edu.lelyak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(expected, actual, "the add method should add two numbers");
    }

    @Test
    void testCircleRadius() {
         assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "should return right  circle area");
    }
}
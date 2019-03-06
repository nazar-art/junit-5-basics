package edu.lelyak;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Nazar_Lelyak.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    private MathUtils mathUtils;

    @BeforeAll
    /*static*/ void beforeAllInit() {
        System.out.println("Init before all");
    }

    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up...");
    }

    @Test
    @DisplayName("Testing add method")
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

    @Test
    @Disabled
    @DisplayName("TDD method. Should not run")
    void testDisabled() {
        fail("This test should be disabled");
    }
}
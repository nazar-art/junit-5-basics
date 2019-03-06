package edu.lelyak;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * @author Nazar_Lelyak.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Testing Math utils class")
public class MathUtilsTest {

    private MathUtils mathUtils;

    /**
     * Pre configuration
     */
    @BeforeAll
    /*static*/ void beforeAllInit() {
        System.out.println("Init before all");
    }

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter reporter) {
        mathUtils = new MathUtils();

        String infoMessage = String.format("Running: %s with Tags: %s\n",
                testInfo.getDisplayName(), testInfo.getTags());

        reporter.publishEntry(infoMessage);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up...");
    }

    /**
     * Tests
     */
    @Test
    @Tag("Math")
    @DisplayName("Testing add method")
    void testAdd() {
        int expected = 2;
        int actual = mathUtils.add(1, 1);

        assertEquals(expected, actual,
                "Add method should add two numbers");
    }

    @Test
    @Tag("Circle")
    void testCircleArea() {
         assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),
                 "Should return right the circle area");
    }

    @Test
    @Tag("Math")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(5, 0),
                "Divide by 0 should throw Arithmetic exception");
    }

    @Nested
    @Tag("Math")
    @DisplayName("Testing add method")
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
    @Tag("Math")
    void testMultiply() {
        assertAll(
                () -> assertEquals( 0, mathUtils.multiply(1, 0)),
                () -> assertEquals( 1, mathUtils.multiply(1, 1)),
                () -> assertEquals(-4, mathUtils.multiply(2, -2)),
                () -> assertEquals( 6, mathUtils.multiply(2, 3))
        );
    }

    @Test
    @Disabled
    @DisplayName("TDD method. Should not run")
    void testDisabled() {
        fail("This test should be disabled");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    @DisplayName("Linux test")
    void testOnLinux() {
        System.out.println("Linux is the power");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    @DisplayName("Mac test")
    void testOnMac() {
        System.out.println("Mac is fancy");
    }

    @Test
    @DisplayName("Assumption test")
    void testAssume() {
        boolean isServerUp = false;

        assumeTrue(isServerUp);
        System.out.println("Here is a test execution");
    }

    @Tag("Circle")
    @RepeatedTest(3)
    void testWithRepeat(RepetitionInfo info) {
        if (info.getCurrentRepetition() == 1) {
            System.out.println("It is first REPETITION iteration");
        }
        assertEquals(314.1592653589793,
                mathUtils.computeCircleArea(10),
                "Should return right the circle area");
    }
}
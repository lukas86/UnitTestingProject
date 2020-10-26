package testSimple;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("When running testSimple.MathUtils")
class MathUtilsTest {

    //TODO: init before testing
    //@BeforeAll or @BeforeEach
    //TODO: tear down after testing
    //@AfterAll or @AfterEach

    MathUtils mathUtils;

    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all.");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;

        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...");
    }

    @Nested
    @DisplayName("add method")
    @Tag("Math")
    class AddTest {

        @Test
        @DisplayName("when adding two positive numbers")
                                                                                //can use lambda instead of String message
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1,1), "return the right sum");
        }

        @Test
        @DisplayName("when adding two negative numbers")
        void testAddNegative() {
            assertEquals(-2, mathUtils.add(-1,-1), "return the right sum");
        }

    }




    @Test
    @DisplayName("multiply method")
    @Tag("Math")
    void testMultiply() {

        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
//        assertEquals(4, mathUtils.multiply(2, 2), "should return the right product");
        assertAll(
            () -> assertEquals(4, mathUtils.multiply(2, 2)),
            () -> assertEquals(0, mathUtils.multiply(2, 0)),
            () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );

    }

    @Test
    @Tag("Math")
    void testDivide() {
//        testSimple.MathUtils mathUtils= new testSimple.MathUtils();
        //TODO: assume -> only run test if assumption is true
        assumeTrue(true);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero exception should throw");
    }

    @Test
//    @RepeatedTest(3)
    @Tag("Circle")  //lahko uporabimo za selektivno zaganjenje testo, ki imajo določen tag
    void testComputeCircleRadius() {
//        testSimple.MathUtils mathUtils = new testSimple.MathUtils();
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }

    @Test
    @Disabled
    @DisplayName("Shoukd not pass")
    void testDisabled() {
        fail();
    }



}
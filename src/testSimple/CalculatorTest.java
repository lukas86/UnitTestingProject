package testSimple;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import testSimple.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator;

    //ARRANGE
    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @DisplayName("testAdd")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource({
            "1, 1, 2",
            "-1, 1, 0",
            "-1, -1, -2",
            "-10, 10, 0",
            "30, 20, 50",
            "345, -123, 222",
            "43, -154, -111"
    })
    void add(int a, int b, int sum) {
        assertEquals(sum, calculator.add(a,b));
    }

    @DisplayName("testSubtract")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource({
            "1, 1, 0",
            "-1, 1, -2",
            "-1, -1, 0",
            "-10, 10, -20",
            "30, 20, 10",
            "345, -123, 468",
            "43, -154, 197",
            "-123, 43, -166"
    })
    void subtract(int a, int b, int sum) {
        assertEquals(sum, calculator.subtract(a,b));
    }

}

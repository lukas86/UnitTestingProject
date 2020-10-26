package test2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({
            "3,1,4",
            "3,0,3",
            "1,2,3",
            "-10,5,-5",
            "-23,-4,-27",
            "132,-23,109",
            "34,-123,-89"
    })
    void shouldReturnASum(int a, int b, int sum) {
        assertEquals(sum, calculator.add(a, b));
    }
}

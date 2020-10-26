package SquareRootTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareRootTest {

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,1",
            "4,2",
            "9,3",
            "16,4",
            "0.25,0.5"
    })
    void rootOf(double sqr, double root) {
        assertEquals(root, Math.sqrt(sqr),0.0);
    }

    @ParameterizedTest
    @MethodSource("rootProvider")
    void providerTest(double number) {
        assertEquals(number, Math.sqrt(number) * Math.sqrt(number),0.0005);
    }

    private static DoubleStream rootProvider() {
        return IntStream.range(0, 100).asDoubleStream();
    }

}

// #1 refactor to property based test (parameterized test)

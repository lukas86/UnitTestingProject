package testSimple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testSimple.Cup;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {


    @Test
    void testObjectCreationWithAssertAll() {
        Cup cup = new Cup("Water", 75.0);
        assertAll("Correctly builds project",
                () -> assertEquals("Water", cup.getLiquidType()),
                () -> assertEquals(75, cup.getPercentFull(), 0.001)
        );
    }

    @Test
    void testObjectCreation() {
       Cup cup = new Cup("Water", 75.0);
       assertEquals("Water", cup.getLiquidType());

       assertEquals(75, cup.getPercentFull(), 0.001);
   }

    @Test
    void testIsEmpty() {
        Cup cup = new Cup("Water", 75.0);
        assertFalse(cup.isEmpty());

    }

    @Test
    void testSetLiquidWithNull() {
        Cup cup = new Cup("Water", 75.0);
        cup.setLiquidType(null);
        assertNotNull(cup.getLiquidType());

    }

    @Disabled("Disable test until Library team fixes bug 2532")
    @Test
    void testExterenalLibrary() {
        //imagine depeneding on someone else's code...
        fail();

    }

    @Test
    void testSetBadPercentThrows() {
        Cup cup = new Cup("Water", 75.0);

        assertThrows(IllegalArgumentException.class,
                () -> cup.setPercentFull(-1)
        );
    }

    public double guessThePercent(Cup cup) {
        while(true) {
            double guess = Math.random();
            if(Math.abs(guess - cup.getPercentFull()) < 100) {
                return guess;
            }
        }
    }

    @Test
    @DisplayName("This is a displayName tag, which helps tell apart")
    void testGuessThePercent() {
        Cup cup = new Cup("Water", 50);
        assertTimeoutPreemptively(Duration.ofSeconds(5),
                () -> guessThePercent(cup) > 0);
    }

}
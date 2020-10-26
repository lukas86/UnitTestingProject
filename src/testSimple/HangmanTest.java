package testSimple;

import org.junit.jupiter.api.*;
import testSimple.Hangman;

public class HangmanTest {

    @Test
    public void placeholderIsSingleUnderscoreWhenWordToGuessIsA() {
        Hangman hangman = new Hangman("a");

        Assertions.assertEquals("_", hangman.hint());
    }

}

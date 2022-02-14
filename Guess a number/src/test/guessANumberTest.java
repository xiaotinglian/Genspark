import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GuessANumberTest {

    @BeforeEach
    void setUp() {
    }


    @Test
    void guessingTooLow() {
        assertTrue(guessANumber.winOrLost(3, "shawn", 10, 5));
    }
    @Test
    void guessingTooHigh() {
        assertTrue(guessANumber.winOrLost(20, "shawn", 10, 5));
    }
    @Test
    void guessingRight() {
        assertFalse(guessANumber.winOrLost(6, "shawn", 6, 5));
    }


    @AfterEach
    void tearDown() {
    }
}
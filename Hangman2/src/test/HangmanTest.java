import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    @BeforeEach
    void setUp() {
    }


    @Test
    void guessing() {
        ArrayList<Character> test = new ArrayList<>();
        test.add('l');
        test.add('i');
        test.add('l');
        test.add('y');
        assertTrue(Hangman.printWordState("lily",test));
        assertFalse(Hangman.printWordState("yilye",test));
    }

    @Test
    void replay() {
        assertTrue(Hangman.replay("y"));
        assertFalse(Hangman.replay("n"));
    }

    @AfterEach
    void tearDown() {
    }

}

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
        assertTrue(Hangman.printWordState("yily",test));
        assertFalse(Hangman.printWordState("yilye",test));
    }


    @AfterEach
    void tearDown() {
    }
}
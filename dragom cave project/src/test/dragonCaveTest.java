package test;

import cave.dragonCave;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class dragonCaveTest {

    dragonCave dragon;

    @BeforeEach
    void setUp() {

        dragon = new dragonCave();
    }

    @Test
    void choiceOne() {

        assertEquals("You approach the cave..."+'\n'+ "It is dark and spooky..."+"\n"+ "A large dragon jumps out in front of you! He opens his jaws and..."+"\n"+ "Gobbles you down in ine bite!",dragon.Cave(1));
    }
    @Test
    void choiceTwo() {
        assertEquals("You got treasures from dragon!",dragon.Cave(2));
    }


    @AfterEach
    void tearDown() {
    }


}
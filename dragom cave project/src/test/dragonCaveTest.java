package test;
import cave.dragonCave1.dragonCave;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DragonCaveTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void choiceOne() {

        assertEquals("You approach the cave...\nIt is dark and spooky...\nA large dragon jumps out in front of you! He opens his jaws and...\nGobbles you down in ine bite!", dragonCave.Cave(1));
    }
    @Test
    void choiceTwo() {
        assertEquals("You got treasures from dragon!", dragonCave.Cave(2));
    }


    @AfterEach
    void tearDown() {
    }


}
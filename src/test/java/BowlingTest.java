import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingTest {

    private Bowling bowling;

    @BeforeEach
     void setUp() {
        bowling = new Bowling();
    }

    @Test
    @DisplayName("Gutter Game")
    void gutterGame() {
        for (int i = 0; i < 20; i++) {
            bowling.roll(0);
        }
        assertEquals(0, bowling.score());
    }

    @Test
    @DisplayName("All Single pins")
    void allSinglePins() {

        for (int i = 0; i < 20; i++) {
            bowling.roll(1);
        }
        assertEquals(20, bowling.score());
    }

    @Test
    @DisplayName("First Spare")
    void firstSpare() {
        bowling.roll(6);
        bowling.roll(4);
        bowling.roll(3);

        assertEquals(16, bowling.score());
    }

    @Test
    @DisplayName("Two Spares")
    void twoSpares() {
        bowling.roll(6);
        bowling.roll(4);
        bowling.roll(3);
        bowling.roll(7);
        bowling.roll(5);

        assertEquals(33, bowling.score());
    }

    @Test
    @DisplayName("First Strike")
    void firstStrike() {
        bowling.roll(10);
        bowling.roll(1);
        bowling.roll(1);

        assertEquals(14, bowling.score());
    }

    @Test
    @DisplayName("Perfect Game")
    void perfectGame() {
        for (int i = 0; i < 12; i++) {
            bowling.roll(10);
        }
        assertEquals(300, bowling.score());
    }

    @Test
    @DisplayName("All spares")
    void allSpares() {
        for (int i = 0; i < 21; i++) {
            bowling.roll(5);
        }
        assertEquals(150, bowling.score());
    }

    @Test
    @DisplayName("Only 10 frames scored")
    void extraRollsNotScored() {
        for (int i = 0; i < 25; i++) {
            bowling.roll(5);
        }
        assertEquals(150, bowling.score());

    }
}
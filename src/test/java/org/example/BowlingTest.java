package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//https://kata-log.rocks/bowling-game-kata


class BowlingTest {

    @Test
    @DisplayName("20 gutter balls score 0 points")
    void scoreGutterGame() {
        int[] gutterRolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals(0, Bowling.score(gutterRolls));
    }

    @Test
    @DisplayName("10 rolls of 1 point score 10 points")
    void scoreOnePointRolls(){
        int[] onePointRolls = new int[20];
        Arrays.fill(onePointRolls, 1);

        assertEquals(20, Bowling.score(onePointRolls));
    }

}
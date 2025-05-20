package org.example;

import java.util.Arrays;

public class Bowling {

    static int score(int[] rolls) {
        return Arrays.stream(rolls).sum();
    }

}

import java.util.ArrayList;

public class Bowling {

    ArrayList<Integer> rolls = new ArrayList<>();
    ArrayList<Integer> frames = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
        if (rolls.size() == 3 && isStrike()) {
            frames.add(threeBallFrame());
            rolls.remove(0);
        } else if (rolls.size() == 3 && isSpare()) {
            frames.add(threeBallFrame());
            removeNextFrame();
        } else if (rolls.size() == 3) {
            frames.add(nextFrame());
            removeNextFrame();
        }

        if (frames.size() == 10 && rolls.size() > 0) {
            rolls.clear();
        }
    }

    private boolean isStrike() {
        return rolls.get(0) == 10;
    }

    public int score() {
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            score += frames.get(i);
        }
        for (int i = 0; i < rolls.size(); i++) {
            score += rolls.get(i);
        }
        return score;
    }

    private void removeNextFrame() {
        rolls.remove(1);
        rolls.remove(0);
    }

    private boolean isSpare() {
        return 10 == nextFrame();
    }

    private int nextFrame() {
        return (rolls.get(0) + rolls.get(1));
    }

    private int threeBallFrame() {
        return rolls.get(0) + rolls.get(1) + rolls.get(2);
    }
}

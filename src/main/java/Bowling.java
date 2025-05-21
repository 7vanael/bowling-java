import java.util.ArrayList;

public class Bowling {

    ArrayList<Integer> rolls = new ArrayList<>();
    ArrayList<Integer> frames = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
        if (threeRollsUnframed()) {
            if (isStrike()) {
                frames.add(threeBallFrame());
                rolls.remove(0);
            } else if (isSpare()) {
                frames.add(threeBallFrame());
                removeNextFrame();
            } else {
                frames.add(nextFrame());
                removeNextFrame();
            }
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
        score += scoreFrames();
        score += scoreUnframedRolls();
        return score;
    }

    private int scoreFrames() {
        int frameScore = 0;
        for (int i = 0; i < frames.size(); i++) {
            frameScore += frames.get(i);
        }
        return frameScore;
    }

    private int scoreUnframedRolls() {
        int remainingRollsScore = 0;
        for (int i = 0; i < rolls.size(); i++) {
            remainingRollsScore += rolls.get(i);
        }
        return remainingRollsScore;
    }


    private void removeNextFrame() {
        rolls.remove(1);
        rolls.remove(0);
    }
    private boolean threeRollsUnframed(){
        return rolls.size() == 3;
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

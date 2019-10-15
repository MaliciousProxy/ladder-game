package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderFactory {
    private static final Random random = new Random();

    public static Ladder generateLadder(int ladderHeight, int ladderWidth) {
        List<Lines> ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(createLine(ladderWidth));
        }

        return new Ladder(ladder);
    }

    private static Lines createLine(int ladderWidth) {
        List<Boolean> lines = new ArrayList<>();
        boolean line = false;
        for (int j = 0; j < ladderWidth - 1; j++) {
            line = getNextLine(line);
            lines.add(line);
        }

        return new Lines(lines);
    }

    private static boolean getNextLine(boolean previousLine) {
        if (previousLine) {
            return false;
        }

        return random.nextBoolean();
    }
}

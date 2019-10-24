package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderFactory {
    public static Ladder create(int countOfPlayer, int height) {
        if(height <= 0) {
            throw new IllegalArgumentException("허용되지 않는 높이");
        }
        List<LadderLine> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(createLadderLine(countOfPlayer));
        }

        return new Ladder(lines);
    }

    private static LadderLine createLadderLine(int countOfPlayer) {
        List<Boolean> row = new ArrayList<>();
        row.add(false);
        for (int j = 1; j < countOfPlayer; j++) {
            if (row.get(j - 1)) {
                row.add(false);
                continue;
            }
            row.add(new Random().nextBoolean());
        }
        row.add(false);

        return new LadderLine(row);
    }
}

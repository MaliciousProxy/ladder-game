package ladder;

import java.util.Collections;
import java.util.List;

import ladder.exception.LadderHeightException;

public final class Ladder {
    private final List<Lines> ladder;

    public Ladder(final List<Lines> ladder) {
        validateLadderHeight(ladder);
        this.ladder = ladder;
    }

    private void validateLadderHeight(List<Lines> ladder) {
        if (ladder.size() <= 0) {
            throw new LadderHeightException();
        }
    }

    public int climb(int position) {
        int currentPosition = position;

        for (Lines lines : ladder) {
            currentPosition = lines.move(currentPosition);
        }

        return currentPosition;
    }

    public List<Lines> getLines() {
        return Collections.unmodifiableList(ladder);
    }
}

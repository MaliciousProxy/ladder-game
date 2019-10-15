package ladder;

import java.util.Collections;
import java.util.List;

import ladder.exception.InvalidLinesException;
import ladder.exception.InvalidPositionException;
import ladder.exception.MinimumLineException;

public final class Lines {
    private final List<Boolean> lines;

    public Lines(final List<Boolean> lines) {
        validateLines(lines);
        this.lines = lines;
    }

    private void validateLines(List<Boolean> lines) {
        validateLinesSize(lines);
        validateLinesSequence(lines);
    }

    private void validateLinesSize(List<Boolean> lines) {
        if (lines.size() <= 0) {
            throw new MinimumLineException();
        }
    }

    private void validateLinesSequence(List<Boolean> lines) {
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i - 1) && lines.get(i)) {
                throw new InvalidLinesException();
            }
        }
    }

    public int move(int currentPosition) {
        validateCurrentPosition(currentPosition);

        if (canMoveLeftSide(currentPosition)) {
            return currentPosition - 1;
        }

        if (canMoveRightSide(currentPosition)) {
            return currentPosition + 1;
        }

        return currentPosition;
    }

    private void validateCurrentPosition(int currentPosition) {
        if (currentPosition < 0) {
            throw new InvalidPositionException();
        }
    }

    private boolean canMoveLeftSide(int currentPosition) {
        if (currentPosition <= 0) {
            return false;
        }

        return lines.get(currentPosition - 1);
    }

    private boolean canMoveRightSide(int currentPosition) {
        if (currentPosition >= lines.size()) {
            return false;
        }

        return lines.get(currentPosition);
    }

    public List<Boolean> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
package ladder;

import java.util.Collections;
import java.util.List;

import ladder.exception.InvalidLinesException;
import ladder.exception.InvalidPositionException;
import ladder.exception.MinimumLineException;

public final class Lines {
    public static final int MINIMUM_LINE_COUNT = 1;
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
        if (lines.size() < MINIMUM_LINE_COUNT) {
            throw new MinimumLineException();
        }
    }

    private void validateLinesSequence(List<Boolean> lines) {
        for (int i = 1; i < lines.size(); i++) {
            final boolean previousLine = lines.get(i - 1);
            final boolean currentLine = lines.get(i);
            validateLine(previousLine, currentLine);
        }
    }

    private void validateLine(boolean previousLine, boolean currentLine) {
        if (previousLine && currentLine) {
            throw new InvalidLinesException();
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
        if (isFirstPosition(currentPosition)) {
            return false;
        }

        return lines.get(currentPosition - 1);
    }

    private boolean isFirstPosition(int currentPosition) {
        return currentPosition <= 0;
    }

    private boolean canMoveRightSide(int currentPosition) {
        if (isLastPosition(currentPosition)) {
            return false;
        }

        return lines.get(currentPosition);
    }

    private boolean isLastPosition(int currentPosition) {
        return currentPosition >= lines.size();
    }

    public List<Boolean> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
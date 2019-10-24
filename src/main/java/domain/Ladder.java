package domain;

import domain.exception.LadderSizeException;

import java.util.List;

public class Ladder {
    private List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        int length = ladderLines.get(0).getSize();

        if (!ladderLines.stream().allMatch(ladderLine -> ladderLine.getSize() == length)) {
            throw new LadderSizeException();
        }

        this.ladderLines = ladderLines;
    }

    public void play(Users users) {
        for (LadderLine ladderLine : ladderLines) {
            ladderLine.move(users);
        }
    }
}

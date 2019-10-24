package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LadderLine {
    private static final List<Boolean> TARGET = Arrays.asList(true, true);
    private static final int NO_CANDIDATE_MATCHED = -1;

    private List<Boolean> rows;

    public LadderLine(List<Boolean> rows) {
        checkSuccessiveRow(rows);
        this.rows = rows;
    }

    private void checkSuccessiveRow(List<Boolean> rows) {
        if (Collections.indexOfSubList(rows, TARGET) != NO_CANDIDATE_MATCHED) {
            throw new IllegalArgumentException();
        }
    }

    public void move(Users users) {
        int countOfUsers = users.countOfUsers();

        if (rows.size() != countOfUsers + 1) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < countOfUsers; i++) {
            if (rows.get(i + 1)) {
                users.changePosition(i, i + 1);
            }
        }
    }

    public int getSize() {
        return rows.size();
    }
}

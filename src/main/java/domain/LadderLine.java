package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LadderLine {
    private static final List<Boolean> TARGET = Arrays.asList(true, true);

    private List<Boolean> rows;

    public LadderLine(List<Boolean> rows) {
        if (Collections.indexOfSubList(rows, TARGET) != -1) {
            throw new IllegalArgumentException();
        }
        this.rows = rows;
    }

    public int getSize() {
        return rows.size();
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
}

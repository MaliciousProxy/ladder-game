package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderLineTest {

    @Test
    void 생성_테스트() {
        assertDoesNotThrow(() -> new LadderLine(Arrays.asList(false, true, false)));
    }

    @Test
    void true가_연속으로_나올_때_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new LadderLine(Arrays.asList(false, true, true, false)));
    }

    @Test
    void 움직임_테스트() {
        LadderLine ladderLine = new LadderLine(Arrays.asList(false, true, false, true, false));
        Users users = new Users(Arrays.asList("a", "b", "c", "d"));
        ladderLine.move(users);
        Users movedUsers = new Users(Arrays.asList("b", "a", "d", "c"));

        assertThat(users.getUsers()).isEqualTo(movedUsers.getUsers());
    }
}
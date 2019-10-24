package domain;

import domain.exception.LadderSizeException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {

    @Test
    void 생성_테스트() {
        LadderLine ladderLine1 = new LadderLine(Arrays.asList(false, true, false, false));
        LadderLine ladderLine2 = new LadderLine(Arrays.asList(false, true, false, false));
        assertDoesNotThrow(() -> new Ladder(Arrays.asList(ladderLine1, ladderLine2)));
    }

    @Test
    void 라인_사이즈_다를_때_생성_테스트() {
        LadderLine ladderLine1 = new LadderLine(Arrays.asList(false, true, false, false));
        LadderLine ladderLine2 = new LadderLine(Arrays.asList(false, true, false));
        assertThrows(LadderSizeException.class, () -> new Ladder(Arrays.asList(ladderLine1, ladderLine2)));
    }
}
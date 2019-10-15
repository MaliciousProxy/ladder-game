package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ladder.exception.LadderHeightException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {
    @Test
    void 사다리_생성_성공_높이가_1인_경우() {
        List<Lines> lines = Arrays.asList(new Lines(Arrays.asList(true, false, true)));
        assertDoesNotThrow(() -> new Ladder(lines));
    }

    @Test
    void 사다리_생성_예외_높이가_0인_경우() {
        List<Lines> lines = new ArrayList<>();
        assertThrows(LadderHeightException.class, () -> new Ladder(lines));
    }

    @Test
    void 결과_확인() {
        List<Lines> lines = Arrays.asList(new Lines(Arrays.asList(true, false, true)),
                new Lines(Arrays.asList(false, true, false)));
        Ladder ladder = new Ladder(lines);
        assertThat(ladder.climb(0)).isEqualTo(2);
    }
}
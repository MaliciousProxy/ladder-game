package ladder;

import java.util.ArrayList;
import java.util.Arrays;

import ladder.exception.InvalidLinesException;
import ladder.exception.InvalidPositionException;
import ladder.exception.MinimumLineException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LinesTest {
    @Test
    void 생성_성공_테스트_라인의_수가_1인_경우() {
        assertDoesNotThrow(() -> new Lines(Arrays.asList(true)));
    }

    @Test
    void 생성_예외_테스트_라인의_수가_0인_경우() {
        assertThrows(MinimumLineException.class, () -> new Lines(new ArrayList<>()));
    }

    @Test
    void 생성_예외_테스트_라인이_연달아서_생성되는_경우() {
        assertThrows(InvalidLinesException.class, () -> new Lines(Arrays.asList(true, true)));
    }

    @Test
    void 이동_예외_현재_좌표가_음수인_경우() {
        Lines lines = new Lines(Arrays.asList(true, false));
        assertThrows(InvalidPositionException.class, () -> lines.move(-1));
    }

    @Test
    void 왼쪽으로_한칸_이동_하는_경우() {
        Lines lines = new Lines(Arrays.asList(true, false));
        assertThat(lines.move(1)).isEqualTo(0);
    }

    @Test
    void 오른쪽으로_한칸_이동_하는_경우() {
        Lines lines = new Lines(Arrays.asList(true, false));
        assertThat(lines.move(0)).isEqualTo(1);
    }

    @Test
    void 이동_하지않는_경우() {
        Lines lines = new Lines(Arrays.asList(false, false));
        assertThat(lines.move(1)).isEqualTo(1);
    }
}
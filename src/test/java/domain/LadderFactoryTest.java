package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderFactoryTest {

    @Test
    void Ladder_생성_테스트() {
        assertDoesNotThrow(() -> LadderFactory.create(2, 1));
        assertDoesNotThrow(() -> LadderFactory.create(1, 1));
    }

    @Test
    void 높이가_1보다_작을때_테스트() {
        assertThrows(IllegalArgumentException.class, () -> LadderFactory.create(2, 0));
    }
}
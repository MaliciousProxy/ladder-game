package domain;

import domain.exception.InvalidNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    void 사람_이름_예외() {
        assertThrows(InvalidNameException.class, () -> new User("exception"));
    }
}
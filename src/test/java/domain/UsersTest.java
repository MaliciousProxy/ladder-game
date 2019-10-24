package domain;

import domain.exception.DuplicateUserNameException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UsersTest {

    @Test
    void 중복_이름_테스트() {
        assertThrows(DuplicateUserNameException.class, () -> new Users(Arrays.asList("A", "A")));
    }

    @Test
    void 위치_변경_테스트() {
        Users users = new Users(Arrays.asList("a", "b", "c", "d"));
        users.changePosition(1, 2);

        assertThat(users.getUsers().get(1)).isEqualTo(new User("c"));
        assertThat(users.getUsers().get(2)).isEqualTo(new User("b"));
    }
}
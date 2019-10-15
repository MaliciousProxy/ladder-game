package ladder;

import java.util.Arrays;
import java.util.List;

import ladder.exception.NotFoundPersonNameException;
import ladder.exception.NotMatchedPeopleAndRewardsNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameTest {
    private List<Lines> lines;
    private Ladder ladder;
    private List<String> people;
    private List<String> rewards;

    @BeforeEach
    void setUp() {
        lines = Arrays.asList(new Lines(Arrays.asList(true, false)),
                new Lines(Arrays.asList(false, true)));
        ladder = new Ladder(lines);
        people = Arrays.asList("pobi", "honux", "brown");
        rewards = Arrays.asList("꽝", "1000", "5000");
    }

    @Test
    void 결과_확인() {
        LadderGame ladderGame = new LadderGame(ladder, people, rewards);
        assertThat(ladderGame.run("pobi")).isEqualTo("5000");
        assertThat(ladderGame.run("honux")).isEqualTo("꽝");
        assertThat(ladderGame.run("brown")).isEqualTo("1000");
    }

    @Test
    void 결과_확인_예외_발생_참가자의_이름이_없는_경우() {
        LadderGame ladderGame = new LadderGame(ladder, people, rewards);
        assertThrows(NotFoundPersonNameException.class, () -> ladderGame.run("starkim06"));
    }

    @Test
    void 생성_예외_발생_참가자의_수와_보상의_수가_다른_경우() {
        List<String> rewards = Arrays.asList("꽝", "1000");
        assertThrows(NotMatchedPeopleAndRewardsNumberException.class,
                () -> new LadderGame(ladder, people, rewards));
    }
}
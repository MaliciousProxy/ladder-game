package ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import ladder.exception.NotFoundPersonNameException;

public class LadderGame {
    private Ladder ladder;
    private Map<String, String> results;

    public LadderGame(Ladder ladder, List<String> people, List<String> rewards) {
        this.ladder = ladder;
        initialize(ladder, people, rewards);
    }

    private void initialize(Ladder ladder, List<String> people, List<String> rewards) {
        results = new HashMap<>();

        for (int i = 0; i < people.size(); i++) {
            results.put(people.get(i), rewards.get(ladder.climb(i)));
        }
    }

    public String run(String personName) {
        String name = results.get(personName);

        if (Objects.isNull(name)) {
            throw new NotFoundPersonNameException();
        }

        return name;
    }
}

package ladder;

import java.util.*;

import ladder.exception.NotFoundPersonNameException;
import ladder.exception.NotMatchedPeopleAndRewardsNumberException;

public class LadderGame {
    private Map<String, String> results;

    public LadderGame(Ladder ladder, List<String> people, List<String> rewards) {
        validate(people, rewards);
        initialize(ladder, people, rewards);
    }

    private void validate(List<String> people, List<String> rewards) {
        if (isNotSameNumberPeopleAndRewards(people, rewards)) {
            throw new NotMatchedPeopleAndRewardsNumberException();
        }
    }

    private boolean isNotSameNumberPeopleAndRewards(List<String> people, List<String> rewards) {
        return people.size() != rewards.size();
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

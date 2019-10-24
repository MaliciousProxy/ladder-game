package domain;

import java.util.List;

public class LadderGame {
    private Users users;

    public LadderGame(List<String> names) {
        this.users = new Users(names);
    }

    public Results play(Ladder ladder, List<String> results) {
        ladder.play(users);
        return new Results(users.getUsers(), results);
    }

}

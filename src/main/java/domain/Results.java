package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
    private Map<User, String> results = new HashMap<>();

    public Results(List<User> users, List<String> results) {
        for (int i = 0; i < users.size(); i++) {
            this.results.put(users.get(i), results.get(i));
        }
    }

    public Map<User, String> getResults() {
        return Collections.unmodifiableMap(results);
    }
}

package domain;

import domain.exception.DuplicateUserNameException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Users {
    private List<User> users;

    public Users(List<String> users) {
        if (users.size() != new HashSet<>(users).size()) {
            throw new DuplicateUserNameException();
        }
        this.users = users.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    public int countOfUsers() {
        return users.size();
    }

    public void changePosition(int now, int changedPosition) {
        User user1 = users.get(now);
        User user2 = users.get(changedPosition);

        users.remove(user1);
        users.remove(user2);

        users.add(now, user2);
        users.add(changedPosition, user1);
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return users.equals(users1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}

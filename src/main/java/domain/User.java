package domain;

import domain.exception.InvalidNameException;

import java.util.Objects;

public class User {
    private static final int MAX_NAME_SIZE = 5;

    private String name;

    public User(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new InvalidNameException();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

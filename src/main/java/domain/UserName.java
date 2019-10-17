package domain;

public class UserName {
    private String name;

    public UserName(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new InvalidNameException();
        }
    }
}

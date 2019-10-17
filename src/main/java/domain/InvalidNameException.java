package domain;

public class InvalidNameException extends RuntimeException {
    public InvalidNameException() {
        super("이름은 다섯글자 이내이어야 합니다.");
    }
}

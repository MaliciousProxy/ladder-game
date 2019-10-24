package domain.exception;

public class DuplicateUserNameException extends RuntimeException {
    public DuplicateUserNameException() {
        super("이름 중복");
    }
}

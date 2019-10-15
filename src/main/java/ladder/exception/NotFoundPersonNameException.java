package ladder.exception;

public class NotFoundPersonNameException extends RuntimeException {
    public NotFoundPersonNameException() {
        super("해당하는 참가자를 찾을 수 없습니다.");
    }
}

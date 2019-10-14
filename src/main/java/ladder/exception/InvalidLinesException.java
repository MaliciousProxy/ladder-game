package ladder.exception;

public class InvalidLinesException extends RuntimeException {
    public InvalidLinesException() {
        super("라인은 연달아서 생성될 수 없습니다.");
    }
}

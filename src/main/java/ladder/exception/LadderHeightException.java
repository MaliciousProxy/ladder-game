package ladder.exception;

public class LadderHeightException extends RuntimeException {
    public LadderHeightException() {
        super("사다리의 길이는 0보다 커야합니다.");
    }
}

package ladder.exception;

public class MinimumLineException extends RuntimeException {
    public MinimumLineException() {
        super("라인의 수는 1보다 커야합니다.");
    }
}

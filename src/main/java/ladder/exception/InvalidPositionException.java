package ladder.exception;

public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException() {
        super("포지션의 좌표값은 음수 값이 될 수 없습니다.");
    }
}

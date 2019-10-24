package domain.exception;

public class LadderSizeException extends RuntimeException {
    public LadderSizeException() {
        super("사다리 사이즈 다름");
    }
}

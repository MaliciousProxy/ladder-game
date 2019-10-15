package ladder.exception;

public class NotMatchedPeopleAndRewardsNumberException extends RuntimeException {
    public NotMatchedPeopleAndRewardsNumberException() {
        super("참여할 사람과 실행 결과의 수는 같아야 합니다.");
    }
}

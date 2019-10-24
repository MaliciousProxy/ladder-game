import domain.Ladder;
import domain.LadderFactory;
import domain.LadderGame;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> userNames = InputView.inputUserNames();
        int height = InputView.inputHeight();

        List<String> results = InputView.inputResult();

        if (userNames.size() != results.size()) {
            throw new IllegalArgumentException("이름의 수와 결과의 수 불일치");
        }

        Ladder ladder = LadderFactory.create(userNames.size(), height);

        LadderGame ladderGame = new LadderGame(userNames);

        OutputView.printResult(ladder, ladderGame.play(ladder, results));
    }
}

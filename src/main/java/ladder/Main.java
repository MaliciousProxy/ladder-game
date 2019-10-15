package ladder;

import java.util.List;
import java.util.Map;

import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        List<String> people = InputView.getUserNames();
        List<String> rewards = InputView.getRewards();
        int ladderHeight = InputView.getLadderHeight();

        Ladder ladder = LadderFactory.generateLadder(ladderHeight, people.size());
        LadderGame ladderGame = new LadderGame(ladder, people, rewards);

        OutputView.printLadder(ladder, people, rewards);

        String inputResultName = InputView.getResultName();
        while (!"all".equalsIgnoreCase(inputResultName)) {
            String resultReward = ladderGame.run(inputResultName);
            OutputView.printReward(resultReward);
            inputResultName = InputView.getResultName();
        }
        final Map<String, String> finish = ladderGame.finish();
        OutputView.printAll(finish);
    }
}

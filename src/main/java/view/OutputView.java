package view;

import domain.Ladder;
import domain.Results;

public class OutputView {

    public static void printResult(Ladder ladder, Results results) {
        results.getResults().forEach((userName, s) -> System.out.println(userName + " " + s));
    }
}

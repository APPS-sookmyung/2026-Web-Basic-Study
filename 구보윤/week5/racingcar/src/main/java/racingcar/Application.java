package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RacingGameController controller = new RacingGameController(new RandomNumberGenerator());
        controller.run();
    }
}
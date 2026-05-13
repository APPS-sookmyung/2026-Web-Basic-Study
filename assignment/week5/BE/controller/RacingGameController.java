package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    private final NumberGenerator numberGenerator;

    public RacingGameController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        String[] carNames = InputView.readCarNames();
        List<Car> cars = createCars(carNames);
        int tryCount = InputView.readTryCount();

        OutputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            playRound(cars);
            OutputView.printEmptyLine();
        }

        List<String> winners = findWinners(cars);
        OutputView.printWinners(winners);
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void playRound(List<Car> cars) {
        for (Car car : cars) {
            // [과제: 02단원 - 다형성을 이용해 자동차를 전진시킵니다. 인터페이스의 추상 메서드를 호출해 보세요]
            ________.________(________.________());
            OutputView.printCarState(car);
        }
    }

    private List<String> findWinners(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
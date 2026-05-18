package racingcar.view;
import racingcar.domain.Car;
import java.util.List;

public class OutputView {
    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printCarState(Car car) {
        StringBuilder dash = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            dash.append("-");
        }
        System.out.println(car.getName() + " : " + dash);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
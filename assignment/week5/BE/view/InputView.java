package racingcar.view;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        return input.split(",");
    }

    public static int readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        try {
            // [과제: 03단원 - 웹/콘솔에서 넘어온 문자열(input)을 숫자(int)로 변환하는 메서드를 적어주세요]
            ________ ________.________(________);
        } ________ (________ e) { // [과제: 04단원 - 문자열을 숫자로 바꿀 수 없을 때 발생하는 예외 클래스 이름을 적어주세요]
            // 예외를 가로채서 우리가 원하는 비즈니스 예외로 다시 던짐
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
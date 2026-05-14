package racingcar;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        String userInput = "5"; // 콘솔에서 입력받았다고 가정
        int count = InputView.parseTryCount(userInput);
        System.out.println("시도 횟수: " + count);
        System.out.println("연산 확인: " + (count + 10)); // 15가 출력되면 성공
    }
}
package racingcar.domain;
import java.util.Random;

// [과제: 02단원 - NumberGenerator 설계도를 '구현'하는 키워드를 적어주세요]
________ ________ ________ ________ ________ {
    private static final Random random = new Random();
// [과제: 01단원 - 어노테이션을 사용해 오버라이딩 해주세요]
    @________
    public int generate() {
        return random.nextInt(10);
    }
}
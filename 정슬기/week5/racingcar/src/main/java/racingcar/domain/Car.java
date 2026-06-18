package racingcar.domain;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 5) {
            throw new RuntimeException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        }
        this.name = name.trim();
    }

    public void move(int condition) {
        if (condition >= 4) {
            this.position++;
        }
    }

    public String getName() { return name; }
    public int getPosition() { return position; }
}
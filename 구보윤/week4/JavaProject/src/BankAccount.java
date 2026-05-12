public class BankAccount {

    public int balance = 0;

    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(amount + "원이 입금되었습니다.");
        }
        else {
            System.out.println("유효하지 않은 금액입니다.");
        }
    }

    public int getBalance() {
        return this.balance;
    }
}

public class Main{

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();
        myAccount.deposit( 500);

        System.out.println(myAccount.getBalance());

        System.out.println(myAccount.balance);
    }
}

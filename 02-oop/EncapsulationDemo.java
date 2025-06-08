public class EncapsulationDemo {
    public static void main(String[] args) {
        Account account = new Account("1234567890", 1000);
        account.deposit(500);
        account.withdraw(200);
        System.out.println(account.getBalance());
    }
}


class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
}
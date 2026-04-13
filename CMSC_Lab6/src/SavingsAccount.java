
public class SavingsAccount extends BankAccount {
    private double rate;
    private int savingsNumber;
    private String accountNumber;

    public SavingsAccount(String name, double amount) {
        super(name, amount);
        rate = 0.025;
        savingsNumber = 0;
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public void postInterest() {
        double monthlyInterest = getBalance() * rate / 12;
        deposit(monthlyInterest);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    public SavingsAccount(SavingsAccount oldAccount, double amount) {
        super(oldAccount, amount);
        rate = oldAccount.rate;
        savingsNumber = oldAccount.savingsNumber + 1;
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }
}
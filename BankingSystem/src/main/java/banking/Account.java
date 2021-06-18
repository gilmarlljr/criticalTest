package banking;

/**
 * Abstract bank account class.<br>
 * <br>
 * <p>
 * Private Variables:<br>
 * {@link #accountHolder}: AccountHolder<br>
 * {@link #accountNumber}: Long<br>
 * {@link #pin}: int<br>
 * {@link #balance}: double
 */
public abstract class Account implements AccountInterface{
    private AccountHolder accountHolder;
    private Long accountNumber;
    private int pin;
    private double balance;

    public Account(AccountHolder accountHolder, Long accountNumber, int pin, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public AccountHolder getAccountHolder() {
        // complete the function
        return accountHolder;
    }

    public boolean validatePin(int attemptedPin) {
        // complete the function
        return pin == attemptedPin;
    }

    public double getBalance() {
        return balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void creditAccount(double amount) {
        balance = balance + amount;
    }

    public boolean debitAccount(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            return true;
        }
        return false;
    }
}

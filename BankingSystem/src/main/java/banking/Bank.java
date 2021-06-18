package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;

    public Bank() {
        accounts = new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        return accounts.get(accountNumber);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        long accountNumber = accounts.keySet().stream().count() + 1;
        CommercialAccount commercialAccount = new CommercialAccount(company, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, commercialAccount);
        return accountNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        long accountNumber = accounts.keySet().stream().count() + 1;
        ConsumerAccount consumerAccount = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, consumerAccount);
        return accountNumber;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        // complete the function
        Account account = accounts.get(accountNumber);
        return account != null && account.validatePin(pin);
    }

    public double getBalance(Long accountNumber) {
        Account account = getAccount(accountNumber);
        return account.getBalance();
    }

    public void credit(Long accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if(account!=null){
            account.creditAccount(amount);
        }
    }

    public boolean debit(Long accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        return account != null &&account.debitAccount(amount);
    }
}

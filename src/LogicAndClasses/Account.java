package LogicAndClasses;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Jonathan Laabs
 */
public abstract class Account {

    private final int ACCOUNT_ID;
    private final LocalDate CREATED_AT;
    
    private String accountType;
    
    protected double balance = 0;
    protected double debitInterest;
    protected double creditInterest;
    protected double minimumDeposit = 500000;
    protected double overdraftFacility;
    protected double dailyLimit;
    
    protected ArrayList<Customer> owners = new ArrayList<>();
    protected ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(int accountID, String accountType, Customer owner) {
        this.ACCOUNT_ID = accountID;
        this.accountType = accountType;
        this.CREATED_AT = LocalDate.now();
        this.owners.add(owner);
        owner.addAccount(this);
    }
    
    // protected because only used within class logic
    protected void validateSum(double sum) throws Exception {
        if (sum < 0) {
            throw new Exception("Please enter a positive number");
        }
    }
    
    // protected because only used within class logic
    protected void validateTransactionSum(double sum) throws Exception {
        if (sum <= 0) {
            throw new Exception("Please enter a positive number");
        }
    }
    
    public void deposit(double sum) throws Exception {
        validateTransactionSum(sum);
        this.balance += sum;
    }
    
    public void withdraw(double sum) throws Exception {
        validateTransactionSum(sum);
        if ((this.balance - sum) < this.minimumDeposit) {
            throw new Exception("Can't withdraw due to minimum deposit violation");
        }
        this.balance -= sum;
    }
    
    // Checks if the initial deposit is high enough, throws exception otherwise
    public void validateInitialDeposit(double sum) throws Exception {
        if (sum < this.minimumDeposit) {
            throw new Exception("Please deposit sufficient funds to create this account");
        }
    }

    public int getACCOUNT_ID() {
        return ACCOUNT_ID;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getDebitInterest() {
        return debitInterest;
    }

    public void setDebitInterest(double debitInterest) throws Exception {
        validateSum(debitInterest);
        this.debitInterest = debitInterest;
    }

    public double getCreditInterest() {
        return creditInterest;
    }

    public void setCreditInterest(double creditInterest) throws Exception {
        validateSum(creditInterest);
        this.creditInterest = creditInterest;
    }

    public double getMinimumDeposit() {
        return minimumDeposit;
    }

    public void setMinimumDeposit(double minimumDeposit) throws Exception {
        validateSum(minimumDeposit);
        this.minimumDeposit = minimumDeposit;
    }

    public double getOverdraftFacility() {
        return overdraftFacility;
    }

    public void setOverdraftFacility() throws Exception {
        // implemented in StandardGiroAccount
    }

    public double getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(double dailyLimit) throws Exception {
        validateSum(dailyLimit);
        this.dailyLimit = dailyLimit;
    }

    public LocalDate getCREATED_AT() {
        return CREATED_AT;
    }

    public ArrayList<Customer> getOwners() {
        return owners;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    
    public void addTransaction(Transaction t) {
        this.transactions.add(t);
    }
    
    public void addOwner(Customer c) {
        this.owners.add(c);
    }
    
    public void removeOwner(Customer c) {
        this.owners.remove(c);
    }
    
}

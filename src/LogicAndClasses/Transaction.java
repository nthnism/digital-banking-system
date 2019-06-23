package LogicAndClasses;

import java.time.LocalDateTime;

/**
 *
 * @author Jonathan Laabs
 */
public class Transaction {
    
    private final int TRANSACTION_ID;
    
    private final double SUM;
    private final double CURRENT_BALANCE;
    private final double UPDATED_BALANCE;
    
    private final LocalDateTime TIME_STAMP;
    
    private final Account TARGET_ACCOUNT;
    private final Account ORIGIN_ACCOUNT;
    
    private final String TRANSACTION_TYPE;
    private final String REASON_FOR_PAYMENT;

    public Transaction(int transactionId, Account targetAcc, Account originAcc, double sum, String transactionType, String reasonForPayment) throws Exception {
        this.TRANSACTION_ID = transactionId;
        this.SUM = sum;
        this.TIME_STAMP = LocalDateTime.now();
        this.TRANSACTION_TYPE = transactionType;
        this.REASON_FOR_PAYMENT = reasonForPayment;
        this.TARGET_ACCOUNT = targetAcc;
        this.CURRENT_BALANCE = this.TARGET_ACCOUNT.getBalance();
        this.ORIGIN_ACCOUNT = originAcc;
        this.ORIGIN_ACCOUNT.withdraw(sum);
        this.TARGET_ACCOUNT.deposit(sum);
        this.ORIGIN_ACCOUNT.addTransaction(this);
        this.TARGET_ACCOUNT.addTransaction(this);
        this.UPDATED_BALANCE = this.TARGET_ACCOUNT.getBalance();
    }
    
    // Overload for transactions involving only a sinlge account
    public Transaction(int transactionId, Account targetAcc, double sum, String transactionType, String reasonForPayment) throws Exception {
        this.TRANSACTION_ID = transactionId;
        this.SUM = sum;
        this.TIME_STAMP = LocalDateTime.now();
        this.TRANSACTION_TYPE = transactionType;
        this.REASON_FOR_PAYMENT = reasonForPayment;
        this.TARGET_ACCOUNT = targetAcc;
        this.CURRENT_BALANCE = this.TARGET_ACCOUNT.getBalance();    
        this.ORIGIN_ACCOUNT = null;
        if (transactionType.equals("Withdrawal")) {
            this.TARGET_ACCOUNT.withdraw(sum);
        } else {
            this.TARGET_ACCOUNT.deposit(sum);
        }
        this.TARGET_ACCOUNT.addTransaction(this);
        this.UPDATED_BALANCE = this.TARGET_ACCOUNT.getBalance();
    }
    
    @Override
    public String toString() {
        String line = "";
        String id = Integer.toString(this.TRANSACTION_ID) + "\t";
        String type = this.TRANSACTION_TYPE + "\t";
        String sum = Double.toString(this.SUM) + "\t";
        String reason = this.REASON_FOR_PAYMENT + "\t\t";
        line = id + type + sum + reason;
        return line;
    }
    
}

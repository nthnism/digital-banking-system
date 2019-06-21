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
            if (transactionType.equals("Initial Deposit")) {
                this.TARGET_ACCOUNT.validateInitialDeposit(sum);
            }
            this.TARGET_ACCOUNT.deposit(sum);
        }
        this.TARGET_ACCOUNT.addTransaction(this);
        this.UPDATED_BALANCE = this.TARGET_ACCOUNT.getBalance();
    }
    
    public String[] printStatementLineAsArray() {
        String[] lineAsArray = new String[8];
        lineAsArray[0] = Integer.toString(this.TRANSACTION_ID);
        lineAsArray[1] = this.TRANSACTION_TYPE;
        lineAsArray[2] = this.TIME_STAMP.toString();
        lineAsArray[3] = Double.toString(this.CURRENT_BALANCE);
        lineAsArray[4] = Double.toString(this.SUM);
        lineAsArray[5] = Double.toString(this.UPDATED_BALANCE);
        lineAsArray[6] = this.TARGET_ACCOUNT == this.ORIGIN_ACCOUNT 
                ? 
                    "own account" 
                : 
                    Integer.toString(this.ORIGIN_ACCOUNT.getACCOUNT_ID());
        lineAsArray[7] = this.REASON_FOR_PAYMENT;
        for (String s : lineAsArray) {
            System.out.println(s);
        }
        return lineAsArray;
    }
    
}

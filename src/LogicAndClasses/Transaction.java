package LogicAndClasses;

import java.time.LocalDateTime;

/**
 *
 * @author Jonathan Laabs
 */
public class Transaction {
    
    private final int TRANSACTION_ID;
    
    private final double SUM;
    
    private final LocalDateTime TIME_STAMP;
    
    private final Account TARGET;
    
    private final String ORIGIN;
    private final String TRANSACTION_TYPE;
    private final String ADDITIONAL_INFO;
    
    public Transaction(int transactionId, String transactionType, double sum, Account target, String originId, String additionalInfo) throws Exception {
        if (additionalInfo.equals("Initial Deposit")) {
            target.validateInitialDeposit(sum);
        }
        this.TRANSACTION_ID = transactionId;
        this.SUM = sum;
        this.TIME_STAMP = LocalDateTime.now();
        this.TRANSACTION_TYPE = transactionType;
        this.ADDITIONAL_INFO = additionalInfo;
        this.TARGET = target;
        this.TARGET.modifyBalanceBy(sum);
        this.ORIGIN = originId;
        this.TARGET.addTransaction(this);
    }
    
    @Override
    public String toString() {
        String line = "";
        String id = Integer.toString(this.TRANSACTION_ID) + "\t";
        String type = this.TRANSACTION_TYPE + "\t";
        String sum = Double.toString(this.SUM) + "\t";
        String origin = this.ORIGIN + "\t";
        String reason = this.ADDITIONAL_INFO + "\t\t";
        line = id + type + sum + origin + reason;
        return line;
    }

    public int getTRANSACTION_ID() {
        return TRANSACTION_ID;
    }

    public double getSUM() {
        return SUM;
    }

    public LocalDateTime getTIME_STAMP() {
        return TIME_STAMP;
    }

    public Account getTARGET() {
        return TARGET;
    }

    public String getORIGIN() {
        return ORIGIN;
    }

    public String getTRANSACTION_TYPE() {
        return TRANSACTION_TYPE;
    }

    public String getADDITIONAL_INFO() {
        return ADDITIONAL_INFO;
    }
    
}

package LogicAndClasses;

/**
 *
 * @author Jonathan Laabs
 */
public class StandardGiroAccount extends Account{

    public StandardGiroAccount(int accountID, String accountType, Customer owner, double sum) throws Exception {
        super(accountID, accountType, owner, sum);
    }
    
    @Override
    public void withdraw(double sum) throws Exception {
        if (sum <= 0) {
            throw new Exception("Please withdraw a posive sum");
        } else if ((this.balance - sum) < (this.minimumDeposit - this.overdraftFacility)) {
            throw new Exception("Can't withdraw due to minimum deposit violation");
        }
        this.balance -= sum;
        updateBalanceHistory();
    }
    
    @Override
    protected void setDefaults() throws Exception {
        setCreditInterest(0.99);
        setDebitInterest(11.99);
        this.setOverdraftFacility();
    }
    
    //Overload
    public void setOverdraftFacility () {
        this.overdraftFacility = this.minimumDeposit / 10;
    }
    
    @Override
    public void setMinimumDeposit(double minimumDeposit) throws Exception {
        validateSum(minimumDeposit);
        this.minimumDeposit = minimumDeposit;
        setOverdraftFacility();
    }
    
}

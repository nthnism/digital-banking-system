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
        this.minimumDeposit = minimumDeposit;
        setOverdraftFacility();
    }
    
}

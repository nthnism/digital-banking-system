package LogicAndClasses;

/**
 *
 * @author Jonathan Laabs
 */
public class StandardGiroAccount extends Account{

    public StandardGiroAccount(int accountID, String accountType, Customer owner) throws Exception {
        super(accountID, accountType, owner);
        setCreditInterest(0.99);
        setDebitInterest(11.99);
        this.setOverdraftFacility();
    }
    
    @Override
    public void withdraw(double sum) throws Exception {
        if (sum <= 0) {
            throw new Exception("Please withdraw a posive sum");
        } else if ((this.balance - sum) < (this.minimumDeposit - this.overdraftFacility)) {
            throw new Exception("Can't withdraw due to minimum deposit violation");
        }
        this.balance -= sum;
    }
    
    @Override
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

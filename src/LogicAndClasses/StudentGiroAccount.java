package LogicAndClasses;

/**
 *
 * @author Jonathan Laabs
 */
public class StudentGiroAccount extends StandardGiroAccount {

    public StudentGiroAccount(int accountID, String accountType, Customer owner, double sum) throws Exception {
        super(accountID, accountType, owner, sum);
    }
    
    // Overload
    public void setOverdraftFacility (double sum) throws Exception {
        validateSum(sum);
        this.overdraftFacility = sum;
    }
    
    @Override
    protected void setDefaults() throws Exception {
        setMinimumDeposit(0);
        setCreditInterest(0.99);
        setDebitInterest(7.99);
        setOverdraftFacility(2000);
        setDailyLimit(500);
    }
}

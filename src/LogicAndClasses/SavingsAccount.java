package LogicAndClasses;

/**
 *
 * @author Jonathan Laabs
 */
public class SavingsAccount extends Account {

    public SavingsAccount(int accountID, String accountType, Customer owner, double sum) throws Exception {
        super(accountID, accountType, owner, sum);
    }
    
    @Override
    protected void setDefaults() throws Exception {
        setCreditInterest(2.49);
    }
    
}

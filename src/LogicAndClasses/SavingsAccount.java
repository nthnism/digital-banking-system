package LogicAndClasses;

/**
 *
 * @author Jonathan Laabs
 */
public class SavingsAccount extends Account {

    public SavingsAccount(int accountID, String accountType, Customer owner) throws Exception {
        super(accountID, accountType, owner);
        setCreditInterest(2.49);
    }
    
}

package LogicAndClasses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jonathan Laabs
 */
public class Customer {

    private final int CUSTOMER_ID;
    
    private String title;
    private String firstName;
    private String lastName;
    
    private final LocalDate CREATED_AT;
    
    private final ArrayList<Account> ACCOUNTS  = new ArrayList<>();
    
    private final Pattern SPECIAL_CHARS_OR_NUMBERS = Pattern.compile("[^A-Za-z\\s\\t\\n]");

    public Customer(int customerID, String title, String firstName, String lastName) throws Exception {
        setFirstName(firstName);
        setLastName(lastName);
        this.CUSTOMER_ID = customerID;
        this.title = title;
        this.CREATED_AT = LocalDate.now();
    }
    
    public void setFirstName(String firstName) throws Exception {
        Matcher m = this.SPECIAL_CHARS_OR_NUMBERS.matcher(firstName);
        if (m.find() || firstName.trim().length() == 0) {
            throw new Exception("Please enter a valid name for first name" );
        }
        firstName = firstName.trim().replaceAll(" +", " ");
        this.firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
    }

    public void setLastName(String lastName) throws Exception {
        Matcher m = this.SPECIAL_CHARS_OR_NUMBERS.matcher(lastName);
        if (m.find() || lastName.trim().length() == 0) {
            throw new Exception("Please enter a valid name for last name" );
        }
        lastName = lastName.trim().replaceAll(" +", " ");
        this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
    }
    
    public void verifyEligibility() throws Exception {
        for (Account a : this.ACCOUNTS) {
            if (a.getAccountType().equals("Standard") || a.getAccountType().equals("Savings")) {
                return;
            }
        }
        throw new Exception("Customer needs a primary account before they can open a student account");
    }
    
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
    
    public void addAccount(Account acc) {
        this.ACCOUNTS.add(acc);
    }

    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getCREATED_AT() {
        return CREATED_AT;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Account> getACCOUNTS() {
        return ACCOUNTS;
    }
    
}

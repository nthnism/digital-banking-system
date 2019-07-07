package LogicAndClasses;

import UserInterface.MainMenu;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jonathan Laabs
 */

// Singleton class, because there should only ever be one instance
public class Logic {
    
    private static Logic instance = null;
    
    private final ArrayList<Customer> CUSTOMERS;
    private final ArrayList<Account> ACCOUNTS;
    private final ArrayList<Transaction> TRANSACTIONS;
    
    private final Pattern SPECIAL_CHARS_OR_NUMBERS = Pattern.compile("[^A-Za-z\\s\\t\\n]");
    private final Pattern CHARS_OR_SPACES = Pattern.compile("[^0-9]");
    
    private int nextCustomerId = 0;
    private int nextAccountId = 0;
    private int nextTransactionId = 0;
    
    private boolean editable = true;
    
    // Private constructor, restricted to the class itself
    private Logic() {
        this.CUSTOMERS = new ArrayList<>();
        this.ACCOUNTS = new ArrayList<>();
        this.TRANSACTIONS = new ArrayList<>();
    }
    
    // use this to initialize an object of Logic
    public static Logic getInstance() {
        if(instance == null) {
            instance = new Logic();
        }
        return instance;
    }
    
    // initialize the main menu UI and generate some test data(optional)
    public static void main(String args[]) throws Exception {
        Logic.getInstance().generateTestData();
        MainMenu.getInstance().setVisible(true);
    }
    
    // Checks if the input from the UI is a valid text, throws exception otherwise
    public void validateText(String input, String fieldName) throws Exception {
        Matcher m = SPECIAL_CHARS_OR_NUMBERS.matcher(input);
        if (m.find() || input.trim().length() == 0) {
            throw new Exception("Please enter a valid name for " + fieldName);
        }
    }
    
    // Checks if the input from the UI is a valid number, throws exception otherwise
    public void validateNumber(String input, String fieldName) throws Exception {
        Matcher m = CHARS_OR_SPACES.matcher(input);
        if (m.find() || input.trim().length() == 0 || Double.parseDouble(input) < 0) {
            throw new Exception("Please enter a valid(postive) number for " + fieldName);
        }
    }
    
    // Wrapper for Customer constructor. Injects global customer id and returns the Customer object
    // possible values for firstName && lastName: normal letters, no numbers
    public Customer createCustomer(String title, String firstName, String lastName) throws Exception {
        Customer c = new Customer(nextCustomerId, title, firstName, lastName);
        this.CUSTOMERS.add(c);
        this.nextCustomerId++;
        return c;
    }
    
    // Wrapper for Account constructor. Injects global account id and returns the Account object
    // possible values for accountType: Standard, Savings, Student
    // throws exception for invalid accountType
    public Account createAccount(String accountType, Customer owner, double initialDeposit) throws Exception {
        Account a = null;
        switch (accountType) {
            case "Standard":
                a = new StandardGiroAccount(nextAccountId, accountType, owner, initialDeposit);
                break;
            case "Savings":
                a = new SavingsAccount(nextAccountId, accountType, owner, initialDeposit);
                break;
            case "Student":
                owner.verifyEligibility();
                a = new StudentGiroAccount(nextAccountId, accountType, owner, initialDeposit);
                break;
            default:
                throw new Exception("Please select a valid account type");
        }
        if (!accountType.equals("Student") || (accountType.equals("Student") && initialDeposit != 0)) {
            this.createTransaction("Deposit", initialDeposit, a, "Initial Deposit");
//            this.createTransaction(a, initialDeposit, "Initial Deposit", "Initial Deposit in our bank");
        } 
        this.ACCOUNTS.add(a);
        this.nextAccountId++;
        return a;
    }
    
    // Wrapper for Transaction constructor. Injects global transaction id and returns the Transaction object
    // possible values for transactionType: Deposit, Withdrawal
    // throws exception for invalid transactionType
    public Transaction createTransaction(String transactionType, double sum, Account target, String additionalInfo) throws Exception {
        Transaction t = null;
        switch (transactionType) {
            case "Deposit":
                t = new Transaction(nextTransactionId, transactionType, sum, target, "own account", additionalInfo);
                break;
            case "Withdrawal":
                t = new Transaction(nextTransactionId, transactionType, -sum, target, "own account", additionalInfo);
                break;
            default:
                throw new Exception("Transactions with only one involded account can only be deposits and withdrawals");
        }
        this.TRANSACTIONS.add(t);
        this.nextTransactionId++;
        return t;
    }
    
    // Overload for createTransaction, accepts two accounts for transactions
    // Wrapper for Transaction constructor. Injects global transaction id and returns the Transaction object
    // possible values for transactionType: Transaction
    // throws exception for invalid transactionType 
    public Transaction createTransaction(String transactionType, double sum, Account origin, Account target, String additionalInfo) throws Exception {
        if (transactionType.equals("Transaction")) {
            String targetId = Integer.toString(target.getACCOUNT_ID());
            String originId = Integer.toString(origin.getACCOUNT_ID());
            Transaction t1 = new Transaction(nextTransactionId, "Outgoing", -sum, origin, targetId, additionalInfo);
            Transaction t2 = new Transaction(nextTransactionId, "Incoming", sum, target, originId, additionalInfo);
            this.TRANSACTIONS.add(t1);
            this.TRANSACTIONS.add(t2);
            this.nextTransactionId++;
            return t1;
        }
        throw new Exception("Transactions with two involded accounts can only be transactions");
    }
    
    public Customer getCustomerById(int id) throws Exception {
        for (Customer c : CUSTOMERS) {
            if (c.getCUSTOMER_ID() == id) {
                return c;
            }
        }
        throw new Exception("There is no customer with this ID");
    }
    
    public ArrayList<Customer> getCustomersByName(String name) throws Exception {
        validateText(name, "customer name");
        ArrayList<Customer> customersToReturn = new ArrayList<>();
        name = name.toLowerCase().replaceAll("\\s+","");
        for (Customer c : CUSTOMERS) {
            String customerName = (c.getFirstName() + c.getLastName()).toLowerCase().replaceAll("\\s+","");
            if (customerName.contains(name)) {
                customersToReturn.add(c);
            }
        }
        if (customersToReturn.size() <= 0) {
            throw new Exception("There is no customer with this name");
        }
        return customersToReturn;
    }
    
    public Account getAccountById(int id) throws Exception {
        for (Account a : ACCOUNTS) {
            if (a.getACCOUNT_ID() == id) {
                return a;
            }
        }
        throw new Exception("There is no account with this ID");
    }

    // Needed to display the IDs the create customer/account/transaction UIs
    public String getNextCustomerId() {
        return Integer.toString(nextCustomerId);
    }

    public String getNextAccountId() {
        return Integer.toString(nextAccountId);
    }

    public String getNextTransactionId() {
        return Integer.toString(nextTransactionId);
    }
    
    // Generate some initial testdata
    private void generateTestData() throws Exception {
        Customer c1 = this.createCustomer("Mr.", "Jonathan", "Laabs");
        Customer c2 = this.createCustomer("Mr.", "Sebastian", "Sandmann");
        Customer c3 = this.createCustomer("Mrs.", "Melanie", "Laabs");
        Customer c4 = this.createCustomer("Mrs.", "Carla", "Lindenberg");
        
        Account a1 = this.createAccount("Standard", c1, 567000);
        Account a2 = this.createAccount("Savings", c2, 550000);
        Account a3 = this.createAccount("Student", c2, 5);
        Account a4 = this.createAccount("Student", c1, 7200);
        
        Transaction t1 = this.createTransaction("Withdrawal", 20, a1, "Withdrawal at our bank");
        Transaction t2 = this.createTransaction("Deposit", 20, a2, "Deposit at our bank");
        Transaction t3 = this.createTransaction("Withdrawal", 866, a3, "Withdrawal at our bank");
        Transaction t4 = this.createTransaction("Withdrawal", 1000, a3, "Withdrawal at our bank");
        Transaction t5 = this.createTransaction("Transaction", 4560, a1, a2, "Helping a buddy out.");
        Transaction t6 = this.createTransaction("Transaction", 10, a2, a4, "for the meal.");
        Transaction t7 = this.createTransaction("Transaction", 20,a1, a3, "for the beer last week.");
    }

    // condition the ui checks to decide if opening a new panel with edit-permissions
    // is allowed. only one panel at a time should be allowed
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
}

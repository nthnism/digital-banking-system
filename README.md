# digital-banking-system

This is a small java project I did for school, realized with netbeans.
The main entry point for this app is the logic class.

In there I provide four factory methods to initialize new obejcts:

  1. createCustomer(String title, String firstName, String lastName)
  2. createAccount(String accountType, Customer owner, double initialDeposit)
  // slighty different now
  //3. createTransaction(Account targetAcc, Account originAcc, double sum, String transactionType, String reasonForPayment)
  //4. createTransaction(Account targetAcc, double sum, String transactionType, String reasonForPayment)
    (overloading the method with only one account parameter, used for deposits / withdrawals)
  
As well as some methods to verify input from the ui:

  1. validateText(String input, String fieldName)
  2. validateNumber(String input, String fieldName)

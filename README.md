# digital-banking-system

This is a small java project I did for school, realized with netbeans.
The main entry point for this app is the logic class.

This is completely uncommercial and purely for educational purpose!

In there I provide four wrapper methods to initialize new objects:

  1. createCustomer(String title, String firstName, String lastName)
  2. createAccount(String accountType, Customer owner, double initialDeposit)
  3. createTransaction(String transactionType, double sum, Account origin, Account target, String additionalInfo)
  4. createTransaction(String transactionType, double sum, Account target, String additionalInfo)
    (overloading the method with only one account parameter, used for deposits / withdrawals)
  
As well as some methods to verify input from the ui:

  1. validateText(String input, String fieldName)
  2. validateNumber(String input, String fieldName)

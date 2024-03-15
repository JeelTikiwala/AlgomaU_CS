/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 4 Q1: BitBank class
 * Any and All work in this file is my.
 **/
package Lab4;

public class JtikiwalaQ1 {
	//Q1 - Private data variables.
    private String accountNumber;
    private double accountBalance;

    //Q2 - Default Constructor.
    public JtikiwalaQ1() {
    }
    // Constructor with arguments that throws a custom exception if the account balance is negative or the account number is invalid

    public JtikiwalaQ1(String accountNumber, double accountBalance) throws BankException {
        if (accountBalance<0) {
            throw new BankException("Account Balance can't be negative. Entered Invalid Account Balance!");
        }
        if (verifyAccountNumber(accountNumber)==false) {
            throw new BankException("Invalid Account Number!");

        }
        else {
            this.accountNumber = accountNumber;
            this.accountBalance = accountBalance;
        }
    }
    // Getter method for account balance
    public double getAccountBalance() {
        return accountBalance;
    }
    // Getter method for account number
    public String getAccountNumber() {
        return accountNumber;
    }
    //Q-3: Method to deposit money into the account, throws a custom exception if the amount is negative
    public void deposit(double amount) throws BankException{
        if (amount < 0) {
            throw new BankException("Deposit amount can not be negative! Please Try again.");

        }
        // If the amount is positive, add it to the account balance and print a success message
        System.out.println("Successfully Deposited "+amount+"$");
        accountBalance += amount;
    }
    // Q-4: Method to withdraw money from the account, throws a custom exception if the amount is negative or greater than the acc balance 
    public void withdraw(double amount) throws BankException{
        if (amount < 0 ) {
            throw new BankException("Withdraw amount can not be negative! Please Try again.");
        }
        if (amount > accountBalance){
            throw new BankException("Insufficient account balance.!! ");
        }
        else {
            // If the amount is positive and less than the account balance,
            // subtract it from the acc balance and print a success message
            System.out.println("Successfully Withdrawn "+amount+"$");
            accountBalance -= amount;
        }
    }
    //Q-6: Private method to verify the account number using the given algorithm
    private boolean verifyAccountNumber(String accountNumber){
    	
        // Check that the length of the number is correct: it should be 8.
        // If the length is incorrect, the number is not valid.
        if (accountNumber.length() !=8) {
            return false;
        }
        // Move the first four characters to the end of the string.
        String changedAc_num = accountNumber.substring(4)+accountNumber.substring(0,4);
        long num=0;
        // Convert the letters to their corresponding integer values, where A = 10, B = 11, C = 12...
        for (int i = 0; i < changedAc_num.length(); i++) {
            char letter=accountNumber.charAt(i);
            if (Character.isLetter(letter)) {
                num = num*100 + ((int)Character.toUpperCase(letter)-55);
            }
            else if (Character.isDigit(letter)) {
                num=num*10 + Character.getNumericValue(letter);
            }
            else {
                return false;
            }
        }
        // Interpret the number as a Long value and divide by 11. If the
        // remainder is 1, the number is valid. Otherwise, it is not.
        return num % 11 == 1;

    }
    // Display method
    @Override
    public String toString() {
        return "BankAccount[accountNumber=" + accountNumber + ", balance=$" + accountBalance  + "]";
    }
}
//Custom Exception Class
class BankException extends Exception{

    private static final long serialVersionUID = 1L;

    public BankException(String s){
        super(s);
    }

}

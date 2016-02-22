/*
 A customer opens an account in a bank, the customer must have an initial balance of 100$ 
 while opening the account,the customer can withdraw, deposit, and check his balance any time
 he wants, the bank does not charge any fees for the 1st withdrawal but for all subsequent withdrawals,
 the bank charges some transaction fees. The bank also calculates  a certain amount of interest
 on the amount deposited by the customer as per its interest  rate. 
 Create an object oriented program to automate this problem
 */
package slidenerd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VivzBankProgram {

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); //input için
        int numberOfCustomers = 0;		
        Bank bank = new Bank();
        Customer[] c = bank.getCustomer(); // yapılış olarak Account a = customer.getAccount();'a benzer
        while (true) { // with true, loop continuously runs
            System.out.println("Please Enter your choice:");
            System.out.println("1: Add Customer");
            System.out.println("2: Deposit Money");
            System.out.println("3: Withdraw Money");
            System.out.println("4: Check Balance");
            System.out.println("5: Calculate Interest");
            System.out.println("6: Exit");
            int choice = Integer.parseInt(bufferedReader.readLine()); 
            // bufferedReader.readLine() int olarak input edildiği için parse ediliyor
            switch (choice) {
                case 1:

                    System.out.println("Creating an account for a new customer: ");
                    System.out.println("Please Enter the initial amount in your account: ");
                    double bal = Double.parseDouble(bufferedReader.readLine());
                    System.out.println("Please Enter your Account Number: ");
                    String acc = bufferedReader.readLine();
                    Account account = new Account(bal, acc);
                    System.out.println("Please Enter your Name: ");
                    String name = bufferedReader.readLine();
                    Customer customer = new Customer(name, account);
                    c[numberOfCustomers] = customer;
                    System.out.println("Customer Name: " + name + " Balance: " + bal + " Account Number: " + acc + " was added successfully to the database");
                    numberOfCustomers++;

                    break; // break komutu olmasına rağmen while loop yüzünden (case 6 seçilene kadar) döngü oluşur
                case 2:
                    /*
                     CASE 1
                     0 customers added
                     Enter account number
                     a122
                     Account Number not found
                    
                     CASE 2
                     4 customers with account numbers
                     a121 a122 a123 a124
                    
                     Enter account number
                     a125
                    
                     Account Number not found
                     
                     CASE 3
                     4 customers with account numbers
                     a121 a122 a123 a124
                    
                     Enter account number
                     a121
                    
                     How much money you want to deposit?
                     100
                     Money deposited successfully
                     */
                    System.err.println("Enter account number");
                    acc = bufferedReader.readLine();
                    if (numberOfCustomers == 0) {
                        System.err.println("Account Number Not Found");
                    } else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) { 
                        	// we are browsing through all the customers with the help of for loop
                            Account temp = c[i].getAccount(); // c[i] array'de value'yu print etme şeklidir
                            // Customer[] c = bank.getCustomer(); -> Account temp = c[i].getAccount(); sırasına dikkat
                            // type ı Account olan variable temp'e assign ediliyor
                            String accTemp = temp.getAccountNumber();
                            if (accTemp.equals(acc)) {
                                System.err.println("Please Enter the amount to deposit: ");
                                double money = Double.parseDouble(bufferedReader.readLine());
                                temp.deposit(money);
                                found = true; // boolean yerine else de kullanılabilirdi
                            }
                        }
                        if (found == false) {
                            System.err.println("Account Number Not Found");
                        }
                    }
                    break;
                case 3:
                    System.err.println("Enter account number");
                    acc = bufferedReader.readLine();
                    if (numberOfCustomers == 0) {
                        System.err.println("Account Number Not Found");
                    } else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getAccountNumber();
                            if (accTemp.equals(acc)) {
                                System.err.println("Please Enter the amount to withdraw: ");
                                double money = Double.parseDouble(bufferedReader.readLine());
                                temp.withdraw(money);
                                found = true;
                            }
                        }
                        if (found == false) {
                            System.err.println("Account Number Not Found");
                        }
                    }
                    break;
                case 4:
                    System.err.println("Enter account number");
                    acc = bufferedReader.readLine();
                    if (numberOfCustomers == 0) {
                        System.err.println("Account Number Not Found");
                    } else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getAccountNumber();
                            if (accTemp.equals(acc)) {
                                System.out.println("Balance is: "+temp.getBalance());
                                found = true;
                            }
                        }
                        if (found == false) {
                            System.err.println("Account Number Not Found");
                        }
                    }
                    break;
                case 5:
                    System.err.println("Enter account number");
                    acc = bufferedReader.readLine(); // input edilen account number acc variable da depolanıyor
                    if (numberOfCustomers == 0) {
                        System.err.println("Account Number Not Found");
                    } else {
                        boolean found = false;
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount(); // find the account object for every costumer in array
                            String accTemp = temp.getAccountNumber(); // find the account number for that account
                            if (accTemp.equals(acc)) { // compare the account number with the  input of the user
                                bank.calculateInterest(c[i]); // c[i]: current customer
                                found = true;
                            }
                        }
                        if (found == false) {
                            System.err.println("Account Number Not Found");
                        }
                    }
                    break;
                case 6:

                    System.exit(0);
                    break;
                default:
                    break;

            }

        }
    }

}

class Bank {

    private double interestRate = 8.5;
    private double transactionFees = 10;
    private Customer[] customers = new Customer[1000];
    /*
     ask which customer
     get the customer s account
     get the account s balance
     calculater interest amount on that balance and show the user what can be their total
     */

    public void calculateInterest(Customer customer) { 
        Account a = customer.getAccount(); 
        // customer.getAccount(); type ı Account olan a'ya atanıyor diye düşün
        double bal = a.getBalance();
        double interestAmount = bal * interestRate / 100;
        double totalBalance = bal + interestAmount;
        System.out.println("Interest amount " + interestAmount + " Total money after adding interest: " + totalBalance);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getTransactionFees() {
        return transactionFees;
    }

    public Customer[] getCustomer() {
        return customers; 
    }
}

class Account {

    private double balance = 100;
    private String accountNumber;
    private boolean firstTime = true;

    public Account(String acc) {
        accountNumber = acc;
    }

    public Account(double bal, String acc) {
        if (bal >= 100) {
            balance = bal;
        } else {
            balance = 100;
        }
        accountNumber = acc;
    }
    /*
     @param howMuch, ask the user how much money to deposit
     if money is positive, then add the money to the balance
     if money is negative, tell the user that he/she cannot enter negative amounts
     */

    public void deposit(double howMuch) {
        if (howMuch > 0) {
            balance = balance + howMuch;
            System.out.println(howMuch + " was successfully deposited in your account."
                    + " The new balance of your account is " + balance);
        } else {
            System.err.println("Please ensure the amount to be deposited is not negative.");
        }
    }
    /*
     @param howMuch, ask the user how much money to withdraw
     if it is the first time, user is trying to withdraw
     check if the money is positive
     if the money is negative, tell the user, they cannot perform the transaction
     if the money is positive
     check if the amount that remains in the balance after removing the money is more than 100
     if yes, remove the money
     if no, tell the user about insufficient balance
     
     */

    public void withdraw(double howMuch) {
        if (howMuch >= 0) {
            if (firstTime == true) {
                double tempBalance = balance;
                //let us say your balance=200, so tempBalance=200
                //if howMuch=150, then tempBalance-howMuch 
                //shows the money that remains after withdrawing=200-150=50
                //it means after removing howMuch from your temporary balance
                //the amount remaining is 50 which is not acceptable
                tempBalance = tempBalance - howMuch;//50
                if (tempBalance >= 100) {
                    balance = balance - howMuch;
                    System.out.println("You withdrew " + howMuch + " from your account. Your new balance is " + balance);
                } else {

                    System.err.println("Insufficient balance to remove " + howMuch);
                }
                firstTime = false;
            } else {
                Bank bank = new Bank();
                double tempBalance = balance;
                tempBalance = tempBalance - howMuch - bank.getTransactionFees();
                if (tempBalance >= 100) {
                    balance = balance - howMuch - bank.getTransactionFees();
                    System.out.println("You withdrew " + howMuch + " from your account. The transaction fees is " + bank.getTransactionFees() + ". Your new balance is " + balance);
                } else {

                    System.err.println("Insufficient balance to remove " + howMuch);
                }
            }
        } else {
            System.err.println("Please ensure the amount to be withdrawn is not negative");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}

class Customer {

    private String name;
    private Account account;

    Customer(String n, Account a) {
        name = n;
        account = a;
    }

    public void display() {
        System.out.println("Name: " + name + ", Account Number: " + 
    account.getAccountNumber() + ", Balance: " + account.getBalance()); 
    // account yerine getAccount() da yazılabilirdi
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {

        return account;
    }
}
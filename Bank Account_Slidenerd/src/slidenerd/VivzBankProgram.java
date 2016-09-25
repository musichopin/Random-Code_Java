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
//import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class VivzBankProgram {
	
    static int numberOfCustomers = 0;	


    public static void main(String[] args) throws Exception {
//    	normal'de exceptionlar�n try catch ile ��z�mlenmesi istenirdi
//    	ayr�ca main metod'da uzun olan statement'lar ba�ka metod ve/veya (inner) class'a yerle�tirilip �a��r�lmal�yd�

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        Bank bank = new Bank(); // while loop'un d���nda olma nedeni 1 tane banka yaratmam�z
//      alt: customer say�s� main metod'da belirlenirdi
//      Customer[] customers = new Customer[1000];
//      Bank bank = new Bank(customers);
        Customer[] c = bank.getCustomer(); 
        // Customer[] customers = new Customer[1000];
        // Customer[] c =customers; (" Customer[] c = new Customer[1000] ")
        // yap� olarak "Account a = customer.getAccount();" a benzer (Account'ta ise getAccountNumber vard�r)
        // loop'un d���nda olma nedeni her d�ng�de yeni array yaratmak istemememiz ve memory'den tasarruf etmek
        while (true) { // with true, loop continuously runs
            System.out.println("\nPlease Enter your choice:");
            System.out.println("1: Add Customer");
            System.out.println("2: Deposit Money");
            System.out.println("3: Withdraw Money");
            System.out.println("4: Check Balance");
            System.out.println("5: Calculate Interest");
            System.out.println("6: Exit\n");
            int choice = Integer.parseInt(bufferedReader.readLine()); 
//         alt:
//         Scanner input = new Scanner(System in) for asking then int choice = input.nextInt();
            switch (choice) {
                case 1: // Add Customer
                    System.out.println("Creating an account for a new customer: ");
                    System.out.println("Please Enter the initial amount in your account: ");
                    double bal = Double.parseDouble(bufferedReader.readLine()); // initial value
                    
//                    (main men�ye getirir)
                    if (bal<100) { // condition
                    	System.out.println("Sorry, you are required to deposit min of 100 bucks "
                    			+ "\nat the first time you create an account.");
                    	break; // 2 tane break command olabilir ayn� case'de
                    }
                    
//                    alt1: submenu'de d�ng� veya sistemden ��k��
//                    double bal;
//                    do { System.out.println("(It should be minimum of 100 bucks. "
//                    		+ "\nor Press 00 to exit.) ");
//                    bal = Double.parseDouble(bufferedReader.readLine()); // initial value and change
//                    if (bal==00) System.exit(0);
//                    } while (bal<100); // condition
                    
//                    alt2: main menu veya submenu'de d�ng�
//                    	while (bal < 100) { // condition
//                        	System.out.println("Sorry, you are required to deposit min of 100 bucks. "
//                        			+ "\nPlease try again or press 00 to go to main menu.");
//                        	bal = Double.parseDouble(bufferedReader.readLine()); // change
//                        	if (bal==00) break;
//                        }
//                    	if (bal==00) break;
                    	
                    System.out.println("Please Enter your Account Number: ");
                    String acc = bufferedReader.readLine(); 
                    // *ayn� curly bracket i�erisinde kald���ndan di�er case'ler taraf�ndan da 
                    // (initialize edildikten sonra) kullan�ld� (string ve int'ten farkl� bir format)*
                	Account account;
                    for (int i = 0; i < numberOfCustomers; i++) { // ***THIS SECTION NOT COMPLETED***
                        Account temp = c[i].getAccount();
                        String accTemp = temp.getAccountNumber();
                        while (accTemp.equals(acc)) {
                            System.err.println("Please select a different Account Number: ");
                            acc = bufferedReader.readLine();
                        }
                    }
                    account = new Account(bal, acc);          
//                    account'un banka �zerinden yarat�lmas� mant�k olarak daha do�ru:
//                    account = bank.createAccount(bal, acc);
                    
                    System.out.println("Please Enter your Name: ");
                    String name = bufferedReader.readLine();
                    Customer customer = new Customer(name, account); // class initialized
                    c[numberOfCustomers] = customer; // ***each member of class array initialized (KEY POINT)***
                    System.out.println("Customer Name: " + name + ", Balance: " + account.getBalance() + ", Account Number: " + acc 
                    		+ " \nwas added successfully to the database");
                    numberOfCustomers++;

                    break; // ***bu break komutu sadece switch statement'dan ��kmay� sa�l�yor,
                    // while loop ile ilgisi yok***
                case 2: // Deposit Money
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
                            Account temp = c[i].getAccount();
                            String accTemp = temp.getAccountNumber();
                            if (accTemp.equals(acc)) {
                                System.err.println("Please Enter the amount to deposit: ");
                                double money = Double.parseDouble(bufferedReader.readLine());
                                temp.deposit(money);
                                found = true; // ***boolean yerine else kullan�lamazd�***
                                break; // breaks out of for loop if account is matched
                            }
                        }
                        if (!found) { 
                            System.err.println("Account Number Not Found");
                        }
                    }
                    break;
                case 3: // Withdraw Money
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
                                found = true; // ***boolean yerine else kullan�lamazd�***
                                break; // breaks out of for loop if account is matched
                            }
                        }
                        if (found == false) { 
                            System.err.println("Account Number Not Found");
                        }
                    }
                    break;
                case 4: // Check Balance
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
//                             bakiyenin (case 5 gibi) banka �zerinden belirlenmesi mant�k olarak daha do�ru olurdu
//                             (ayn� durum case 2, 3 ve 4 i�in de ge�erli)
                                found = true;
                                break; // breaks out of for loop if account is matched
                            }
                        }
                        if (found == false) {
                            System.err.println("Account Number Not Found");
                        }
                    }
                    break;
                case 5: // Calculate Interest
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
                                break; // breaks out of for loop if account is matched
                            }
                        }
                        if (found == false) {
                            System.err.println("Account Number Not Found");
                        }
                    }
                    break;
                case 6: // Exit
                    System.exit(0); // main metodu komple sonland�r�r
                    break;
                default:
                    break; 
                    // sonda oldu�u i�in break zorunlu de�il ama daha anla��l�r oldu�u i�in tercih edilir
                    
            } // end of switch sta
//            ***burada "break;" olsayd� yap�lan i�lemi "kaydeder" ve while loop'dan ��kard�***
//            "continue;" olsayd� yap�lan i�lemi "kaydeder" ve while loop'a devam ederdi (anlams�z)

        } // end of while loop
        
    } // end of main method

} // end of VivzBankProgram class

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

//    alt1/t�r1: customer arrayi main metod'da olu�turulsayd�:
//    public Bank(Customer[] customers) {
//		this.customers = customers;
//	}
    
//    alt2/t�r2: customer say�s� main metodda belirlenseydi:
//    public Bank(int cust_no) {
//		this.customers = new Customer[cust_no];
//	}
    
//    alt3/t�r3: pass edilen argument sadece metod i�erisinde kullan�labilir
    
//    *not yukar�daki alternatif durumlar hem arrayin (veya listin) olu�umu i�in hem de 
//    array (list) elemanlar�n�n initialize edilmesi durumunda olmak �zere 6 (3x2) farkl� durum olu�turur*
    
    
	public void calculateInterest(Customer customer) { 
		// customer'�n array eleman� olmas�na ra�men Customer t�r�nde olmas�na dikkat
        Account a = customer.getAccount(); 
        // customer.getAccount(); type ı Account olan a'ya atanıyor diye düşün
        double bal = a.getBalance();
        double interestAmount = bal * interestRate / 100;
        double totalBalance = bal + interestAmount;
        System.out.println("Interest amount " + interestAmount + " \nTotal money after adding interest: " + totalBalance);
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
    
} // end of Bank class

class Account {
	double tempBalance;
    private double balance=100;
    private String accountNumber;
    private boolean firstTime = true;
 // tempBalance declared as field rather than local variable
 // so that it is not created every time withdraw()
 // it is being used is called and not destroyed every time
//  withdraw() is terminated

    public Account(String acc) {
        accountNumber = acc;
    }

    public Account(double bal, String acc) {
        balance += bal;
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
                    + " \nThe new balance of your account is " + balance);
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
        if (howMuch > 0) {
        	tempBalance = balance;
            if (firstTime == true) {
                //let us say your balance=200, so tempBalance=200
                //if howMuch=150, then tempBalance-howMuch 
                //shows the money that remains after withdrawing=200-150=50
                //it means after removing howMuch from your temporary balance
                //the amount remaining is 50 which is not acceptable
                tempBalance = tempBalance - howMuch; // alt: "double tempBalance;" ve "tempBalance = balance - howMuch;"
                if (tempBalance >= 100) { // alt: if ((balance - howMuch) >= 100) ... 
                    balance = balance - howMuch;
                    System.out.println("You withdrew " + howMuch + " from your account. \nYour new balance is " + balance);
                    firstTime = false; // counter yerine boolean'�n kullan�lma nedeni withdraw say�s�n� tutmamam�z
                } else {

                    System.err.println("Insufficient balance to remove " + howMuch);
                }
            } else {
                Bank bank = new Bank();
                tempBalance = tempBalance - howMuch - bank.getTransactionFees();
                if (tempBalance >= 100) {
                    balance = balance - howMuch - bank.getTransactionFees();
                    System.out.println("You withdrew " + howMuch + " from your account. "
                    		+ "\nThe transaction fees is " + bank.getTransactionFees() + ". Your new balance is " + balance);
                } else {

                    System.err.println("Insufficient balance to remove " + howMuch);
                }
            }
        } else {
            System.err.println("Please ensure the amount to be withdrawn is positive");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

} // end of Account class

class Customer {

    private String name;
    private Account account;

    Customer(String n, Account a) {
        name = n;
        account = a;
    }

//    not used
    public void display() {
        System.out.println("Name: " + name + ", Account Number: " + 
    account.getAccountNumber() + ", Balance: " + account.getBalance()); 
    }

// not used
    public String getName() {
        return name;
    }

    public Account getAccount() {

        return account;
    }
    
} // end of Customer class
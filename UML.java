public class VivzBankProgram {

public static void main(String[] args) throws Exception {
Customer[] customers = new Customer[1000];
Bank bank = new Bank(customers);
bank.addCustomer(new Customer("simon", 112));
bank.doCustomer(new Customer("jack", 110));
bank.addAnotherCust("sally", 155);
}

}



class Bank {

private Customer[] customers;

public Bank(Customer[] customers) {
this.customers = customers;
}

public void addCustomer(Customer customer) {
customers[0] = customer;
}


public void doCustomer(Customer customer) {
customer.display();
}

addAnotherCust(String a, int b) {
customers[1] = new Customer(a, b);
}

}



class Customer {

private String name;
private int no;

public Customer(String name, int no) {
this.name = name;
this.no = no;
}

public void display() {
        System.out.println("Name: " + name + ", Account Number: " + no); 
    }

}

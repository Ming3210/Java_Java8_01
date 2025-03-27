package business;

import entity.Customer;
import entity.Order;

import java.util.Scanner;
import static business.ShopManagement.customers;
import static business.ShopManagement.orders;


public class CustomerBusiness {
    public static void addCustomer(Scanner scanner){
        Customer customer = new Customer();
        customer.inputData(scanner);

    }
    public static void displayCustomers(){
        for (Customer c : customers) {
            c.toString();
        }
    }
}

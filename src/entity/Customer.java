package entity;

import java.util.Optional;
import java.util.Scanner;

import static business.ShopManagement.customers;

public class Customer implements IApp {
    private static int counter = 0;
    private int id;
    private String name;
    private Optional<String> email;

    public Customer(int id, String email , String name) {
        this.email = Optional.ofNullable(email);
        this.id = id;
        this.name = name;
    }

    public Customer() {
    }

    public static Customer findById(int customerId) {
        if(customers.contains(customerId)){
            return customers.get(customerId);

        }
        System.out.println("Ko tìm thấy người dùng");
        return null;
    };

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.id = ++counter;
        System.out.println("Enter customer's name:");
        name = scanner.nextLine();
        System.out.println("Enter customer's email:");
        email = Optional.ofNullable(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email=" + email.orElse("Không có") +
                '}';
    }
}

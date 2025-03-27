package entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Order implements IApp{
    private static int autoId = 1;
    private int id;
    private Customer customer;
    private LocalDate orderDate;
    private double totalAmount;
    private boolean status = false;

    public Order(Customer customer, int id, LocalDate orderDate, boolean status, double totalAmount) {
        this.customer = customer;
        this.id = id;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public Order() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public void updateStatus(){
        this.status = !this.status;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public void inputData(Scanner scanner) {
        id = ++autoId;
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        customer = Customer.findById(customerId);

        System.out.print("Enter order date (yyyy-MM-dd): ");
        orderDate = LocalDate.parse(scanner.next());

        System.out.print("Enter total amount: ");
        totalAmount = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderDate='" + orderDate + '\'' +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                '}';
    }


}

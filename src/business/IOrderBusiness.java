package business;

import entity.Order;

import java.util.List;
import java.util.Scanner;

public interface IOrderBusiness {
    static void addOrder(Scanner scanner) {

    }

    static void displayOrders() {

    }

    static void updateOrderStatus(Scanner scanner) {

    }

    static List<Order> getOrderOverdue() {
        return null;
    }

    static List<Order> getOrderDelivied() {
        return null;
    }

    default double getTotalRevenue() {
        return 0;
    }

}

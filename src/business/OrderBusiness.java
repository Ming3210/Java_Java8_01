package business;

import entity.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static business.ShopManagement.customers;
import static business.ShopManagement.orders;


public class OrderBusiness implements IOrderBusiness{

    public static void addOrder(Scanner scanner) {
        Order order = new Order();
        order.inputData(scanner);
    }

    public static void displayOrders() {
        for (Order order : orders) {
            order.toString();
        }
    }

    public static void updateOrderStatus(Scanner scanner) {
        System.out.println("Nhập id đơn hàng");
        int orderId = scanner.nextInt();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == orderId) {
                orders.get(i).updateStatus();
                break;
            }
        }
    }

    public static List<Order> getOrderOverdue() {
        LocalDate deadline = LocalDate.now();

        List<Order> or = orders.stream().filter(o -> o.getOrderDate().isBefore(deadline)).collect(Collectors.toList());

        return or;
    }

    public static List<Order> getOrderDelivied() {
        return List.of();
    }
}

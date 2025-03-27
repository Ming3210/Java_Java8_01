package business;

import entity.Customer;
import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static business.CustomerBusiness.addCustomer;
import static business.CustomerBusiness.displayCustomers;
import static business.OrderBusiness.*;

public class ShopManagement {
    public static List<Customer> customers = new ArrayList<>();

    public static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("**********************SHOP MENU******************* ");
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý đơn hàng");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    manageCustomers(customers, scanner);
                    break;
                case 2:
                    manageOrders(orders,scanner);
                    System.out.println("Chức năng đang phát triển...");
                    break;
                case 3:
                    System.out.println("Thoát ứng dụng...");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 3.");
            }
        }while (true);
    }

    private static void manageCustomers(List<Customer> customers, Scanner scanner) {
        do {
            System.out.println("***********************CUSTOMER MENU****************** ");
            System.out.println("1. Danh sách khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    displayCustomers();
                    break;
                case 2:
                    addCustomer(scanner);
                    break;
                case 3:
                    System.out.println("Thoát quản lý khách hàng...");
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 3.");
            }
        }while (true);
    }

    private static void manageOrders(List<Order> orders ,Scanner scanner) {
        do {
            System.out.println("***********************ORDER MENU********************** ");
            System.out.println("1. Danh sách đơn hàng");
            System.out.println("2. Thêm mới đơn hàng");
            System.out.println("3. Cập nhật trạng thái đơn hàng");
            System.out.println("4. Danh sách đơn hàng quá hạn");
            System.out.println("5. Thống kê số lượng đơn hàng đã giao (Trạng thái true) ");
            System.out.println("6. Tính tổng doanh thu các đơn hàng đã giao");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    displayOrders();
                    break;
                case 2:
                    addOrder(scanner);
                    break;
                case 3:
                    updateOrderStatus(scanner);
                    break;
                case 4:
                    getOrderOverdue();
                    break;
                case 5:
                    getOrderDelivied();
                    break;
                case 6:
                    totalRevenue();
                    break;
                case 7:
                    System.out.println("Thoát quản lý đơn hàng...");
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 7.");
                    break;
            }
        }while (true);
    }

    private static void totalRevenue() {
         double totalRevenue = 0;
//        for (Order order : orders) {
//            if (order.isStatus()) {
//                totalRevenue += order.getTotalAmount();
//            }
//        }
        List<Order> newOrd = new ArrayList<Order>();
        newOrd =  orders.stream().filter(o -> o.isStatus() != false).toList();
        for (Order order : newOrd) {
            totalRevenue += order.getTotalAmount();
        }
        System.out.println("Doanh thu các đơn hàng đã giao: " + totalRevenue);
    }


}

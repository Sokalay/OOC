package main;

import java.util.ArrayList;

import model.*;

public class CoffeeShop {
    public static final String name = "Coffee Shop";
    public static final String createOrder = "create order";
    public static final String cancelOrder = "cancel order";
    public static final String changeStatus = "change status";
    public static final String viewOrder = "view order";
    public static final String viewMenu = "view menu";
    public static final String viewCustomer = "view customer";
    public static final String viewCashier = "view cashier";
    public static final String addCashier = "add cashier";
    public static final String viewBaristar = "view baristar";
    
    public ArrayList<Customer> customers;
    public ArrayList<Staff> staffs;
    public ArrayList<Menu> menus;
    public ArrayList<Order> orders;
    public ArrayList<OrderItem> orderItems;
    public Staff loginUser;
    public CoffeeShop() {
        customers = new ArrayList<>();
        staffs = new ArrayList<>();
        menus = new ArrayList<>();
        orders = new ArrayList<>();
        orderItems = new ArrayList<>();
        staffs = new ArrayList<>();
        Admin admin = new Admin("Admin", "0123456789");
        Cashier cashier = new Cashier("Cashier", "2022-01-01", "0123456789", 123456, 5000, null, admin);
        staffs.add(admin);
        staffs.add(cashier);
    }

    //login
    public void login(String username, String password) {
        Staff tmp = new Staff(username, password);
        //verify username and password with staff arraylist using staff equal method
        for (Staff staff : staffs) {
            if (staff.equals(tmp)) {
                loginUser = staff;
                System.out.println("Login successful");
                return;
            }
        }
        System.out.println("Login failed");   
    }

    public void addCashier(String name, String phone, int idNumber, double salary, String startDate) {
        if (loginUser == null || !(loginUser.can(addCashier))) {
            System.out.println("You do not have permission to add cashier");
            return;
        }else
        {
            Cashier cashier = new Cashier(name, startDate, phone, idNumber, salary, null,loginUser);
            staffs.add(cashier);
            System.out.println("Cashier added successfully");
        }

    }
    //add menu
    public void addMenu(String name, double price) {
        Menu menu = new Menu(name, price, name);
        menus.add(menu);
    }
    //add customer
    public void addCustomer(String name, String phone) {
        Customer customer = new Customer(name, phone, 0);
        customers.add(customer);
    }
    //add order
    public void addOrder(Customer customer, Cashier cashier, double totalPrice, String status, String date) {
        Order order = new Order(customer, cashier, totalPrice, status, date);
        orders.add(order);
    }
    //add order item
    public void addOrderItem(Order order, Menu menu, int quantity) {
        OrderItem orderItem = new OrderItem(order, menu, quantity);
        orderItems.add(orderItem);
    }
    //add baristar
    // public void addBaristar(String name, String phone, int idNumber, double salary, String startDate) {
    //     Baristar baristar = new Baristar(name, phone, idNumber, salary, null);
    //     baristars.add(baristar);
    // }
    // //changeOrderStatus
    // public void changeOrderStatus(Order order, String status) {
    //     order.status = status;
    // }

}

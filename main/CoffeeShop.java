package main;

import java.util.ArrayList;
import java.util.Date;
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
        
        // Add default admin, cashier, and barista
        Admin admin = new Admin("Admin", "admin123");
        admin.setPhone("0123456789");
        Date adminStartDate = parseDate("2026-01-01");
        Cashier cashier = new Cashier("Cashier", "cashier123", "0112345678", 123456, 5000.0, adminStartDate, admin);
        Date bStartDate = parseDate("2026-01-01");
        Baristar barista = new Baristar("Barista", "barista123", "0129876543", 789123, 4500.0, bStartDate);
        
        staffs.add(admin);
        staffs.add(cashier);
        staffs.add(barista);

        // Add default menu items
        menus.add(new Menu("Espresso", 2.50, "Coffee"));
        menus.add(new Menu("Cappuccino", 3.50, "Coffee"));
        menus.add(new Menu("Latte", 3.75, "Coffee"));
        menus.add(new Menu("Croissant", 3.00, "Bakery"));
        menus.add(new Menu("Muffin", 2.75, "Bakery"));

        // Add default customers
        customers.add(new Customer("Alice", "0121112222", 10));
        customers.add(new Customer("Bob", "0113334444", 25));
    }

    private Date parseDate(String dateStr) {
        try {
            return java.sql.Date.valueOf(dateStr);
        } catch (Exception e) {
            return new java.sql.Date(System.currentTimeMillis());
        }
    }

    // login
    public void login(String username, String password) {
        Staff tmp = new Staff(username, password);
        for (Staff staff : staffs) {
            if (staff.equals(tmp)) {
                loginUser = staff;
                System.out.println("Login successful! Welcome " + staff.getName() + " (" + staff.getClass().getSimpleName() + ").");
                return;
            }
        }
        System.out.println("Login failed: Invalid username or password.");   
    }

    // logout
    public void logout() {
        if (loginUser != null) {
            System.out.println("User " + loginUser.getName() + " logged out successfully.");
            loginUser = null;
        }
    }

    // add cashier
    public void addCashier(String name, String password, String phone, int idNumber, double salary, String startDate) {
        if (loginUser == null || !(loginUser.can(addCashier))) {
            System.out.println("Permission denied: You do not have permission to add cashier.");
            return;
        }
        Date dateVal = parseDate(startDate);
        Cashier cashier = new Cashier(name, password, phone, idNumber, salary, dateVal, loginUser);
        staffs.add(cashier);
        System.out.println("Cashier '" + name + "' added successfully.");
    }

    // add baristar
    public void addBaristar(String name, String password, String phone, int idNumber, double salary, String startDate) {
        if (loginUser == null || !(loginUser.can(addCashier))) { // Admin manages staff addition
            System.out.println("Permission denied: You do not have permission to add barista.");
            return;
        }
        Date dateVal = parseDate(startDate);
        Baristar barista = new Baristar(name, password, phone, idNumber, salary, dateVal);
        staffs.add(barista);
        System.out.println("Barista '" + name + "' added successfully.");
    }

    // add menu item
    public void addMenu(String name, double price, String category) {
        // Admin or staff check if needed, let's check if admin is logged in
        if (loginUser == null || !(loginUser.can("add cashier"))) { // Simple permission check using admin capabilities
            System.out.println("Permission denied: Only Admin can add menu items.");
            return;
        }
        Menu menu = new Menu(name, price, category);
        menus.add(menu);
        System.out.println("Menu item '" + name + "' added successfully.");
    }

    // add customer
    public void addCustomer(String name, String phone) {
        if (loginUser == null || !(loginUser.can(viewCustomer))) {
            System.out.println("Permission denied: You do not have permission to add customer.");
            return;
        }
        Customer customer = new Customer(name, phone, 0);
        customers.add(customer);
        System.out.println("Customer '" + name + "' registered successfully.");
    }

    // add order
    public void addOrder(Customer customer, Cashier cashier, double totalPrice, String status, String date) {
        Order order = new Order(customer, cashier, totalPrice, status, date);
        orders.add(order);
    }

    // add order item
    public void addOrderItem(Order order, Menu menu, int quantity) {
        OrderItem orderItem = new OrderItem(order, menu, quantity);
        orderItems.add(orderItem);
    }

    // changeOrderStatus
    public void changeOrderStatus(int orderID, String status) {
        if (loginUser == null || !(loginUser.can(changeStatus))) {
            System.out.println("Permission denied: You do not have permission to change order status.");
            return;
        }
        for (Order order : orders) {
            if (order.getOrderID() == orderID) {
                order.setStatus(status);
                System.out.println("Order #" + orderID + " status changed to: " + status);
                return;
            }
        }
        System.out.println("Error: Order #" + orderID + " not found.");
    }

    public void viewMenu() {
        if (menus.isEmpty()) {
            System.out.println("No items in the menu.");
            return;
        }
        System.out.println("\n=== COFFEE SHOP MENU ===");
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers registered yet.");
            return;
        }
        System.out.println("\n=== CUSTOMER LIST ===");
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders placed yet.");
            return;
        }
        System.out.println("\n=== ORDER HISTORY ===");
        for (Order order : orders) {
            System.out.println(order);
            // Print items inside this order too!
            for (OrderItem item : orderItems) {
                if (item.getOrder().getOrderID() == order.getOrderID()) {
                    System.out.println("  - " + item);
                }
            }
        }
    }

    public void viewStaff() {
        if (loginUser == null || !(loginUser.can(addCashier))) {
            System.out.println("Permission denied: Only Admin can view staff members.");
            return;
        }
        System.out.println("\n=== STAFF MEMBERS ===");
        for (Staff s : staffs) {
            String roleStr = s.getClass().getSimpleName();
            System.out.printf("[%d] Name: %-8s | Phone: %-10s | Role: %s\n", 
                s.getId(), s.getName(), s.getPhone(), roleStr);
        }
    }
}

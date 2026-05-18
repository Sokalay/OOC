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
    public static final String viewBaristar = "view baristar";
    
    public ArrayList<Customer> customers;
    public ArrayList<Cashier> cashiers;
    public ArrayList<Menu> menus;
    public ArrayList<Order> orders;
    public ArrayList<OrderItem> orderItems;
    public ArrayList<Baristar> baristars;
    public Admin admin;
    public Staff loginUser;
    public CoffeeShop() {
        customers = new ArrayList<>();
        cashiers = new ArrayList<>();
        menus = new ArrayList<>();
        orders = new ArrayList<>();
        orderItems = new ArrayList<>();
        baristars = new ArrayList<>();
        admin = new Admin("Admin", "0123456789");
    }

    //login
    public void login(String username, String password) {
        
    }

    public void addCashier(String name, String phone, int idNumber, double salary, String startDate) {
        Cashier cashier = new Cashier(name, startDate, phone, idNumber, salary, null);
        cashiers.add(cashier);
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
    public void addBaristar(String name, String phone, int idNumber, double salary, String startDate) {
        Baristar baristar = new Baristar(name, phone, idNumber, salary, null);
        baristars.add(baristar);
    }
    //changeOrderStatus
    public void changeOrderStatus(Order order, String status) {
        order.status = status;
    }

}

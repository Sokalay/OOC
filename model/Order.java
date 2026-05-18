package model;

public class Order {
    private static int number=1;
    private static int orderID;
    private Customer customer;
    private Cashier cashier;
    private double totalPrice;
    private String status;
    private String date;
    public Order(Customer customer, Cashier cashier, double totalPrice, String status, String date) {
        this.orderID = number++;
        this.customer = customer;
        this.cashier = cashier;
        this.totalPrice = totalPrice;
        this.status = status;
        this.date = date;
    }
}

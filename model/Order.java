package model;

public class Order {
    private static int number = 1;
    private int orderID;
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

    public int getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String customerName = (customer != null) ? customer.getName() : "Walk-in";
        String cashierName = (cashier != null) ? cashier.getName() : "System";
        return String.format("Order #%d | Date: %s | Customer: %s | Cashier: %s | Total: $%.2f | Status: %s", 
            orderID, date, customerName, cashierName, totalPrice, status);
    }
}

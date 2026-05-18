package model;

public class OrderItem {
    private static int number=1;
    private int id;
    private Order order;
    private Menu menu;
    private int quantity;
    private double subTotal;
    public OrderItem(Order order, Menu menu, int quantity) {
        this.id = number++;
        this.order = order;
        this.menu = menu;
        this.quantity = quantity;
    }
}

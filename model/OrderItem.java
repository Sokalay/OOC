package model;

public class OrderItem {
    private static int number = 1;
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
        calculateSubTotal();
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
        calculateSubTotal();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateSubTotal();
    }

    public double getSubTotal() {
        return subTotal;
    }

    private void calculateSubTotal() {
        this.subTotal = (menu != null) ? quantity * menu.getPrice() : 0.0;
    }

    @Override
    public String toString() {
        String itemName = (menu != null) ? menu.getItemName() : "Unknown Item";
        double itemPrice = (menu != null) ? menu.getPrice() : 0.0;
        return String.format("%-15s x %-3d ($%5.2f each) - Subtotal: $%6.2f", itemName, quantity, itemPrice, subTotal);
    }
}

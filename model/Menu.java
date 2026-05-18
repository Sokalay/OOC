package model;

public class Menu {
    private static int number = 1;
    private int id;
    private String itemName;
    private double price;
    private String category;

    public Menu(String itemName, double price, String category) {
        this.id = number++;
        this.itemName = itemName;
        this.price = price;
        this.category = category;
    }

    public static int getNumber() {
        return number;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            System.out.println("Invalid item name");
        } else {
            this.itemName = itemName;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        //price >0 and <10
        if (price < 0 && price >10) {
            System.out.println("Price cannot be negative");
        } else {
            this.price = price;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}

package model;

public class Menu {
    private static int number = 1;
    private int id;
    private String itemName;
    private double price;
    private String category;

    public Menu(String itemName, double price, String category) {
        this.id = number++;
        setItemName(itemName);
        setPrice(price);
        setCategory(category);
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
            System.out.println("Invalid item name. Setting default to 'Espresso'");
            this.itemName = "Espresso";
        } else {
            this.itemName = itemName;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // Price must be between 0 (exclusive) and 10 (inclusive)
        if (price <= 0 || price > 10) {
            System.out.println("Invalid price: " + price + ". Setting default to 3.5");
            this.price = 3.5;
        } else {
            this.price = price;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null || category.isEmpty()) {
            this.category = "Beverage";
        } else {
            this.category = category;
        }
    }

    @Override
    public String toString() {
        return String.format("[%d] %-15s ($%.2f) - %s", id, itemName, price, category);
    }
}

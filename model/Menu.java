package model;
public class Menu {
    private static int count=1;
    private int id;
    private String name;
    private double price;
    private String category;
    private char  size;

    public Menu(String name, double price, String category, char size)
    {
        this.id = count++;
        this.setName(name);
        this.setPrice(price);   
        this.setCategory(category);
        this.setSize(size);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        // you can change unless u are a manager
        if(name == null || name.isBlank() || name.isEmpty())
        {
            this.name = "Unknown";
        }else
        {
            this.name = name;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // you have to be a manager
        if(price <3)
        {
            System.out.println("Price need to be bigger than or equal $3");
            this.price = 3;
        }else
        {
            this.price = price;
        }
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        // you need to be a manager
        this.category = category;
    }




    public char getSize() {
        return size;
    }




    public void setSize(char size) {
        this.size = size;
    }




    @Override
    public String toString() {
        return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ",  size=" + size + "]";
    }

    

}

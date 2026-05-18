package model;

public class Customer {
    private static int number=1;
    private int id;
    private String name;
    private String phone;
    private int point;
    public Customer(String name, String phone, int point) {
        this.id = number++;
        this.name = name;
        this.phone = phone;
        this.point = point;
    }

}

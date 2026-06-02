package model;

public class Customer extends Person {
    private static int number = 1;
    private int point;

    public Customer(String name, String phone, int point) {
        super(number++, name, phone);
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void addPoints(int point) {
        this.point += point;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s (%s) - Points: %d", id, name, phone, point);
    }

    @Override
    public void displayInfo() {
        System.out.println("--- Customer Info ---");
        super.displayInfo();
        System.out.println(" | Loyalty Points: " + point);
    }
}

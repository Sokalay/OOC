package model;

public class Admin extends Staff {
    public Admin(String name,String password) {
        super(name, password);
    }
    @Override
    public boolean can(String action) {
        return true;
    }
    @Override
    public void displayInfo() {
        System.out.println("--- Admin Info ---");
        super.displayInfo();
    }
}

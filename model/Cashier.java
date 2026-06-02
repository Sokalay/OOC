package model;

import java.util.Date;
import main.CoffeeShop;

public class Cashier extends Staff{

    Staff createdby;

    public Cashier(String name, String password, String phone, int idNumber, double salary, Date startDate, Staff createdby) {
        super(name, password, phone, idNumber, salary, startDate);
        this.createdby = createdby;
    }
    @Override
    public boolean can(String action) {
        if (action.equals(CoffeeShop.createOrder) || 
            action.equals(CoffeeShop.viewOrder) || 
            action.equals(CoffeeShop.viewMenu) || 
            action.equals(CoffeeShop.viewCustomer)) {
            return true;
        }
        return false;
    }
    @Override
    public void displayInfo() {
        System.out.println("--- Cashier Info ---");
        super.displayInfo();
        System.out.println(" | Created By: " + (createdby != null ? createdby.getName() : "N/A"));
    }

    public void displayInfo(String createname) {
        System.out.println("--- Cashier Info ---");
        System.out.println("Created By: " + createname);
    }
    public Staff getCreatedby() {
        System.out.println("Created By: Admin");
        return createdby;
    }
}

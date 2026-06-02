package model;

import java.util.Date;
import main.CoffeeShop;

public class Baristar extends Staff {

    public Baristar(String name, String password, String phone, int idNumber, double salary, Date startDate) {
        super(name, password, phone, idNumber, salary, startDate);
    }

    @Override
    public boolean can(String action) {
        if (action.equals(CoffeeShop.changeStatus) || 
            action.equals(CoffeeShop.viewOrder) || 
            action.equals(CoffeeShop.viewMenu)) {
            return true;
        }
        return false;
    }
    @Override
    public void displayInfo() {
        System.out.println("--- Barista Info ---");
        super.displayInfo();
    }
}

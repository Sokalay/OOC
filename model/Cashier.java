package model;

import java.util.Date;

import interfaces.Role;
import main.CoffeeShop;

public class Cashier extends Staff{
    public Cashier(String name,String password, String phone, int idNumber, double salary, Date startDate) {
        super(name, password, phone, idNumber, salary, null);
    }
    @Override
    public boolean can(String action) {
        // TODO Auto-generated method stub
        if (action.equals(CoffeeShop.createOrder) || action.equals(CoffeeShop.viewOrder)) {
            return true;
        }
        return false;
    }
}

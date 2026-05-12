package model;

import interfaces.Task;

public class Cashier extends Staff{

    public Cashier(int id, String name, String phone) {
        super(id, name, phone);
    }
    @Override
    public boolean can(String Action) {
        if(Action.equals(CoffeeShop.CreateOrder))
        {
            return true;
        }
        return false;
    }
    
}

package model;

import interfaces.Task;

public class Baristar extends Staff{

    public Baristar(int id, String name, String phone) {
        super(id, name, phone);
    }

    @Override
    public boolean can(String Action) {
        if(Action.equals(CoffeeShop.CancelOrder))
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    
    
}

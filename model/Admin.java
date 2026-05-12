package model;

public class Admin extends Staff{

    public Admin(int id, String name, String phone) {
        super(id, name, phone);
    }
    @Override
    public boolean can(String Action) {
       return true;
    }
}

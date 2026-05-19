package model;

import java.sql.Date;

import interfaces.Role;

public class Admin extends Staff {
    public Admin(String name,String password) {
        super(name, password);
    }
    @Override
    public boolean can(String action) {
        // TODO Auto-generated method stub
        return true;
    }
}

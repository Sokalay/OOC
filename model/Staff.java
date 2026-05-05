package model;
import interfaces.Displayable;

public class Staff implements Displayable{
    
    int id;
    String name;
    String phone;

    @Override
    public void display() {
        System.out.println(id);
        System.out.println(name);
        System.out.println(phone);
    }
    @Override
    public void displayName() {
        System.out.println(name);
        
    }
    
    
}

package model;
import interfaces.Buyable;
import interfaces.Displayable;

public class Staff implements Displayable, Buyable{
    
    int id;
    String name;
    String phone;

    @Override
    public void display() {
       
    }
    @Override
    public void displayName() {
        System.out.println("hasd");
    }
    @Override
    public void buy() {
        System.out.println("buy");
    }

    
}

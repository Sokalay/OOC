package model;

import interfaces.Buyable;
import interfaces.Displayable;

public class Customer implements Displayable, Buyable {
    private static int increase=1;
    private int id;
    private String name;
    private String phone;
    private double balance;
    public Customer(String name, String phone, double balance) {
        this.id = increase++;
        // increase=increase+1;
        System.out.println(increase);
        setName(name);
        setPhone(phone);
        setBalance(balance);
    }

    
    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", balance=" + balance + "]";
    }

    
    public int getId() {
        
        return id;
    }
    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    private void setPhone(String phone) {
        this.phone = phone;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        if(balance < 0 && balance>100)
        {
            System.out.println("balance cannot be negative");
            this.balance = 0;
        }else
        {
            this.balance = balance;
        }
    }


    @Override
    public void display() {
       
       System.out.println(this.toString());
    }


    @Override
    public void displayName() {
        System.out.println(name);
    }


    @Override
    public void buy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buy'");
    }
   
    
    


}

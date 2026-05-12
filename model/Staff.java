package model;
import interfaces.Buyable;
import interfaces.Displayable;
import interfaces.Task;

public class Staff implements Task{
    
    private int id;
    private String name;
    private String phone;

    public Staff(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public boolean can(String Action) {
        return false;
    }
    
}

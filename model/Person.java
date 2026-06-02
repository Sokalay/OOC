package model;

public class Person {
    protected int id;
    protected String name;
    protected String phone;

    public Person(int id, String name, String phone) {
        this.id = id;
        setName(name);
        setPhone(phone);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.isEmpty() || (phone.length() != 9 && phone.length() != 10) || 
            !(phone.startsWith("012") || phone.startsWith("011")) || !phone.matches("\\d+")) 
        {
            System.out.println("Invalid phone number. Setting default to 0123456789.");
            this.phone = "0123456789";
        } else {
            this.phone = phone;
        }
    }

    public void displayInfo() {
        System.out.print("ID: " + id + " | UserName: " + name + " | Phone: " + phone);
    }
    
}

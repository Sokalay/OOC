package model;

import java.sql.Date;

import interfaces.Role;

public class Admin implements Role {
     private static int number=1;
    private int id;
    private String name;
    private String password;
    private String phone;
    private int idNumber;
    private double Salary;
    private Date startDate;
    private Date endDate;

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Admin(String name,String password, String phone, int idNumber, double salary, Date startDate) {
        this.id = number++;
        this.setName(name);
        this.setPassword(password);
        this.setPhone(phone);
        this.setIdNumber(idNumber);
        this.setSalary(salary);
        this.setStartDate(startDate);
    }

    //why?
    public static int getNumber() {
        return number;
    }
    private String getName() {
        return name;
    }
    private String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    private void setName(String name) {
        //name need to be at least 4 letters, max 8 letters, cannot be empty or null
        if (name.length() < 4 || name.length() > 8 || name.isEmpty() || name == null) {
            System.out.println("Invalid name");
            System.out.println("User 1 is ur default username");
            this.name = "User 1";
        } else {
            this.name = name;
        }
        
    }
    private String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        //phone need to be 9 or 10 digits, cannot be empty or null start with 012, 011
        if (phone.length() != 9 && phone.length() != 10) 
        {
            System.out.println("Invalid phone number");
            System.out.println("User 1 is ur default phone number");
            this.phone = "0123456789";
        }else{
                
            this.phone = phone;
        }
    }
    public int getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
    public double getSalary() {
        return Salary;
    }
    public void setSalary(double salary) {
        Salary = salary;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    @Override
    public boolean can(String action) {
        // TODO Auto-generated method stub
        return true;
    }
}

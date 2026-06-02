package model;


import java.util.Date;

import interfaces.Role;

public class Staff extends Person implements Role {
    private static int number = 1;
    private String password;
    private int idNumber;
    private double Salary;
    private Date startDate;
    private Date endDate;

    // register
    public Staff(String name, String password, String phone, int idNumber, double salary, Date startDate) {
        super(number++, name, phone);
        this.setPassword(password);
        this.setIdNumber(idNumber);
        this.setSalary(salary);
        this.setStartDate(startDate);
    }

    // login
    public Staff(String name, String password) {
        super(0, name, null);
        this.setPassword(password);
    }

    public static int getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setName(String name) {
        // Staff name validation: must be 4 to 8 characters
        if (name == null || name.isEmpty() || name.length() < 4 || name.length() > 8) {
            System.out.println("Invalid staff name. Setting default to 'User 1'.");
            super.setName("User 1");
        } else {
            super.setName(name);
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
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Staff)) return false;
        Staff other = (Staff) obj;
        if (name == null || other.name == null) return false;
        if (!name.equals(other.name)) return false;
        if (password == null || other.password == null) return false;
        if (!password.equals(other.password)) return false;
        return true;
    }
    @Override
    public void displayInfo() {
        // TODO Auto-generated method stub
        super.displayInfo();
        System.out.println(" | ID Number: " + idNumber + " | Salary: " + Salary + " | Start Date: " + startDate + " | End Date: " + (endDate != null ? endDate : "N/A"));
    }
}

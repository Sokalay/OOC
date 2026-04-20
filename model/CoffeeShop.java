package model;

import java.util.ArrayList;

public class CoffeeShop {
     String shopName;
     ArrayList<Staff> staffs = new ArrayList<>();
     ArrayList<Menu> menus = new ArrayList<>();
     ArrayList<Customer> customers = new ArrayList<>();
     public CoffeeShop(String shopName, ArrayList<Staff> staffs, ArrayList<Menu> menus, ArrayList<Customer> customers) {
          this.shopName = shopName;
          this.staffs = staffs;
          this.menus = menus;
          this.customers = customers;
     }
     

}

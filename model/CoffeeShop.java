package model;

import java.util.ArrayList;

public class CoffeeShop{

     public static final String CreateOrder = "Create Order";
     public static final String CancelOrder = "Cancel Order";

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

     @Override
     public String toString() {
         // TODO Auto-generated method stub
         return super.toString();
     }
     

}

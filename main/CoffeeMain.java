package main;

import java.lang.classfile.CustomAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import interfaces.Displayable;
import model.Customer;
import model.Menu;
import model.Staff;

public class CoffeeMain {
    public static void main(String[] args) {
        ArrayList<Displayable> list = new ArrayList<>();
        
        Staff s = new Staff(1,"staff1","12345");
        s.setName("Hello");

        Customer c = new Customer("Customer1", "12345678", 100);

        list.add(s);
        list.add(c);

        if(list.get(0) instanceof Staff)
        {
            Staff s1 = (Staff) list.get(1);
        }else
        {
            Staff s1 = (Staff) list.get(0);
        }


        // for (Displayable d : list) {
        //     System.out.println("test");
        //     d.display();

        // }



        // System.out.println("test");

        //  HashMap<Integer, String> cMap = new HashMap<Integer, String>();
        // cMap.put(1, "ant");
        // cMap.put(2, "bear");
        // cMap.put(3, "cat");
        // cMap.put(4, "dog");
        // cMap.put(5, "elepant");
        // cMap.put(5, "fox");
        
        // for(int i=1;i<=5;i++)
        // {
        //     System.out.println(cMap.get(i));
        // }

        // HashSet<String> cName = new HashSet<>();
        // cName.add("cat");
        // cName.add("bear");
        // cName.add("Ant");
        // cName.add("bear");
        // cName.add("dog");
        // cName.add("elepant");
        //  for (String string : cName) {
        //     System.out.println(string);
        // }
        
        // Menu menu1 = new Menu("latte", 3, "drink", 'M');

        // Menu menu2 = new Menu("matcha", 4, "drink", 'M');
        //  Menu menu3 = new Menu("chocolate", 4, "drink", 'M');

        // TreeSet<Menu> menuList = new TreeSet<Menu>();
        // menuList.add(menu1);
        // menuList.add(menu2);
        // menuList.add(menu3);

        // for (Menu menu : menuList) {
        //     System.out.println(menu);
        // }


        // ArrayList<Menu> menuList = new ArrayList<Menu>();
        // menuList.add(0, menu1);
        // menuList.add(1, menu2);
        // menuList.addFirst(menu3);
        // menuList.addFirst(menu3);

        // for (Menu menu : menuList) {
        //     System.out.println(menu);
        // }






        // HashMap<Integer, String> cMap = new HashMap<Integer, String>();
        // cMap.put(1, "ant");
        // cMap.put(2, "bear");
        // cMap.put(3, "cat");
        // cMap.put(4, "dog");
        // cMap.put(5, "elepant");
        // cMap.put(5, "fox");
        
        // for(int i=1;i<=5;i++)
        // {
        //     System.out.println(cMap.get(i));
        // }
        // TreeSet<String> cName = new TreeSet<>();
        // cName.add("cat");
        // cName.add("bear");
        // cName.add("Ant");
        // cName.add("bear");
        // cName.add("dog");
        // cName.add("elepant");
        //  for (String string : cName) {
        //     System.out.println(string);
        // }



        // ArrayList<String> customerName = new ArrayList<String>();
        // customerName.add("Ant");
        // customerName.add(0, "bear");
        // customerName.addFirst("cat");

        // for (String string : customerName) {
        //     System.out.println(string);
        // }


        // Customer c = new Customer("abc", "123456789", 50);
        // Customer c1 = new Customer("abc1", "023456789", 60);
        // Customer c2 = new Customer("abc2", "023456719", 70);

        // System.out.println(c);
        // System.out.println(c1);
        // System.out.println(c2);











        
        // Menu coffee = new Menu(1,"Coffee",-5, "coffee",'M');

        // coffee.setPrice(-5);


        // System.out.println(coffee.getPrice());
 
    }
}

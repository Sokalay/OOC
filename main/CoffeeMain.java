package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import model.Customer;

public class CoffeeMain {
    public static void main(String[] args) {

        HashMap<Integer, String> cMap = new HashMap<Integer, String>();
        cMap.put(1, "ant");
        cMap.put(2, "bear");
        cMap.put(3, "cat");
        cMap.put(4, "dog");
        cMap.put(5, "elepant");
        cMap.put(5, "fox");
        
        for(int i=1;i<=5;i++)
        {
            System.out.println(cMap.get(i));
        }
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

package main;

import java.util.Scanner;

public class coffeeshopMain {
    public static void main(String[] args) {

        //Scanner
        Scanner sc = new Scanner(System.in);

        CoffeeShop coffeeShop = new CoffeeShop();
        //create switch login and exit program
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    //ask user for username and password
                    System.out.println("Input username");
                    String username = sc.nextLine();
                    System.out.println("input password: ");
                    String passString = sc.nextLine();
                    coffeeShop.login(username, passString);
                    if (coffeeShop.loginUser != null) {
                        System.out.println("Login successful");
                        viewOption(coffeeShop);
                    } else {
                        System.out.println("Login failed");
                    }
                    break;
                case 2:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

    }
    public static void viewOption(CoffeeShop coffeeShop)
    {
        while(true)
        {
            //menu to add cashier, add baristar, add order 
            System.out.println("1. Add cashier");
            System.out.println("2. Add baristar");
            System.out.println("3. Add order");
            System.out.println("4. Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                    coffeeShop.addCashier("John", "0123456789", 123456, 5000, "2022-01-01");
                    break;
                case 2:
                    System.out.println("Add baristar");
                    break;
                case 3:
                    System.out.println("Add order");
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}

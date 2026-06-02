package main;

import java.util.Scanner;
import java.util.ArrayList;
import model.*;

public class coffeeshopMain {
    public static void main(String[] args) {

        ArrayList<Person> personList = new ArrayList<>();

        Customer customer1 = new Customer("Alice", "0121112222", 10);

        personList.add(customer1);

        Cashier cashier1 = new Cashier("Bob", "cashier123", "0113334444", 123456, 5000.0, java.sql.Date.valueOf("2026-01-01"), null);
        personList.add(cashier1);
        cashier1.getCreatedby();

        Baristar barista1 = new Baristar("Charlie", "barista123", "0129876543", 789123, 4500.0, java.sql.Date.valueOf("2026-01-01"));
        personList.add(barista1);

        for (Person p : personList) {
            p.displayInfo();
            if(p instanceof Cashier) {
                Cashier tmp = (Cashier) p;
                System.out.println(" (Role: Cashier)");
                tmp.getCreatedby();

            }
        }

        // ArrayList<Customer> customers = new ArrayList<>();
        // ArrayList<Staff> staffs = new ArrayList<>();
        // ArrayList<Admin> admins = new ArrayList<>();
        // // Scanner sc = new Scanner(System.in);
        // CoffeeShop coffeeShop = new CoffeeShop();
        
        // System.out.println("=========================================");
        // System.out.println("    Welcome to the " + CoffeeShop.name);
        // System.out.println("=========================================");

        // while (true) {
        //     if (coffeeShop.loginUser == null) {
        //         // Not logged in
        //         System.out.println("\n1. Login");
        //         System.out.println("2. Exit");
        //         int choice = readInt(sc, "Choose an option: ");
                
        //         switch (choice) {
        //             case 1:
        //                 System.out.println("\n--- Staff Login ---");
        //                 String username = readString(sc, "Input username: ");
        //                 String password = readString(sc, "Input password: ");
        //                 coffeeShop.login(username, password);
        //                 break;
        //             case 2:
        //                 System.out.println("Exiting " + CoffeeShop.name + ". Goodbye!");
        //                 System.exit(0);
        //                 break;
        //             default:
        //                 System.out.println("Invalid choice. Please choose 1 or 2.");
        //                 break;
        //         }
        //     } else {
        //         // Logged in
        //         Staff user = coffeeShop.loginUser;
        //         if (user instanceof Admin) {
        //             showAdminMenu(sc, coffeeShop);
        //         } else if (user instanceof Cashier) {
        //             showCashierMenu(sc, coffeeShop);
        //         } else if (user instanceof Baristar) {
        //             showBaristaMenu(sc, coffeeShop);
        //         } else {
        //             System.out.println("Unknown staff role. Logging out.");
        //             coffeeShop.logout();
        //         }
        //     }
        // }
    }

    private static void showAdminMenu(Scanner sc, CoffeeShop cs) {
        System.out.println("\n=== ADMIN DASHBOARD ===");
        System.out.println("1. Add Cashier");
        System.out.println("2. Add Barista");
        System.out.println("3. Add Menu Item");
        System.out.println("4. View All Staff");
        System.out.println("5. View Menu");
        System.out.println("6. Log Out");
        
        int choice = readInt(sc, "Select an option: ");
        switch (choice) {
            case 1:
                System.out.println("\n--- Add New Cashier ---");
                String name = readString(sc, "Enter Cashier Name (4-8 characters): ");
                String password = readString(sc, "Enter Password: ");
                String phone = readString(sc, "Enter Phone (9-10 digits, starts with 012/011): ");
                int idNum = readInt(sc, "Enter National ID Number: ");
                double salary = readDouble(sc, "Enter Monthly Salary: ");
                String startDate = readString(sc, "Enter Start Date (YYYY-MM-DD): ");
                cs.addCashier(name, password, phone, idNum, salary, startDate);
                break;
            case 2:
                System.out.println("\n--- Add New Barista ---");
                String bName = readString(sc, "Enter Barista Name (4-8 characters): ");
                String bPassword = readString(sc, "Enter Password: ");
                String bPhone = readString(sc, "Enter Phone (9-10 digits, starts with 012/011): ");
                int bIdNum = readInt(sc, "Enter National ID Number: ");
                double bSalary = readDouble(sc, "Enter Monthly Salary: ");
                String bStartDate = readString(sc, "Enter Start Date (YYYY-MM-DD): ");
                cs.addBaristar(bName, bPassword, bPhone, bIdNum, bSalary, bStartDate);
                break;
            case 3:
                System.out.println("\n--- Add New Menu Item ---");
                String itemName = readString(sc, "Enter Item Name: ");
                double itemPrice = readDouble(sc, "Enter Price (0 to 10): ");
                String itemCategory = readString(sc, "Enter Category (e.g. Coffee, Bakery): ");
                cs.addMenu(itemName, itemPrice, itemCategory);
                break;
            case 4:
                cs.viewStaff();
                break;
            case 5:
                cs.viewMenu();
                break;
            case 6:
                cs.logout();
                break;
            default:
                System.out.println("Invalid option. Please choose between 1 and 6.");
                break;
        }
    }

    private static void showCashierMenu(Scanner sc, CoffeeShop cs) {
        System.out.println("\n=== CASHIER DASHBOARD ===");
        System.out.println("1. View Menu");
        System.out.println("2. Register New Customer");
        System.out.println("3. View Customers");
        System.out.println("4. Create Order");
        System.out.println("5. View Order History");
        System.out.println("6. Log Out");
        
        int choice = readInt(sc, "Select an option: ");
        switch (choice) {
            case 1:
                cs.viewMenu();
                break;
            case 2:
                System.out.println("\n--- Register New Customer ---");
                String custName = readString(sc, "Enter Customer Name: ");
                String custPhone = readString(sc, "Enter Customer Phone: ");
                cs.addCustomer(custName, custPhone);
                break;
            case 3:
                cs.viewCustomers();
                break;
            case 4:
                System.out.println("\n--- Create New Order ---");
                cs.viewCustomers();
                int custId = readInt(sc, "Enter Customer ID (or 0 for Walk-in): ");
                Customer customer = null;
                if (custId != 0) {
                    for (Customer c : cs.customers) {
                        if (c.getId() == custId) {
                            customer = c;
                            break;
                        }
                    }
                    if (customer == null) {
                        System.out.println("Customer ID not found. Proceeding as Walk-in.");
                    }
                }
                
                ArrayList<OrderItem> items = new ArrayList<>();
                double total = 0.0;
                
                while (true) {
                    cs.viewMenu();
                    int itemId = readInt(sc, "Enter Menu Item ID to add (or 0 to complete, -1 to cancel order): ");
                    if (itemId == 0) {
                        break;
                    }
                    if (itemId == -1) {
                        System.out.println("Order creation cancelled.");
                        return;
                    }
                    Menu selectedMenu = null;
                    for (Menu m : cs.menus) {
                        if (m.getId() == itemId) {
                            selectedMenu = m;
                            break;
                        }
                    }
                    if (selectedMenu == null) {
                        System.out.println("Invalid Menu Item ID. Try again.");
                        continue;
                    }
                    int qty = readInt(sc, "Enter Quantity: ");
                    if (qty <= 0) {
                        System.out.println("Quantity must be positive. Try again.");
                        continue;
                    }
                    
                    OrderItem oItem = new OrderItem(null, selectedMenu, qty);
                    items.add(oItem);
                    total += oItem.getSubTotal();
                    System.out.println("Added: " + oItem);
                }
                
                if (items.isEmpty()) {
                    System.out.println("No items in order. Order cancelled.");
                    return;
                }
                
                // Construct Order
                Cashier loggedInCashier = (Cashier) cs.loginUser;
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String orderDate = sdf.format(new java.util.Date());
                Order order = new Order(customer, loggedInCashier, total, "Pending", orderDate);
                cs.orders.add(order);
                
                // Link items to the order and save
                for (OrderItem oItem : items) {
                    oItem.setOrder(order);
                    cs.orderItems.add(oItem);
                }
                
                // Award points
                if (customer != null) {
                    int pointsAwarded = (int) total;
                    customer.addPoints(pointsAwarded);
                    System.out.println("Awarded " + pointsAwarded + " points to customer " + customer.getName() + " (Current points: " + customer.getPoint() + ").");
                }
                
                System.out.println("\nOrder created successfully!");
                System.out.println(order);
                for (OrderItem oItem : items) {
                    System.out.println("  " + oItem);
                }
                break;
            case 5:
                cs.viewOrders();
                break;
            case 6:
                cs.logout();
                break;
            default:
                System.out.println("Invalid option. Please choose between 1 and 6.");
                break;
        }
    }

    private static void showBaristaMenu(Scanner sc, CoffeeShop cs) {
        System.out.println("\n=== BARISTA DASHBOARD ===");
        System.out.println("1. View Orders");
        System.out.println("2. Update Order Status");
        System.out.println("3. View Menu");
        System.out.println("4. Log Out");
        
        int choice = readInt(sc, "Select an option: ");
        switch (choice) {
            case 1:
                cs.viewOrders();
                break;
            case 2:
                cs.viewOrders();
                int orderId = readInt(sc, "Enter Order ID to update: ");
                System.out.println("Select New Status:");
                System.out.println("1. Preparing");
                System.out.println("2. Completed");
                System.out.println("3. Cancelled");
                int statusChoice = readInt(sc, "Choice: ");
                String status = "";
                if (statusChoice == 1) status = "Preparing";
                else if (statusChoice == 2) status = "Completed";
                else if (statusChoice == 3) status = "Cancelled";
                else {
                    System.out.println("Invalid choice. Status not changed.");
                    return;
                }
                cs.changeOrderStatus(orderId, status);
                break;
            case 3:
                cs.viewMenu();
                break;
            case 4:
                cs.logout();
                break;
            default:
                System.out.println("Invalid option. Please choose between 1 and 4.");
                break;
        }
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = sc.nextInt();
                sc.nextLine(); // clear newline
                return val;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.nextLine(); // clear buffer
            }
        }
    }

    private static double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = sc.nextDouble();
                sc.nextLine(); // clear newline
                return val;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid decimal number.");
                sc.nextLine(); // clear buffer
            }
        }
    }

    private static String readString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}

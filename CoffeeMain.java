public class CoffeeMain {
    public static void main(String[] args) {
        
        Menu coffee = new Menu(1,"Coffee",-5, "coffee",'M');

        coffee.setPrice(-5);


        System.out.println(coffee.getPrice());
 
    }
}

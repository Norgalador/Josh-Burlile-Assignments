import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
        
        // Menu items
        Item coffee = new Item();
        coffee.name = "coffee";
        coffee.price = 2.5;
        // System.out.println(coffee.price);
        
        Item latte = new Item();
        latte.name = "latte";
        latte.price = 3.5;

        Item cappucino = new Item();
        cappucino.name = "cappucino";
        cappucino.price = 2.75;
        
        Item americano = new Item();
        americano.name = "coffee";
        americano.price = 2.75;
        
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.name = "Cindhuri";
        order1.total = coffee.price;
        
        Order order2 = new Order();
        order2.name = "Jimmy";
        

        Order order3 = new Order();
        order3.name = "Noah";

        Order order4 = new Order();
        order4.name = "Sam";


        //Add item1 to order2's item list and increment the order's total.
        order2.items.add(coffee);
        order2.total += coffee.price;

        // order3 ordered a cappucino. Add the cappuccino to their order list and to their tab.
        order3.items.add(cappucino);
        order3.total += cappucino.price;

        // order4 added a latte. Update accordingly.
        order4.items.add(latte);
        order4.total += latte.price;

        // Cindhuri’s order is now ready. Update her status.
        order1.ready = true;

        // Sam ordered more drinks - 2 lattes. Update their order as well.
        order4.items.add(latte);
        order4.items.add(latte);
        order4.total += latte.price * 2;

        // Jimmy’s order is now ready. Update his status.
        order2.ready = true;

        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        // System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);

        System.out.printf("Order Ready: %s\n", order1.ready);
        System.out.printf("Order Ready: %s\n", order2.ready);
    }
}

import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal() {
        int sum = 0;
        for (int week = 1; week <= 10; week++) {
            sum+= week;
        }
        return sum;
    }

    public double getOrderTotal(double[] lineItems) {
        double total = 0;

        for (double price: lineItems) {
            total += price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%s %s \n", i, menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        customers.add("Sarah");
        customers.add("Stephanie");
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);
        System.out.printf("There are %s people in front of you.", customers.size());
        customers.add(userName);
    }
    

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.printf("%s \n", product);
        for (int num = 1; num < maxQuantity; num++) {
            System.out.printf("%s -- $%.2f\n", num, num * price);
        }
        System.out.println("\n");
    }

// Given a product, price and a maxQuantity, create a method that prints the cost for buying 1, 
// then the price for buying 2, then for 3.. and so on, 
// up to the max. For example, if the product is "Columbian Coffee Grounds" 
// with a price of 15.0 and maxQuantity of 3, you should print:


}
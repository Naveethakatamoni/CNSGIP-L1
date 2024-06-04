import java.util.Scanner;

class Pizza {
    public boolean isVeg;
    private int basePrice;
    private boolean extraCheese;
    private boolean extraToppings;
    private boolean isTakeaway;

    // Constants for pricing(MENNU)
    private final int VEG_PRICE = 200;
    private final int NON_VEG_PRICE = 300;
    private final int EXTRA_CHEESE_PRICE = 80;
    private final int EXTRA_TOPPINGS_PRICE = 80;
    private final int TAKEAWAY_CHARGE = 20;

    public Pizza(boolean isVeg) {
        this.isVeg = isVeg;
        this.basePrice = isVeg ? VEG_PRICE : NON_VEG_PRICE;
        this.extraCheese = false;
        this.extraToppings = false;
        this.isTakeaway = false;
    }

    public void addExtraCheese() {
        this.extraCheese = true;
    }

    public void addExtraToppings() {
        this.extraToppings = true;
    }

    public void setTakeaway() {
        this.isTakeaway = true;
    }

    public int calculateTotalPrice() {
        int totalPrice = basePrice;
        if (extraCheese) {
            totalPrice += EXTRA_CHEESE_PRICE;
        }
        if (extraToppings) {
            totalPrice += EXTRA_TOPPINGS_PRICE;
        }
        if (isTakeaway) {
            totalPrice += TAKEAWAY_CHARGE;
        }
        return totalPrice;
    }

    public void generateBill() {
        System.out.println("Pizza Bill:");
        System.out.println("Base Price: " + basePrice + " Rupees");
        if (extraCheese) {
            System.out.println("Extra Cheese: " + EXTRA_CHEESE_PRICE + " Rupees");
        }
        if (extraToppings) {
            System.out.println("Extra Toppings: " + EXTRA_TOPPINGS_PRICE + " Rupees");
        }
        if (isTakeaway) {
            System.out.println("Takeaway Charge: " + TAKEAWAY_CHARGE + " Rupees");
        }
        System.out.println("Total Price: " + calculateTotalPrice() + " Rupees");
        System.out.println("Thanks for Visiting,Have a good day!!");
    }
}

class DeluxePizza extends Pizza {

    public DeluxePizza(boolean isVeg) {
        super(isVeg);
        addExtraCheese();
        addExtraToppings();
    }

    @Override
    public void generateBill() {
        System.out.println("Deluxe Pizza Bill:");
        super.generateBill(); 
    }
}

public class PizzaShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to  VIRAT_RAM_NK_Pizza Shop!");
        System.out.print("would you like to have a veg pizza? (yes/no): ");
        boolean isVeg = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("would you like to have a deluxe pizza? (yes/no): ");
        boolean isDeluxe = scanner.nextLine().equalsIgnoreCase("yes");

        Pizza pizza;
        if (isDeluxe) {
            pizza = new DeluxePizza(isVeg);
        } else {
            pizza = new Pizza(isVeg);
        }

        if (!isDeluxe) {
            System.out.print("Do you want extra cheese? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                pizza.addExtraCheese();
            }

            System.out.print("Do you want extra toppings? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                pizza.addExtraToppings();
            }
        }

        System.out.print("Is this a takeaway order? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            pizza.setTakeaway();
        }

        pizza.generateBill();
        scanner.close();
    }
}
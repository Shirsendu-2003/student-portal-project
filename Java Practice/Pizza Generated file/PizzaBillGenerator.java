import java.util.Scanner;

class Pizza {
    protected int price;
    protected boolean isVeg;
    protected boolean extraCheeseAdded = false;
    protected boolean extraToppingsAdded = false;
    protected boolean takeawayAdded = false;

    protected final int cheesePrice = 100;
    protected final int toppingPrice = 150;
    protected final int packagingCharge = 20;

    public Pizza(boolean isVeg) {
        this.isVeg = isVeg;
        this.price = isVeg ? 300 : 400;
    }

    public void addExtraCheese() {
        if (!extraCheeseAdded) {
            extraCheeseAdded = true;
            price += cheesePrice;
        }
    }

    public void addExtraToppings() {
        if (!extraToppingsAdded) {
            extraToppingsAdded = true;
            price += toppingPrice;
        }
    }

    public void addTakeaway() {
        if (!takeawayAdded) {
            takeawayAdded = true;
            price += packagingCharge;
        }
    }

    public void generateBill() {
        System.out.println("----- Bill -----");
        System.out.println("Base Price of Pizza: ₹" + (isVeg ? 300 : 400));
        if (extraCheeseAdded) System.out.println("Extra Cheese Added: ₹" + cheesePrice);
        if (extraToppingsAdded) System.out.println("Extra Toppings Added: ₹" + toppingPrice);
        if (takeawayAdded) System.out.println("Takeaway Packaging: ₹" + packagingCharge);
        System.out.println("Total Bill: ₹" + price);
    }
}

class DeluxPizza extends Pizza {
    public DeluxPizza(boolean isVeg) {
        super(isVeg);
        super.addExtraCheese();
        super.addExtraToppings();
    }

    @Override
    public void addExtraCheese() {
        // Prevent duplicate addition
    }

    @Override
    public void addExtraToppings() {
        // Prevent duplicate addition
    }
}

public class PizzaBillGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Pizzamania!");
        System.out.println("Choose your pizza:");
        System.out.println("1. Veg Pizza");
        System.out.println("2. Non-Veg Pizza");
        System.out.println("3. Delux Veg Pizza");
        System.out.println("4. Delux Non-Veg Pizza");

        int choice = sc.nextInt();
        Pizza pizza;

        switch (choice) {
            case 1:
                pizza = new Pizza(true);
                askForAddOns(pizza, sc);
                break;
            case 2:
                pizza = new Pizza(false);
                askForAddOns(pizza, sc);
                break;
            case 3:
                pizza = new DeluxPizza(true);
                break;
            case 4:
                pizza = new DeluxPizza(false);
                break;
            default:
                System.out.println("Invalid choice.");
                sc.close();
                return;
        }

        System.out.println("Do you want takeaway? (yes/no)");
        String takeaway = sc.next();
        if (takeaway.equalsIgnoreCase("yes")) {
            pizza.addTakeaway();
        }

        pizza.generateBill();
        sc.close();
    }

    private static void askForAddOns(Pizza pizza, Scanner sc) {
        System.out.println("Add extra cheese? (yes/no)");
        if (sc.next().equalsIgnoreCase("yes")) {
            pizza.addExtraCheese();
        }

        System.out.println("Add extra toppings? (yes/no)");
        if (sc.next().equalsIgnoreCase("yes")) {
            pizza.addExtraToppings();
        }
    }
}

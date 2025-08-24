package com.pizza.pizza;

public class Pizza {
    protected int price;
    protected boolean isVeg;
    public boolean extraCheeseAdded = false;
    protected boolean extraToppingsAdded = false;
    protected boolean takeawayAdded = false;

    protected final int cheesePrice = 100;
    public final int toppingPrice = 150;
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

    // Getters as per your request
    public boolean isVeg() {
        return isVeg;
    }

    public boolean isExtraCheeseAdded() {
        return extraCheeseAdded;
    }

    public boolean isExtraToppingsAdded() {
        return extraToppingsAdded;
    }

    public boolean isTakeawayAdded() {
        return takeawayAdded;
    }

    public int getCheesePrice() {
        return cheesePrice;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }

    public int getPackagingCharge() {
        return packagingCharge;
    }

    public int getPrice() {
        return price;
    }

   public void generateBill() {
    StringBuilder bill = new StringBuilder();
    bill.append("Base Price Of The Pizza: ").append(isVeg ? 300 : 400).append("\n");

    if (extraCheeseAdded) {
        bill.append("Extra Cheese Added: ").append(cheesePrice).append("\n");
    }
    if (extraToppingsAdded) {
        bill.append("Extra Toppings Added: ").append(toppingPrice).append("\n");
    }
    if (takeawayAdded) {
        bill.append("Takeaway Packaging: ").append(packagingCharge).append("\n");
    }

    bill.append("Total Price: ").append(price).append("\n");

    System.out.println(bill.toString());
}

}

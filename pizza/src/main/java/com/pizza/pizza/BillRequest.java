package com.pizza.pizza;

public class BillRequest {
    private String pizzaType;
    private boolean extraCheese;
    private boolean extraToppings;
    private boolean takeaway;

    // Getters & Setters
    public String getPizzaType() { return pizzaType; }
    public void setPizzaType(String pizzaType) { this.pizzaType = pizzaType; }

    public boolean isExtraCheese() { return extraCheese; }
    public void setExtraCheese(boolean extraCheese) { this.extraCheese = extraCheese; }

    public boolean isExtraToppings() { return extraToppings; }
    public void setExtraToppings(boolean extraToppings) { this.extraToppings = extraToppings; }

    public boolean isTakeaway() { return takeaway; }
    public void setTakeaway(boolean takeaway) { this.takeaway = takeaway; }
}

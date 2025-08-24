package com.pizza.pizza;

public class DeluxePizza extends Pizza {

    public DeluxePizza(boolean isVeg) {
        super(isVeg);
        super.addExtraCheese();
        super.addExtraToppings();
    }

    @Override
    public void addExtraCheese() {
        // already added in constructor
    }

    @Override
    public void addExtraToppings() {
        // already added in constructor
    }
}

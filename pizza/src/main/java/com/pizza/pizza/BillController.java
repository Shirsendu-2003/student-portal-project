package com.pizza.pizza;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allow access from your HTML page
public class BillController {

    @PostMapping("/generateBill")
    public String generateBill(@RequestBody BillRequest request) {
        Pizza pizza;

        switch (request.getPizzaType()) {
            case "DELUX_VEG":
                pizza = new DeluxePizza(true);
                break;
            case "DELUX_NON_VEG":
                pizza = new DeluxePizza(false);
                break;
            case "VEG":
                pizza = new Pizza(true);
                break;
            case "NON_VEG":
                pizza = new Pizza(false);
                break;
            default:
                return "❌ Invalid pizza type selected.";
        }

        if (request.isExtraCheese()) pizza.addExtraCheese();
        if (request.isExtraToppings()) pizza.addExtraToppings();
        if (request.isTakeaway()) pizza.addTakeaway();

        return generateBillText(pizza);
    }

    private String generateBillText(Pizza pizza) {
        StringBuilder bill = new StringBuilder();
        bill.append("Base Price Of The Pizza: ").append(pizza.isVeg() ? 300 : 400).append("\n");

        if (pizza.isExtraCheeseAdded()) bill.append("Extra Cheese Added: ₹100\n");
        if (pizza.isExtraToppingsAdded()) bill.append("Extra Toppings Added: ₹150\n");
        if (pizza.isTakeawayAdded()) bill.append("Takeaway Packaging: ₹20\n");

        bill.append("----------------------------\n");
        bill.append("Total Price: ₹").append(pizza.getPrice()).append("\n");
        return bill.toString();
    }
}

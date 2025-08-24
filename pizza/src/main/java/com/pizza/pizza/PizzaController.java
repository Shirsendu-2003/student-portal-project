package com.pizza.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    private PdfBillGenerator pdfBillGenerator;

    @PostMapping("/generate-pdf")
    public String generatePdf(
            @RequestParam int basePrice,
            @RequestParam boolean cheese,
            @RequestParam boolean toppings,
            @RequestParam boolean takeaway
    ) {
        try {
            pdfBillGenerator.generateBill("PizzaBill.pdf", basePrice, cheese, toppings, takeaway);
            return "PDF Bill Generated Successfully!";
        } catch (FileNotFoundException e) {
            return "Error generating PDF: " + e.getMessage();
        }
    }
}
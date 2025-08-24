package com.pizza.pizza;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PdfBillGenerator {

    public void generateBill(String filename, int basePrice, boolean cheese, boolean toppings, boolean takeaway) throws FileNotFoundException {
        File file = new File(filename);
        file.getParentFile().mkdirs(); // Create directory if it doesn't exist

        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdf = new PdfDocument(writer);
        pdf.getDocumentInfo().setTitle("Pizza Bill");
        pdf.getDocumentInfo().setAuthor("Pizza Billing System");

        Document document = new Document(pdf);

        int total = basePrice;

        document.add(new Paragraph("✔ Bill Generated:\n"));

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        document.add(new Paragraph("Generated On: " + dateTime + "\n"));

        document.add(new Paragraph("Base Price Of The Pizza: ₹" + basePrice));

        if (cheese) {
            document.add(new Paragraph("Extra Cheese Added: ₹100"));
            total += 100;
        }
        if (toppings) {
            document.add(new Paragraph("Extra Toppings Added: ₹150"));
            total += 150;
        }
        if (takeaway) {
            document.add(new Paragraph("Takeaway Packaging: ₹20"));
            total += 20;
        }

        document.add(new Paragraph("\n----------------------------"));
        document.add(new Paragraph("Total Price: ₹" + total).setBold());

        document.close();
    }
}

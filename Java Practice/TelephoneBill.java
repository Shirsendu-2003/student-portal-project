import java.util.Scanner;

public class TelephoneBill {
    private long phoneNumber;
    private String name;
    private static final int HIRE_CHARGE = 200;
    private int unitsConsumed;
    private float billAmount;

    // Constructor
    public TelephoneBill(long phoneNumber, String name, int unitsConsumed) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.unitsConsumed = unitsConsumed;
        this.billAmount = 0.0f;
    }

    // Method to calculate the bill
    public void calculateBill() {
        int units = unitsConsumed;
        billAmount = HIRE_CHARGE;

        if (units <= 100) {
            billAmount += units * 1.0;
        } else if (units <= 200) {
            billAmount += 100 * 1.0 + (units - 100) * 1.50;
        } else {
            billAmount += 100 * 1.0 + 100 * 1.50 + (units - 200) * 2.0;
        }
    }

    // Method to display the bill
    public void displayBill() {
        System.out.println("Subscriber Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Hire Charge: " + HIRE_CHARGE);
        System.out.println("Total Bill Amount: " + billAmount);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter the phone number: ");
        long phoneNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter the subscriber's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the units consumed: ");
        int unitsConsumed = scanner.nextInt();

        // Create an instance of TelephoneBill with user input
        TelephoneBill bill = new TelephoneBill(phoneNumber, name, unitsConsumed);

        // Calculate and display the bill
        bill.calculateBill();
        bill.displayBill();

        // Close the scanner
        scanner.close();
    }
}
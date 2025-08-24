import java.util.Scanner;
public class SalaryCalculation {
    // Data members
    private String name;
    private double basicPay;
    private double specialAlw;
    private double conveyanceAlw;
    private double gross;
    private double pf;
    private double netSalary;
    private double annualSal;

    // Constructor to initialize name, basicPay
    public SalaryCalculation(String name, double basicPay) {
        this.name = name;
        this.basicPay = basicPay;
        this.conveyanceAlw = 1000.00; // fixed value
        this.specialAlw = 0.0;
        this.pf = 0.0;
        this.gross = 0.0;
        this.netSalary = 0.0;
        this.annualSal = 0.0;
    }

    // Method to calculate allowances and salaries
    public void SalaryCal() {
        // Calculate special allowance (25% of basic salary)
        this.specialAlw = 0.25 * basicPay;

        // Calculate provident fund (11% of basic salary)
        this.pf = 0.11 * basicPay;

        // Calculate gross salary
        this.gross = basicPay + specialAlw + conveyanceAlw;

        // Calculate net salary
        this.netSalary = gross - pf;

        // Calculate annual salary
        this.annualSal = 12 * netSalary;
    }

    // Method to display the details
    public void display() {
        System.out.println("Salary Details:");
        System.out.println("Name: " + name);
        System.out.println("Basic Pay: Rs." + String.format("%.2f", basicPay));
        System.out.println("Special Allowance: Rs." + String.format("%.2f", specialAlw));
        System.out.println("Conveyance Allowance: Rs." + String.format("%.2f", conveyanceAlw));
        System.out.println("Gross Salary: Rs." + String.format("%.2f", gross));
        System.out.println("Provident Fund: Rs." + String.format("%.2f", pf));
        System.out.println("Net Salary: Rs." + String.format("%.2f", netSalary));
        System.out.println("Annual Salary: Rs." + String.format("%.2f", annualSal));
    }

    // Main method to test the class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter the employee's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the basic pay: Rs.");
        double basicPay = scanner.nextDouble();

        // Create an instance of SalaryCalculation with user input
        SalaryCalculation employee = new SalaryCalculation(name, basicPay);

        // Calculate salary details
        employee.SalaryCal();

        // Display the details
        employee.display();

        // Close the scanner
        scanner.close();
    }
}
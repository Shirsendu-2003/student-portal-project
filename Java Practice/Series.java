import java.util.Scanner;

public class Series {
    // Data members
    private double x;
    private int n;

    // Parameterized constructor
    public Series(double x, int n) {
        this.x = x;
        this.n = n;
    }

    // Method to calculate factorial of an integer
    private int factorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    // Method to calculate and print the sum of the series: x + x / 2! + x / 3! + ... + x / n!
    public void printSeries1() {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += x / factorial(i);
        }
        System.out.printf("Sum of Series 1: %.6f\n", sum);
    }

    // Method to calculate and print the sum of the series: x / 2! + (x^2) / 3! + (x^3) / 4! + ... + (x^n) / (n+1)!
    public void printSeries2() {
        double sum = 0;
        for (int i = 2; i <= n + 1; i++) {
            sum += Math.pow(x, i - 1) / factorial(i);
        }
        System.out.printf("Sum of Series 2: %.6f\n", sum);
    }

    // Method to calculate and print the sum of the series: x / 2! - (x^2) / 3! + (x^3) / 4! - ... ± (x^n) / (n+1)!
    public void printSeries3() {
        double sum = 0;
        for (int i = 2; i <= n + 1; i++) {
            // Alternating sign: + for even i and - for odd i
            double term = (i % 2 == 0 ? 1 : -1) * Math.pow(x, i - 1) / factorial(i);
            sum += term;
        }
        System.out.printf("Sum of Series 3: %.6f\n", sum);
    }

    // Main method to test the class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter the value of x: ");
        double x = scanner.nextDouble();

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        // Create an instance of Series with user input
        Series series = new Series(x, n);

        // Print the results of all series
        series.printSeries1();
        series.printSeries2();
        series.printSeries3();

        // Close the scanner
        scanner.close();
    }
}
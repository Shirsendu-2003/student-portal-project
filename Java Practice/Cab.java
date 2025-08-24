import java.util.Scanner;
public class Cab{
private String car-type;
private double km;
private double bill;
 public void cabservice(){
	 String car-type;
	 double km;
	 double bill;
	 
	 public cabservice(){
		 car-type = "";
		 km = 0.0;
		 bill = 0.0;
	 }
	 public void accept(){
  Scanner input = new Scanner(System.in);
   
System.out.println("Enter Car-Type:");
        name = input.next();
		car-type=input.next();
		
		System.out.println("Enter Kilometer:");
		km=input.nextDouble();
	 }
	 public void calculate() {
         if (km <= 5) {
            if (car_type.equals("AC"))
                bill = 150;
            else
                bill = 120;
        }
        else {
            if (car_type.equals("AC"))
                bill = 150 + 10 * (km - 5);
            else
                bill = 120 + 8 * (km - 5);
        }
    }
		 public void display() {
        System.out.println("Car Type: " + car_type);
        System.out.println("Kilometer Travelled: " + km);
        System.out.println("Total Bill: " + bill);
    }
	 public static void main(String args[]) {
        CabService obj = new CabService();
        obj.accept();
        obj.calculate();
        obj.display();
    }
}
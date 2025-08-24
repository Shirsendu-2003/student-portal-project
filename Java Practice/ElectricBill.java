import java.util.Scanner;
public class ElectricBill {
private String name;
private int units;
private double bills;
public void accept(){
  Scanner input = new Scanner(System.in);
   
System.out.println("Enter name:");
        name = input.next();

        System.out.println("Enter units:");
        units = input.nextInt();

}
	public void calculate() {
        if (units <= 0) {
			System.out.println("Invalid Unit Input");
		}  else if (units <= 100) {
            bills = units * 5.76;
        } else if (units>100 && units <= 200) {
            bills = 100 * 5.76 + (units - 100) * 6.50;
        } else if (units>200 && units <= 300) {
            bills = (100 * 5.76) + (100 * 6.50) + ((units - 200) * 7.50); 
        } else {
			bills =  100 * 5.76 + 100 * 6.50 + ((units - 200) * 7.50);
			bills = bills + (units * ( bills * 0.25));
		}			
        
	
	}
	 public void display() {
        System.out.println("Name: " + name);
        System.out.println("Units Consumed: " + units);
        System.out.println("Total Bill: Rs. " + String.format("%.2f", bills));
    }

    public static void main(String[] args) {
        ElectricBill obj = new ElectricBill();
        obj.accept();
        obj.calculate();
        obj.display();
		
    }
}
	
	

   
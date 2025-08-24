import java.util.Scanner;

public class CabService {
    static String carType;
    static double km;
    static double bill;

  public CabService() {
        carType = "";
        km = 0.0;
        bill = 0.0;
    }

    public static void accept() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Car Type (AC/Non-AC): ");
        carType = input.next();

        System.out.println("Enter Distance in KM : ");
        km = input.nextDouble();

    }

    public static void calculate() {
switch(carType) {
	case "AC":
	if (km <= 0) {
		System.out.println("Invalid Distance");
	} else if (km <= 10) { // for less than or equal to 10km price is fixed 200
		bill = 200;
	} else if (km > 10)  {	//for more than 10km price is bill * 20 for each km
		bill = 20*km;
	} else {
		System.out.println("Invalid Distance");
	}
break;
case "Non-AC":
//for more than 10km price is bill * 15 for each km
	if (km <= 0) {
		System.out.println("Invalid Distance");
	}else if (km <= 10) {
		bill = 150;
	}else if (km > 10) {
		bill = 15*km;
		// for less than or equal to 10km price is fixed 150
	}  else {
		System.out.println("Invalid Distance");
	}
break;
default:
System.out.println("Invalid Input");
break;
}	
	}
    public static void display() {
		if (carType.equals("Non-AC") || carType.equals("AC")) {
		if (km > 0) {
        System.out.println("Car Type: " +carType);
        System.out.println("Distance Travelled: " +km);
        System.out.println("Your Bill: " +bill);
		} else {
		System.out.println("Distance Must Be Positive");	
		}
		} else {
		System.out.println("Car Type Must Be AC or Non-AC");	
		}
	}

    public static void main(String[] args) {
	CabService obj = new CabService();
		accept();
		calculate();
		display();
        
    }
}
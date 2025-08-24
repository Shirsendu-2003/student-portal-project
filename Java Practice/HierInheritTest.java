class Vehicle {
String tyre = "Apollo";
	public void brand(){
		System.out.println("The Brand Name of the Tyre used is : ");
	}
}

class Car extends Vehicle {
	String color = "Black";
	public void looks() {
	System.out.println("The color of the car is : ");
	}
	public void driving() {
		String bName="Mercedes";
		System.out.println("The Brand Name of Car is : "+bName);
		System.out.println("For Driving car 4 Wheeler Licesce is Required");		
	}
}

class Bike extends Vehicle {
int topSpeed = 250;
	public void speed() {
	System.out.println("The Top Speed of the bike is : ");
	}
	public void riding() {
		String bikeBrandName="Kawasaki";
		System.out.println("The Brand Name of Bike is : "+bikeBrandName);
		System.out.println("For Riding bike 2 Wheeler Licesce is Required");	
	}	
}

class HierInheritTest {
	public static void main(String[] args) {
	Car z = new Car();
	Bike x = new Bike();
	z.driving();
	z.looks();
	System.out.println(z.color);
	z.brand();
	System.out.println(z.tyre);
	x.riding();
	x.speed();
    System.out.println(x.topSpeed);
	x.brand();
	System.out.println(x.tyre);
}
}
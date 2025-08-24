public class Func_overloading{

	public int add(int a, int b){
	return a+b;
	}
	public int add(int a, int b , int c){
	return a+b+c;
	}
	public double add(double a, double b){
	return a+b;
	}

	public static void main(String[] args) {
	 Func_overloading calculator = new Func_overloading();
	 
	 System.out.println(calculator.add(2,3));
	 
	 System.out.println(calculator.add(2,3,10));
	 
	 System.out.println(calculator.add(2.1,3.5));
	 }
 }

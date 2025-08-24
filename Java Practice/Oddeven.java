import java.util.Scanner;
public class Oddeven{
	public static void main(String[] args){
		int n;
		System.out.println("Enter any No:");
		Scanner x = new Scanner(System.in);
		n = x.nextInt();
		
		if(n%2==0){
			System.out.println("Even Number");
		}else{
			System.out.println("Odd Number");
		}
	}
}
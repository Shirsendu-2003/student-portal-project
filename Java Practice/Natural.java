import java.util.Scanner;
public class Natural{
	public static void main(String[] args){
		int n;
		System.out.print("Enter any No of terms: ");
		Scanner x = new Scanner(System.in);
		n = x.nextInt();
		
		for(int i=1;i<=n;i++){
			System.out.println(i + " ");
		}
	}
}
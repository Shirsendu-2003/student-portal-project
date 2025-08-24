public class Test9{
	public static void main(String[] args){
		int a = 36;
		int b = 36;
		
		int c = a+b;
		System.out.println(c);
		System.out.println(a-b);
		System.out.println(a/b);
		System.out.println(a*b);
		System.out.println(a%b);
		
		if(a>b){
			System.out.println("The number is greater :" +a);
		}else if (a<b){
			System.out.println("The number is greater :" +b);
		}else{
			System.out.println("The number is equal.");
		}
	}
}
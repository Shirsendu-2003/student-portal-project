public class New1{
	public static void main(String[] args){
		int a=12, b=10;
		
		String c = ((a%2)==0)&&((a%3)==0)?"a is divisible by both":"a is not divisible by both";
		String d = ((b%2)==0)&&((b%3)==0)?"b is divisible by both":"b is not divisible by both";
		
		
		System.out.println(c);
		System.out.println(d);
	}
}

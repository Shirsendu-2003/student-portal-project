public class New2{
	public static void main(String[] args){
		int a=12, b=10, c=9;
		
		String d = ((a%2)==0)||((a%3)==0)?"a is divisible by both":"a is not divisible by both";
		String e = ((b%2)==0)||((b%3)==0)?"b is divisible by both":"b is not divisible by both";
		String f = ((c%2)==0)||((c%3)==0)?"c is divisible by both":"c is not divisible by both";
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
	}
}
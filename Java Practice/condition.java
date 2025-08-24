public class condition{
	public static void main(String[] args){
		int a=6, b=12, c=9;
		
		String d =((a>b)?((a>c)?"a is greater":"c is greater"):((b>c)?"b is greater":"c is greater"));
		System.out.println(d);
	}
}
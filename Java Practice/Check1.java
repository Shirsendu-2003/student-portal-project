public class Check1 {
public static void main(String[] args) {
 char a= '$';
 
 if((a>='a'&& a<='z') || (a>='A' && a<='Z')) {
	 System.out.println("The inputted character is alphabet");
} else if(a>=0 && a<=9) {
	 System.out.println("The inputted character is numeric");
} else {
	 System.out.println("The inputted character is special character");
}
}
}
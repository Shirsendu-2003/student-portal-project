public class Divisible {
public static void main(String[] args) {
 int a=10;
  if (a%3==0 && a%5==0){
	 System.out.println("the number is  divisible by 3 or 5");
 }
 else if (a%3==0){
	 System.out.println(" the number is divisible by 3");
 }else if(a%5==0){
	 System.out.println(" the number is divisible by 5");
 }else {
	 System.out.println("the number is not divisible by 3 or 5");
 }
}
}
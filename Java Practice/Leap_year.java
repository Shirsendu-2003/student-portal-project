public class Leap_year{
   public static void main(String[] args){
       int year = 2021;
	   
	   if((year%4)==0){
	      if((year%100)!=0 || (year%400)==0){
              System.out.println("This Year is a leap year");
			} else {							
		      System.out.println("This Year is not a leap year");
			}
	   } else {
		  System.out.println("This Year is not a leap year");
	
  }
 }
}
public class VariableV{
	
	 static void myStaticMethod() {
    System.out.println("Static methods can be called without creating objects");
  }
     public void myPublicMethod() {
    System.out.println("Instance methods must be called by creating objects");
  }
     public void printSum() {
       
        int a = 5; 
        int b = 10; 
        int sum = a + b;
        System.out.println("Sum: " + sum);
    }

   public static void main(String[] args){
	    myStaticMethod();
		 VariableV obj = new VariableV();
	  
	  obj.myPublicMethod();
	  obj.printSum();
   }
  
}	
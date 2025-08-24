public class InstanceV{
	
	 public void myPublicMethod() {
    System.out.println("Instance methods must be called by creating objects");
  }
  public static void main(String[] args){
	  InstanceV obj = new InstanceV();
	  
	  obj.myPublicMethod();
  }
}
public class Constructor { //constructor overloading
  String name;
  int age;

  // Default constructor
  public Constructor() {
    name = "Unknown";
    age = 0;
  }

  // Parameterized constructor
  public Constructor(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public static void main(String[] args) {
    Constructor input1 = new Constructor(); // Uses default constructor
    Constructor input2 = new Constructor("Sourav", 20); // Uses parameterized constructor

    System.out.println(input1.name + ", " + input1.age); 
    System.out.println(input2.name + ", " + input2.age); 
  }
}
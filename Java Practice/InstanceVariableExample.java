public class InstanceVariableExample {
    // Instance variable declaration
    int x;  // Instance variable 'x'

    // Constructor to initialize the instance variable
    public InstanceVariableExample(int initialValue) {
        x = initialValue;
    }

    public void printValue() {
        // Accessing the instance variable
        System.out.println("Value of x: " + x);
    }

    public static void main(String[] args) {
        // Creating an instance of InstanceVariableExample
        InstanceVariableExample obj1 = new InstanceVariableExample(10);
        obj1.printValue(); // Output: Value of x: 10

        // Creating another instance with a different value
        InstanceVariableExample obj2 = new InstanceVariableExample(20);
        obj2.printValue(); // Output: Value of x: 20
    }
}
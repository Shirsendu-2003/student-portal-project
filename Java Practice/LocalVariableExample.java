public class LocalVariableExample {
    public void printSum() {
        // Local variable declaration
        int a = 5;  // Local variable 'a'
        int b = 10; // Local variable 'b'
        
        // Local variable 'sum'
        int sum = a + b;
        
        // Printing the result
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) {
        LocalVariableExample example = new LocalVariableExample();
        example.printSum();
    }
}
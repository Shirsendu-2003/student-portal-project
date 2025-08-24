public class AnimalA {
    String name;

    AnimalA(String name) {
        this.name = name;
    }

    void speak() {
        System.out.println(name + " makes a sound.");
    }


class Dog extends AnimalA {
    Dog(String name) {
        super(name);
    }

    
    void speak() {
        System.out.println(name + " barks.");
    }
}


    public static void main(String[] args) {
        AnimalA myDog = new AnimalA("Anik");
        myDog.speak(); 
    }
}
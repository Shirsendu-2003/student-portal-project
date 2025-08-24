class Animal {
   static int wt=72;
    public void weight() {
        System.out.println("Weight of the Animal is : ");
    }
}
class Person extends Animal{
    String nm="Rohit";
    public void name() {
        System.out.println("The name os the person is : ");
    }
}
class Student extends Person {
    int sId = 54321;
    public void studentId() {
        System.out.println("The Student id is : ");
    }
}

class MultiLevelInherit extends Student {
    public static void main(String[] args) {
    System.out.println("Testing multi level inheritance");
    Student t1 = new Student();
    t1.weight();
    System.out.println(wt);
    t1.name();
    System.out.println(t1.nm);
    t1.studentId();
    System.out.println(t1.sId);
}
}
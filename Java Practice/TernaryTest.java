public class TernaryTest {
public static void main(String[] args) {
int a=7;
int b=60;
int c=80;
int d=5;


String e=(a>b)?((a>c)?((a>d)?"a is largest":"d is largest"):((c>d)?"c is largest":"d is largest")):((b>c)?((b>d)?"b is largest":"d is largest"):((c>d)?"c is largest":"d is largest"));
System.out.println(e);
}
}
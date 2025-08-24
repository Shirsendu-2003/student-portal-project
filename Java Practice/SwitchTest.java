public class SwitchTest {
public static void main(String[] args) {
char letter = 2;
if(letter>=0 && letter<=9) {
	System.out.println("The inputted character is an integer");
} else {
 switch(letter) {
 case 'a':
 
System.out.println("the alphabet is vowel");
 
break;
case 'e':
System.out.println("the alphabet is vowel");
break;
case 'i':
System.out.println("the alphabet is vowel");
break;
case 'o':
System.out.println("the alphabet is vowel");
break;
case 'u':
System.out.println("the alphabet is vowel");
break;

default:
System.out.println("the Alphabet is consonant");
break;
}
}
}
}
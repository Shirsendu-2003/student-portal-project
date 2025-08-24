public class IfElseDemo{
	public static void main(String[] args){
		int Mark=76;
		char grade;
		if(Mark>=90){
			grade='A';
		}else if(Mark>=80){
			grade='B';
		}else if(Mark>=70){
			grade='c';
		}else if(Mark>=60){
			grade='D';
		}else if(Mark>=50){
			grade='E';
		}else{
			grade='F';
		}
		System.out.println("grade is" + grade);
	}
}
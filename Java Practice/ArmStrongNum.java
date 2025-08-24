class ArmStrongNum{
	public static void main(String[] args){
		int sum=0,r,temp;
		int n=154;
		temp=n;
		while(n>0){
			r=n%10;
			sum=sum+(r*r*r);
			n=n/10;
		}
		if(temp==sum){
			System.out.println("Armstrong number");
		}else{
			System.out.println("not a armstrong number");
		}
	}
}
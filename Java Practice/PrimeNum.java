class PrimeNum{
	public static void main(String[] args){
		int num=16;
		int flag=0;
		for(int i=2;i<num;i++){
			if(num%i==0){
				System.out.println(num+"is not prime");
				flag=1;
				break;
			}
		}
		if(flag==0){
		System.out.println(num+"is a prime number");
		}
	}
}
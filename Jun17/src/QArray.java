import java.util.Scanner;

public class QArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner scn =new Scanner(System.in);
		System.out.println("Enter the binary no:");
		int n=scn.nextInt();
		int result=BinaryToDecimal(n);
		System.out.println(result);
		
		

	}
       public static int BinaryToDecimal(int n){
		
		int power=0;
		int sum=0;
		while(n!=0)
		{
			
			int rem=n%10;
			sum=rem*(int)Math.pow(2, power)+sum;
			power++;
			n=n/10;
		}
		
		return  sum;
	}
}

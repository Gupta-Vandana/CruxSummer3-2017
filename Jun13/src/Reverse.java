import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scn= new Scanner(System.in);
		System.out.println("enter the no. ");
		int n =scn.nextInt();
	
		
		
		int place =1;
		int inv=0;
		while(n!=0)
		{
			int rem=n%10;
			n=n/10;
			inv=inv+place*(int)Math.pow(10, rem-1);
			place++;
		}
		System.out.print(inv);
		

	}

}

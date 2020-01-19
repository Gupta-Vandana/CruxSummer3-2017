import java.util.Scanner;

public class Sd2Sb {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("enter the destination base");
		System.out.println("enter the  no.");
		System.out.println("enter the source destination");
		
		int n = scn.nextInt();
		int m =scn.nextInt();
		int sb =scn.nextInt();
		int rv = 0,power=1;
		int num=0;
		
		
		while (n != 0) {
			
			int rem=n%10;
			n=n/10;
			
			rv=rv+rem*power;
			power=power*sb;
		}
		
       while(rv!=0)
     { 
       
	   int rem2=rv%m;
	   rv=rv/m;
	    num =num+rem2*power;
	   power=power*10;
	
     }
       System.out.print(num);


	}

}

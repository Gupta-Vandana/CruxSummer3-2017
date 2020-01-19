import java.util.Scanner;

public class Anybaseto10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("enter the destination base");
		System.out.print("enter the decimal no.");
		
		int n = scn.nextInt();
		int m =scn.nextInt();
		int rv = 0,power=1;
		while (n != 0) {
			
			int rem=n%m;
			n=n/m;
			
			rv=rv+rem*power;
			power=power*10;
		}
		System.out.println(rv);


	}

}

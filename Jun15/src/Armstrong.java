import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no.");
		int n = scn.nextInt();
		System.out.println(Isarmstrong(n));
	
	}

	    public static boolean Isarmstrong(int n){

        int temp;
		temp = n;
		int count = 0;
		while (temp != 0) 
		{
			temp = temp / 10;
			count++;
		}

		temp = n;
		int arm = 0;
		while (temp != 0)
		{
			int rem = temp % 10;
			arm = arm + (int) Math.pow(rem, count);
			temp = temp / 10;
		}

		if (n == arm)
		  {
			return true;
		  } 
		else 
		  {
			return false;
		
		  }
}

	

	

		
		
	}


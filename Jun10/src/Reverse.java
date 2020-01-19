package ques;

import java.util.Scanner;

public class Reverse {

	public static void main( String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("enter no.");
		int n= sc.nextInt();
		int rev=0;
		int rem = 0;
		while(n!=0)
		{ 
			rem=n%10;
		    rev=(10*rev) + rem;
		    n=n/10;
		}
		
		System.out.println(rev);
		

	}

}

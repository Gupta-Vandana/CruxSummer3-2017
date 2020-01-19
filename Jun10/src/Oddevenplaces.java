package ques;

import java.util.Scanner;

public class Oddevenplaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no.");
		int n = sc.nextInt();
		int so = 0;
		int se = 0;
		int place = 1;
		int rem;
		while (n != 0) {
			rem = n % 10;
			
			n = n / 10;

			if (place % 2 == 0) {
				se = se + rem;
			} else {
				so = so + rem;
			}
			place++;
		}
		System.out.println(so);
		System.out.println(se);

	}

}

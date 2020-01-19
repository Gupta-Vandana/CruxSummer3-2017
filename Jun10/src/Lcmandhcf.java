package ques;

import java.util.Scanner;

public class Lcmandhcf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("enter First no.");
		int divs = sc.nextInt();
		System.out.println("enter second no.");
		int divd = sc.nextInt();

		int n2 = divd;
		int n1 = divs;
		while (divd % divs != 0)
		{
			int rem = divd % divs;

			divd = divs;
			divs = rem;

		}
		System.out.println(divs);
		System.out.println((n1 * n2) / divs);

	}

}

package ques;

import java.util.Scanner;

public class crosspattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the no.");
		int n = sc.nextInt();
		int row = 1;

		int i = 1;

		while (i <= n) {
			int j = 1;
			while (j <= n) {
				if (i == j || j == n - i + 1) {
					System.out.print("*");
				}

				else {
					System.out.print(" ");
				}
				j++;

			}
			System.out.println();
			i++;
		}
		row++;

	}

}

import java.util.ArrayList;

public class Q1 {

	public static void main(String[] args) {
		boolean[][] arr = new boolean[4][4];
		int n=1;
		int max=1000;
		printlexico(n,max);
		
		//placequeen(arr, 0, "");

	}

	public static void placequeen(boolean[][] arr, int r, String ans) {
		if (r == arr.length) {
			System.out.println(ans);
			return;

		}
		for (int i = 0; i < arr.length; i++) {
			if (isitsafeforqueen(arr, r, i) == true) {
				arr[r][i] = true;
				placequeen(arr, r + 1, ans + r + i);
				arr[r][i] = false;

			}

		}

	}

	public static boolean isitsafeforqueen(boolean[][] arr, int r, int c) {

		int row = r;
		int col = c;
		while (row >= 0) {
			if (arr[row][col] == true) {
				return false;
			}
			row--;
		}
		row = r;
		while (row >= 0 && col >= 0) {
			if (arr[row][col] == true) {
				return false;
			}
			row--;
			col--;
		}

		row = r;
		col = 0;
		while (row >= 0 && col < arr.length) {
			if (arr[row][col] == true) {
				return false;

			}
			row--;
			col++;
		}
		return true;
	}

	 public static void  printlexico(int n,int max){
		 
		 int i=1;
	     while(i<=max){
		i=(int)Math.pow(10, i)+1;
		
		printlexico(n+1,max);
		i++;
	}
	     System.out.println(i);
			
	
	
	
	 
	 }	 
}
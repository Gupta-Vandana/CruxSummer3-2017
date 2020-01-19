import java.util.Arrays;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int er = 3;
		int ec = 3;
		// int n = 10;
		System.out.println(cmpds(er, ec));
		System.out.println(Q1s(10));
		System.out.println(Q1i(10));
	}

	public static int cmpi(int er, int ec) {
		int[][] arr = new int[er + 1][ec + 1];
		arr[er][ec] = 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				if (i == er || j == ec) {
					arr[i][j] = 1;
					
				} else {

					arr[i][j] = arr[i + 1][j] + arr[i][j + 1];
					

				}
			}

		}
		return arr[0][0];
	}

	public static int Q1i(int n) {
		int[] arr1 = new int[n + 6];
		arr1[n] = 1;
		for (int i = n - 1; i >= 0; i--) {

			int j = 1;
			while (j <= 6) {
				arr1[i] += arr1[i + j];
				j++;
			}

		}
		return arr1[0];
	}


	public static int Q1s(int n) {
		int[] arr2 = new int[6];
		arr2[0] = 1;
		for (int i = 0; i < n; i++) {
			int nv = arr2[0] + arr2[1] + arr2[2] + arr2[3] + arr2[4] + arr2[5];
			arr2[5] = arr2[4];
			arr2[4] = arr2[3];
			arr2[3] = arr2[2];
			arr2[2] = arr2[1];
			arr2[1] = arr2[0];
			arr2[0] = nv;

		}
		return arr2[0];
	}
	public static int cmps(int ec,int er){
		int [] arr=new int [ec+1];
		Arrays.fill(arr, 1);
		for (int r=er-1;r>=0;r--){
			for (int c=ec;c>=0;c--){
				if (c==ec){
					arr[c]=1;
				}
				else {
					int nv=arr[c] +arr[c+1];
					arr[c]=nv;
				}
			}
		}
	
	return arr[0];
}
	public static int cmpds(int ec,int er){
		int [] arr=new int [ec+1];
		int d=1;
		Arrays.fill(arr, 1);
		for (int r=er-1;r>=0;r--){
			for (int c=ec;c>=0;c--){
				if (c==ec){
					arr[c]=1;
					d=1;
				}
				else {
					
					int nv=arr[c] +arr[c+1] + d;
					d=arr[c];
					arr[c]=nv;
					
				}
			}
		}
	
	return arr[0];
		
	}
}



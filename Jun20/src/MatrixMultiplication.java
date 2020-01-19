
public class MatrixMultiplication {

	public static void main(String[] args) {

		int[][] arr1 = { { 1, 2,  0 }, { 1, 2, 0 }, { 1, 2,  0 }, };
		int[][] arr2 = { { 1, 2,  0 }, { 1, 2, 0},  { 1, 2,  0 }, };
		 int [][]prd=MatrixMultiply(arr1, arr2);
		 
		 display(prd);
        
	}

	public static int[][] MatrixMultiply(int[][] arr1, int[][] arr2) {
		int[][] product = new int[arr1[0].length][arr2.length];
		if (arr1[0].length == arr2[0].length) {
			for (int i = 0; i < arr1.length; i++) {
				for (int j = 0; j < arr2.length; j++) {
				    
					product[i][j] = arr1[i][i] * arr2[i][j];
				}
			}

		}
		return product;
	}
	public static void display(int[][] prd){
		for (int row=0;row<prd.length;row++){
			for (int col=0;col<prd[row].length;col++){
				System.out.println(prd[row][col]+"\t");
				
			}
		}
		
	}

}

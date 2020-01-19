
public class Exitpoint {

	public static void main(String[] args) {
		int [][] arr={
				{1,0,1,0},
				{1,0,0,0},
				{0,1,1,1}
		};
		ExitPoint(arr);
				
	

	}
	public static void ExitPoint(int [][] arr){
		 int row =0;int col=0;
		int direction=(0+arr[row][col])%4  ;
		while(true){
			if(direction==0){
				col++;
				if (col==arr[0].length){
					col--;
					System.out.println(row +" ,"+col);
					break;
					
				}
				
			}
			else if (direction==1){
				row++;
				if(row==arr.length){
					row--;
					System.out.println(row+","+col);
					break;
				}
			}
			else if (direction==2){
				
				col--;
				if (col<0){
					col++;
					System.out.println(row+","+col);
					break;
				}
				
			}
			else if (direction==3){
				row--;
				if(row<0){
					row++;
					System.out.println(row+","+col);
					break;
				}
				
			}
			
			
		}
	}
		
}

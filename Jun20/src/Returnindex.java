import java.util.Arrays;
import java.util.Scanner;

public class Returnindex {

	public static void main(String[] args) {
		Scanner scn =new Scanner (System.in);
	    System.out.println("Enter the size of the array");
	    int n =scn.nextInt();
	    int [] arr=new int [n];
	    System.out.println("Enter the elements of array");
			    
	    for (int j=0;j<n;j++)
	    {
	       arr[j]=scn.nextInt();
	    }
	
        System.out.println(Arrays.toString(arr));
		 ReturnIndex(arr);
		 
		 
		

	}
	public static void ReturnIndex(int [] arr){
		for (int j=0;j<arr.length;j++){
		for( int i=0 , int count =0; i<arr.length,c ount<arrlength;i++,count++){
		
		
				if (arr[j]==arr[i])
			
				
			
			System.out.println(count);
			
			
			
		}
		System.out.println(j);
	}
	}
}

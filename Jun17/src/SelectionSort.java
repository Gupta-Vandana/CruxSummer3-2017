
public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr={3,4,2,7,1,9};
		SelectionSort(arr);
		display(arr);
		
		

	}
	private static void Swap(int one, int two,int []arr) 
	
	{
		int temp =arr[one];
		arr[one]= arr[two];
		arr[two] = temp;
    }

	public static void SelectionSort(int[]arr){
		int count =1;
		while(count<=arr.length-1){
			for(int i=count;i<arr.length;i++){
				if(arr[count-1]>arr[i]){
					Swap(i,(count-1),arr);
				}
			}
			count++;
		}
	}
	public static void display(int[] arr) {
		for (int val:arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

}

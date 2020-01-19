
public class Bubblesort {

	public static void main(String[] args) {
		int arr[] = { 10, 2, 6, 4, 3 };
		BubbleSort(arr);
		display(arr);
      }

	public static void BubbleSort(int[] arr) {
		int count = 1;
		while (count <= arr.length - 1) {
			for (int i = 0; i < arr.length - count; i++) {
				if (arr[i] > arr[i + 1]) {
					Swap(arr, i, i + 1);
				}
			}
			count++;
		}
	}

	public static void Swap(int[] arr, int one, int two)

	{

		int temp = arr[one];
		arr[one] =arr[ two];
		arr[two ]= temp;

	}
	public static void display(int[] arr) {
		for (int val:arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
}
	
	             

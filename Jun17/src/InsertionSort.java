
public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 6, 3, 5, 2, 19 };
		display(arr);
		InsertionSort(arr);
		display(arr);

	}

	public static void Swap(int[] arr, int one, int two)

	{

		int temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;

	}

	public static void InsertionSort(int[] arr) {
		int count = 1;
		while (count <= arr.length - 1) {
			for (int i = count; i > 0; i--) {
				if (arr[i - 1] > arr[i]) {
					Swap(arr, i - 1, i);

				} else {
					break;
				}

			}
			count++;
		}
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

}

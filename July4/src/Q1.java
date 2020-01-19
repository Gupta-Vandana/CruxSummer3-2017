
public class Q1 {

	public static void main(String[] args) {
		int[] arr = { 40, 33, 25, 13, 54 };

	    int[] a = mergesort(arr, 0, arr.length - 1);
	    display(a, 0);
		quicksort(arr, 0, arr.length - 1);
		//display(arr, 0);
        

	}

	public static void display(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		System.out.print(arr[vidx] + " ");
		display(arr, vidx + 1);
	}

	 public static void inverse(int[] arr, int index) {
	 if (index == arr.length - 1) {
	 return;
	 }
	 int temp = 0;
	 arr[index] = temp;
	 inverse(arr, index + 1);
	 arr[temp] = index;
	
	 }

	public static int[] mergetwoarray(int[] arr1, int[] arr2) {
		int i = 0;
		int j = 0;
		int[] result = new int[arr1.length + arr2.length];
		int k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				result[k] = arr1[i];
				i++;
				k++;

			} else {
				result[k] = arr2[j];
				j++;
				k++;
			}
		}
		while (i < arr1.length) {
			result[k] = arr1[i];
			k++;
			i++;
		}
		while (j < arr2.length) {
			result[k] = arr2[j];
			k++;
			j++;
		}
		return result;

	}

	public static int[] mergesort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;

		}
		int mid = (lo + hi) / 2;
		int[] lhalf = mergesort(arr, lo, mid);
		int[] shalf = mergesort(arr, mid + 1, hi);
		int[] sorted = mergetwoarray(lhalf, shalf);
		return sorted;

	}

	public static void quicksort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;

		}
		int left = lo;
		int right = hi;
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}
		}
		quicksort(arr, lo, right);
		quicksort(arr, left, hi);

	}
	public static int  getpolyval(int x,int n){
		
		for (int i=n;i>=0;i--){
			int r=i*x;
			
		}
		
		return getpolyval(x,n-1);
	}
}

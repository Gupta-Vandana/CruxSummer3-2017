
public class Q1array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 22, 55, 99, 11, 88 };
		display(arr);
		max(arr);
		reverse(arr);
		System.out.println(linearsearch(arr,45464));
		System.out.println(max(arr));
		System.out.println((arr));
		System.out.println(reverse(arr));

	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.println(val + " ");

		}
	}

	public static int max(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}

		}
		return max;
	}

	public static int linearsearch(int[] arr, int data) {

		for (int i = 0; i < arr.length; i++) {
			if (data == arr[i]) {
				return i;
			}
		}
		return -1;
	}
	
	
	public static void reverse(int[] arr)
	{	
	int one=0;
	int last=arr.length-1;
	int temp;
	
	while(one<last)
	{
	 arr[one]=arr[last];
	 temp=arr[one];
	 arr[last]=arr[one];
	 one++;
	 last--;
	 
	}
	System.out.println(arr);
	
	 
	 
	 
	}
}

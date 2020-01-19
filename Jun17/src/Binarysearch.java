import java.util.Scanner;

public class Binarysearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("enter the no. to be find");
		int data =scn.nextInt();
	
		int[] arr = { 1,2,4,5,8,9 };
		System.out.println(BinarySearch(arr,data));

	}

	public static int BinarySearch(int[] arr, int data) {
		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (data < arr[mid]) {
				h = mid - 1;

			} else if (data > arr[mid]) {
				l = mid + 1;
			}

			else {
				return mid;

			}
		}
		return -1;
	}

}

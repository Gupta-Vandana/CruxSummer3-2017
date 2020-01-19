
public class recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int x = 5;
		int[] arr = { 1, 2, 3, 4, 3 };
		int v = 0;
		int k = 3;
		int b=arr.length;
	
		 System.out.println(Q2(n,x));
		//displayreverse(arr, v);
		//findindex(arr,v,k);
		//lastindex(arr,b,k);
		//firstindex(arr,v,k);
		//max(arr,b);

	}

	public static void Q1(int n) {
		if (n == 0) {
			return;
		}

		if (n % 2 != 0) {
			System.out.println("Hi" + n);
		}

		Q1(n - 1);

		if (n % 2 == 0)

		{
			System.out.println("Bye" + n);
		}

	}

	public static int Q2(int n, int x) {
		if (n == 0) {
			return 1;
		}

		
		  int pow=Q2(x,n-1); 
		  int p=(int)Math.pow(x,n); 
		 return p;
		 

		/*if (n % 2 == 0) {
			int x1 = (int) Q2(n / 2, x);
			int x2 = (int) Math.pow(x1, 2);
			return x2;
		} else {

			int x1 = (int) Q2(n / 2, x);
			int x2 = (int) Math.pow(x1, 2);
			return x2 * x;*/
		}

	


	public static void displayreverse(int[] arr, int v) {
		if (v == -1) {
			return;
		}
		System.out.println(arr[v]);
		displayreverse(arr, v - 1);

	}

	public static void findindex(int arr[], int k, int v) {

		if (v == 0) {
			return ;
		}
		
		
		findindex(arr, k, v - 1);


		if (arr[v] == k)
			System.out.println( true);

		

	}

	public static void  lastindex(int[] arr, int b, int k) {
		if (b == -1) {
			return ;
		}

		 lastindex(arr,b-1,k);

		if (arr[b] == k) {
			System.out.println(b);
		}

	}
	public static void firstindex(int []arr,int v,int k){
		if (v==arr.length-1){
			return ;
		}
		 firstindex(arr,v+1,k);
		if (arr[v]==k){
			System.out.println(v);
			
		}
	
		
		
	}
	public static int max(int [] arr,int b){
		if(b==arr.length-1){
			return arr[b];
		}
		int m=max(arr,b+1);
		if (m>arr[b]){
			return m;
		}
		else {
			return arr[b];
		}
		
	}
	public static void allindex(int [] arr,int k){
		
	}
	
}

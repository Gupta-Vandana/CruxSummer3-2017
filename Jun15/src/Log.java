import java.util.Scanner;

public class Log {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("enter the base");
		int n1=scn.nextInt();
		System.out.println("enter the power");
		int n2=scn.nextInt();
		System.out.println(power(n1,n2));
	}
		
		public static  int power(int n1,int n2){
			
		
		{
			
		    int pow =1;
		    int count =1;
		
		   while (count<=n2)
		{
			pow =pow *n1;
			count ++;
			
		}
		System.out.println(pow);
		return pow;
		

	}


	}

}

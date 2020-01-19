import java.util.Scanner;

public class SpiralDisplay {

	public static void main(String[] args) {
		System.out.println("Enter the number of lines");
		Scanner obj=new Scanner(System.in);
		int n=obj.nextInt();
		int i,j,c=1;
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=i;j++)
			{
				System.out.print(c);
				c++;
			}
			System.out.print("\n");
		}
     }
	}



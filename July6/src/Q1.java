import java.util.Arrays;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 15;
		 Q1(n);
		//String s = "nitin";
		//System.out.println(countpalindrome(s));
		int cr=0;
		int ec=10;
		int er=10;
		int cc=0;		
		int[][] sa=new int[cr][cc];
		//System.out.println(bb(0,10,s));
		//System.out.println (cmp()

	}

	public static void Q1(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		for (int i = 2; i * i <= n; i++) {

			if (prime[i] == false) {
				continue;
			}

			for (int j = 0; j * i <= n; j++) {
				prime[i * j] = false;

			}
		}

		for (int i = 2; i <= n; i++) {
			if (prime[i] == true) {
				System.out.println(i);
			}
		}

	}

	public static int countpalindrome(String s) {
		int count = 0;
		// for even;
		for (int axis = 0; axis < s.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {

				if (s.charAt(axis - orbit) == s.charAt(axis + orbit)) {
					count++;
				} else
					break;
			}
		}

		// for odd;
		for (double axis = 0.5; axis < s.length(); axis++) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
				if (s.charAt((int) (axis - orbit)) == s.charAt((int) (axis + orbit))) {
					count++;
				} else
					break;

			}

		}
		return count;

	}
	public static int bb(int curr, int end ,int [] s){
		if(curr==end ){
			return 1;
		}
		if (curr>end){
			return 0;
		}
		int cdice = 0;
		if(s[cdice]!=0) {
			return s[cdice];
		}
		
		 int count = 0;
		for (int i=1;i<=6;i++){
			 cdice=bb(curr+i,end,s);
			count+=cdice;
			
			
		}
		s[curr]=count;
		return count;
	}
	public static int cmp(int cr,int er,int ec, int [][] sa){
		if (cr==er && cc==ec){
			return 1;
		}
		if (cc>ec || cr>er){
			return 0;
		}
		if (sa[cr][cc]!=0){
			return sa[cr][cc];
		}
		int ch=cmp(cr,cc+1,er,ec);
		s[cr][cc]=[ch];
		int cv=cmp(cr+1,cc,er,ec);
		s[cr][cc]=[cv];
		return 
	}
	
}

import java.util.ArrayList;

public class Q1 {

	public static void main(String[] args) {
		// System.out.print(getqueenpath(0, 0, 2, 2));
		// printssascii("abc", " ");
		
		//permutation("sumit"," ");
		//mazepath(0,0,2,2,"ans");

	}

	public static ArrayList<String> getmazepath(int cr, int cc, int er, int ec) {
		if (cr == er && cc == cr) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}
		if (cc > ec || cr > er) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = getmazepath(cr, cc + 1, er, ec);
		for (String rs : rrh) {
			mr.add("h" + rs);
		}

		ArrayList<String> rrv = getmazepath(cr + 1, cc, er, ec);
		for (String rs : rrv) {
			mr.add("v" + rs);
		}

		if (cc == cr || cr + cc == ec) {
			ArrayList<String> rrd = getmazepath(cr + 1, cc + 1, er, ec);
			for (String rs : rrd) {
				mr.add("d" + rs);
			}
		}
		return mr;
	}

	public static ArrayList<String> getqueenpath(int cr, int cc, int er, int ec) {
		if (cr == er && cc == cr) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}
		if (cc > ec || cr > er) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();

		int move = 1;
		while (move <= ec) {

			ArrayList<String> rrh = getqueenpath(cr, cc + move, er, ec);
			for (String rs : rrh) {
				mr.add("h" + move + rs);
			}
			move++;
		}
		move = 1;
		while (move <= er) {
			ArrayList<String> rrv = getqueenpath(cr + move, cc, er, ec);
			for (String rs : rrv) {
				mr.add("v" + move + rs);
			}
			move++;
		}
		move = 1;
		while (move <= er && move <= ec) {

			ArrayList<String> rrd = getqueenpath(cr + move, cc + move, er, ec);
			for (String rs : rrd) {
				mr.add("d" + move + rs);
			}
			move++;

		}

		return mr;

	}

	public static void printssascii(String qst, String ans) {

		if (qst.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = qst.charAt(0);
		String roq = qst.substring(1);

		printssascii(roq, ans + " ");
		printssascii(roq, ans + ch);
		printssascii(roq, ans + (int) ch);

	}

	public static void permutation(String qst, String ans) {

		if (qst.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = qst.charAt(0);
		String s = qst.substring(1);
		for (int i = 0; i < ans.length(); i++) {
			permutation(s, ans.substring(0, i) + ch + ans.substring(i));
		
		}

	}

	public static void keypad(String qst, String ans) {
		if (qst.length()==0){
			System.out.println(ans);
			return;
		}
		
		

	}

	public static String getChoice(char key) {
		if (key == '1') {
			return "abc";
		}
		if (key == '2') {
			return "def";
		}
		if (key == '3') {
			return "ghi";
		}
		if (key == '4') {
			return "jkl";
		}
		if (key == '5') {
			return "mno";
		}
		if (key == '6') {
			return "pqrs";
		}
		if (key == '7') {
			return "tuv";
		}
		if (key == '8') {
			return "wx";
		}
		if (key == '9') {
			return "yz";
		}
		if (key == '0') {
			return ".;";
		}
		return "";
	}
	
	
	
	
	public static void mazepath(int cr,int cc , int er, int ec, String ans)
	{
		if (cr == er && cc == cr) {
			System.out.println(ans);
			return ;
		}
		if (cc > ec || cr > er) {
			return;
		}
		mazepath(cr+1,cc,er,ec,ans+"H");
		mazepath(cr,cc+1,er,ec,ans+"V");
		mazepath(cr+1,cc+1,ec,er,ans+"D");
		
	    }
  
}

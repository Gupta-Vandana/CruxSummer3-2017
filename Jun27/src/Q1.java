import java.util.ArrayList;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] one = { 1, 1, 2, 2, 2, 3, 5, 6 };
		int[] two = { 1, 1, 1, 2, 2 };
		String s = "abcd";
		//System.out.println(subAscii(s));
		//getKPC(s);
		int c=0;
		int end=10;
		snakeladder(c,end);
		

	}

	public static ArrayList<Integer> getIntersection(int[] one, int[] two) {
		ArrayList<Integer> l = new ArrayList<>();

		int i = 0;
		int j = 0;
		while (i < one.length && j < two.length) {
			if (one[i] == two[j]) {
				l.add(i, i);
				i++;
				j++;
			} else if (one[i] < two[j]) {
				i++;
			} else
				j++;
		}
		return l;
	}

	public static ArrayList<String> subAscii(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add(s);
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> rr = subAscii(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String rs : rr) {
			mr.add(rs);
			mr.add(ch + rs);
			mr.add((int) ch + rs);

		}
		return mr;

	}
	

	
	public static ArrayList<String> getpermutations(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add(s);
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> rr = getpermutations(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String rs : rr) {
			StringBuilder sb= new StringBuilder();
			for(int i=0;i<=rs.length();i++){
				sb.insert(i,ch);
				}
			return 
			
			}
	

}
	public static ArrayList<String> getKPC(String  s){
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add(s);
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> rr = getKPC(ros);
		ArrayList<String> mr = new ArrayList<>();
		String choices =getcode(ch);
		for (String rs : rr) {
			for (int i=0;i<choices.length();i++){
			
				String ms=choices.charAt(i)+rs;
				mr.add(ms);
			}
			
			}
		return mr;
		
		
	}
	public static String getcode(char key){
	
		if (key=='1'){
			return "abc";
		}
		if (key=='2'){
			return "def"; 
		}if (key=='3'){
			return  "ghi";
		}if (key=='4'){
			return "jkl";
		}if (key=='5'){
			return "mno";
		}if (key=='6'){
			return "pqrs";
		}if (key=='7'){
			return "tuv";
		}if (key=='8'){
			return "wx";
		}if (key=='9'){
			return "yz";
		}if (key=='0'){
			return ".";
		}
		return null;
	}
	public static ArrayList<String> snakeladder(int c,int end){
		if(c==end){
			ArrayList<String> br = new ArrayList<>();
			br.add(" ");
			return br;
		}
			
		
				
				
				
	  ArrayList<String> mr = new ArrayList<>();
		for (int dice=1;dice<=6;dice++){
			ArrayList<String>rrdice=snakeladder(c,end);
			for (String rs:rrdice){
				  mr.add(dice +rs);
			}
			return mr;
					
		}
	}
}



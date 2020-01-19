import java.util.Scanner;

public class Printsubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		String s = "acf";
		stringCompression(s);


	}

	public static void printSubstring(String s) {
		for (int j = 0; j <= s.length(); j++) {

			for (int i = j + 1; i <= s.length(); i++) {

				System.out.println(s.substring(j, i));

			}
		}

	}

	public static boolean isPalindrome(String s) {

		for (int i = 0; i <= s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}

		}
		return true;
	}

	public static int countPalindrome(String s) {
		int count = 0;
		boolean x = false;
		for (int j = 0; j < s.length(); j++) {

			for (int i = j + 1; i <= s.length(); i++) {
				String str = s.substring(j, i);

				x = isPalindrome(str);
				if (x == true) {
					count++;
				}

			}
		}

		return count;
	}

     public static void stringCompression( String s){
    	 int count =0;
    	 for (int i=0;i<s.length()-1;i++){
    		 if(s.charAt(i)==s.charAt(i+1)){
    			 count++;
    			 System.out.println(s.charAt(i)+count);
    		 }
    		
    		 
    	 }
    	 
    	 
     }
     public static String Q2(String s){
    	 StringBuilder s1=new StringBuilder();
    	
    	 for (int i=0;i<s.length();i++){
    		 char ch=s.charAt(i);
    		 char n='\0';
    		 if (i%2==0){
    			 n=(char)(ch-1);
    			 
    		 }
    		 else {
    			 n=(char)(ch+1);
    		 }
    		 s1.append(n);
    	 }
    	 return s1.toString();
    	 
     }
     public static String Q3(String s){
    	 StringBuilder s2=new StringBuilder();
    	 for (int i=0;i<s.length()-1;i++){
    		 char ch=s.charAt(i);
    		 int n= s.charAt(i+1)-s.charAt(i);
    		 s2.append(ch);
    		 s2.append(n);
    		
    		  
    	 }
    	 s2.append(s.charAt(s.length()-1));
    	 return s2.toString();
     }
     
     }


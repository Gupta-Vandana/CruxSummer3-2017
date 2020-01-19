import javax.naming.directory.SearchControls;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Trie t=new Trie();
       t.addWord("and");
       t.addWord("ant");
       t.addWord("art");
       t.addWord("bug");
       t.addWord("buy");
       t.addWord("sea");
       t.addWord("seen");
       System.out.println(t.Search("bug"));
       System.out.println(t.Search("bell"));
       System.out.println(t.Search("sea"));
	}

}

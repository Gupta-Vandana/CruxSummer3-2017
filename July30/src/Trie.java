 import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
	private class Node {
		Character data;
		boolean eow;
		HashMap<Character, Node > children =new HashMap<>();
		
	}
	private Node root=new Node ();
	private int numWords=0;
	private int numNodes=1;
	
	public void addWord(String word){
		 addWord(root,word);
	}
	private void addWord(Node node ,String word){
		if (word.length()==0){
			node.eow=true;
			numWords++;
			return ;
		}
		char ch=word.charAt(0);
		String ros=word.substring(1);
		Node children=node.children.get(ch);
		
		if ( children!=null){
			addWord( children,ros);
		}
		else {
			numNodes++;
			Node child =new Node ();
			child.data=ch;
			node.children.put(ch, child);
			addWord( child,ros);
			
		}
	}
	public boolean Search(String word){
		return Search(root,word);
	}
    private boolean Search(Node node ,String word){
    	if (word.length()==0){
    		
    		return node.eow;
    	}
    	char ch=word.charAt(0);
		String ros=word.substring(1);
		
		Node children=node.children.get(ch);
		 
		if (children !=null){
			return Search(children,ros);
		}
		else {
			return false;
		}
    }
    public void remove (String word){
    	remove (root,word);
    }
    private void remove (Node node ,String word){
    	if (word.length()==0){
    		return;
    	}
    	char ch=word.charAt(0);
		String ros=word.substring(1);
		Node children=node.children.get(ch);
    	 
		if (children !=null){
			remove(children,ros);
			if (children.eow ==false && children.children.size()==0){
				node.children.remove(ch);
				numNodes--;
				
			}
		}
		else {
			return ;
		}
    	
    }
    public void display(String word ){
    	display(root ," ");
    }
    private void display(Node node,String osf){
    	if (node.eow){
    		System.out.println(osf);
    	}
    	ArrayList<Character> keys= new ArrayList<>(node.children.keySet());
    	for (Character key :keys){
    		Node child=node.children.get (key);
    		display(child,osf+key);
    	}
    }
    
}

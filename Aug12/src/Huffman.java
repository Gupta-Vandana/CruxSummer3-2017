import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class Huffman {

	
	private HashMap<Character, String> encoder= new HashMap<>();
	private HashMap<String, Character> decoder= new HashMap<>();
	
	private static class Node{
		Node left;
		Node right;
		Character data;
		int freq;
		
	}
	public static final comparator ctor=new comparator();
	public static class comparator implements Comparator<Node>{
		
		public int compare(Node o1,Node o2){
			return o2.freq-o1.freq;
		}
		
	}
	public Huffman(String feeder){
		HashMap<Character, Integer> map=new HashMap<>();
		for (int i=0;i<feeder.length();i++){
			Character ch=feeder.charAt(i);
			if (map.containsKey(ch)){
				map.put(ch,map.get(ch)+1);
			}
			else {
				map.put(ch, 1);
			}
			
		}
		
	}
	PriorityQueue<Node> heap=new PriorityQueue<>(Node.ctor);
	
	Set<Character> key=map.keySet();
	
	for (Character keys:key){
		Node node=new Node();
		node.data=keys;
		node.freq=map.get(keys);
		
		heap.add(node);
		
		Node one=heap.remove();
		Node two=heap.remove();
		
		Node merged=new Node();
		merged.freq=one.freq+two.freq;
		merged.left=one;
		
		merged.right=two;
		heap.add(merged);
		traverse (heap.remove(),"");
		
		
		
		
	}
	private void traverse(Node node,String osf){
		if (node.left==null && node.right==null){
			encoder.put(node.data,osf);
			decoder.put(osf,node.data);
			
			
			
			
		}
	}
	
	
	
			
	
	
	
	
}

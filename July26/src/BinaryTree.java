import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
	Node root;
	int size;

	private class Node {
		int data;
		Node left;
		Node right;

	}

	public BinaryTree() {
		Scanner scn = new Scanner(System.in);
		root = takeInput(scn, root, true);
	}

	public Node takeInput(Scanner scn, Node parent, boolean ilc) {
		// prompt
		if (parent == null) {
			System.out.println("Enter the root");
		} else {
			if (ilc) {
				System.out.println("Enter the left child for " + parent.data);
			} else {
				System.out.println("Enter the right child for " + parent.data);
			}
		}

		// collect data and create node
		int cdata = scn.nextInt();
		Node child = new Node();
		child.data = cdata;
		this.size++;

		// left
		System.out.println("Do you have a left child for " + child.data);
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			child.left = this.takeInput(scn, child, true);
		}

		// right
		System.out.println("Do you have a right child for " + child.data);
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			child.right = this.takeInput(scn, child, false);
		}

		// return
		return child;
	}

	

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (root == null) {
			return false;
		} else
			return true;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String s = "";
		if (node.left != null) {
			s = s + node.left.data;
		}
		s = s + "=>" + node.data + "<=";
		if (node.right != null) {
			s = s + node.right.data;
		}
		System.out.println(s);
		display(node.left);
		display(node.right);

	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}
		int l = size2(node.left);
		int r = size2(node.right);
		return l + r + 1;
	}

	public int Height() {
		return Height(root);
	}

	private int Height(Node node) {
		if (node == null) {
			return -1;
		}
		int lh = Height(node.left);
		int rh = Height(node.right);
		if (lh > rh)
			return lh + 1;
		else
			return rh + 1;
	}

	public int max(Node node) {
		if (node == null) {
			return 0;

		}
		int temp = node.data;
		int lt = max(node.left);
		int rt = max(node.right);
		if (temp < lt) {
			temp = lt;
		} else if (temp < rt) {
			temp = rt;
		}
		return temp;
	}
	public int min() {
		return min(root);
	}

	private int min(Node node) {
		if (node == null) {
			return 0;

		}
		int temp = node.data;
		int lt = min(node.left);
		int rt = min(node.right);
		if (temp < lt) {
			temp = rt;
		} else if (temp < rt) {
			temp = lt;
		}
		return temp;
		
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;

		}
		if (data == node.data) {
			return true;
		}
		boolean l = find(node.left, data);
		if (node.data == data) {
			return true;
		}
		boolean r = find(node.right, data);
		if (node.data == data) {
			return true;
		}
		return false;
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data + " ,");
		postOrder(node.left);
		postOrder(node.right);
	}

	public void preorder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}

		preOrder(node.left);
		preOrder(node.right);
		System.out.println(node.data + " ,");
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.println(node.data + " ,");
		inOrder(node.right);

	}

	public void postOrderI() {
		postOrderIterative(root);
	}

	public class TraversalPair {
		Node node;
		boolean self = false;
		boolean left = false;
		boolean right = false;

	}

	private void postOrderIterative(Node node) {
		LinkedList<TraversalPair> stack = new LinkedList<>();

		TraversalPair rp = new TraversalPair();
		rp.node = root;

		stack.addFirst(rp);
		while (stack.size() != 0) {
			rp = stack.getFirst();
			if (rp.self == false) {
				System.out.println(node.left.data);
				rp.self = true;
			}

			else if (rp.left == false) {
				TraversalPair lp = new TraversalPair();
				lp.node = rp.node.left;
				stack.addFirst(lp);
				lp.left = true;

			} else if (rp.right == false) {
				TraversalPair rvp = new TraversalPair();
				rvp.node = rp.node.right;
				stack.addFirst(rvp);
				rvp.left = true;

			}

			else {
				stack.removeFirst();
			}

		}
	}

	// preorder;
	private void preOrderIterative(Node node) {
		LinkedList<TraversalPair> stack = new LinkedList<>();

		TraversalPair rp = new TraversalPair();
		rp.node = root;

		stack.addFirst(rp);
		while (stack.size() != 0) {
			rp = stack.getFirst();

			if (rp.left == false) {
				TraversalPair lp = new TraversalPair();
				lp.node = rp.node.left;
				stack.addFirst(lp);
				lp.left = true;

			} else if (rp.self == false) {

				System.out.println(node.left.data);
				rp.self = true;
			} else if (rp.right == false) {
				TraversalPair rvp = new TraversalPair();
				rvp.node = rp.node.right;
				stack.addFirst(rvp);
				rvp.left = true;

			}

			else {
				stack.removeFirst();
			}

		}
	}

	private void inOrderIterative(Node node) {
		LinkedList<TraversalPair> stack = new LinkedList<>();

		TraversalPair rp = new TraversalPair();
		rp.node = root;

		stack.addFirst(rp);
		while (stack.size() != 0) {
			rp = stack.getFirst();

			if (rp.left == false) {
				TraversalPair lp = new TraversalPair();
				lp.node = rp.node.left;
				stack.addFirst(lp);
				lp.left = true;

			} else if (rp.self == false) {

				System.out.println(node.left.data);
				rp.self = true;
			} else if (rp.right == false) {
				TraversalPair rvp = new TraversalPair();
				rvp.node = rp.node.right;
				stack.addFirst(rvp);
				rvp.left = true;

			}

			else {
				stack.removeFirst();
			}

		}
	}

	public void levelOrderI(Node node) {
		Node cnode = root;

	}

	public BinaryTree(int[] post, int[] in) {
		root = construct(post, in, 0, post.length - 1, 0, in.length - 1);
	}

	private Node construct(int[] post, int[] in, int poei, int posi, int isi, int iei) {
		if (posi > poei || isi > iei) {
			return null;
		}
		Node node = new Node();
		node.data = post[poei];
		this.size++;

		int idx = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == node.data) {
				idx = i;
				break;
			}
		}
		int clse = idx - isi;
		node.left = construct(post, in, posi, posi + clse - 1, isi, idx - 1);
		node.right = construct(post, in, posi + clse, poei - 1, idx + 1, iei);

		return node;
	}
	public void WS(){
		System.out.println(root.data);
		WS(root);
	}
	private void WS(Node node){
		if (node==null){
			return;
		}
		if (node.left!=null && node.right==null){
			System.out.println(node.data);
		}
		if(node.left==null && node.right!=null){
			System.out.println(node.data);
		}
			WS(node.left);
			WS(node.right);
		
	}
	private class HeapMover{
		Node node;
	}
	public void removeLeaves(){
		HeapMover h =new HeapMover ();
		removeLeaves(root,h);
	}
	private void removeLeaves(Node node,HeapMover h ){
		if (node==null){
			return ;
		}
		if (node.left!=null && node.right!=null){
			h.node=null;
		}
		removeLeaves(node.left,h);
		removeLeaves(node.right, h);
	}
	
	
	
	public boolean isBST(Node node ){
		 if (node==null){
		 return false;
		 }
		 if (node.left!=null && max(node.left) >node.data){
		 return false;
		 }
		 if (node.right!=null && min(node.right) <node.data){
		 return false;
		 }
		 if (!isBST(node.left) || !isBST(node.right) ){
		 return false;
		 }
		 return true;
		
		 }
	public int  countBST(Node node){
		if (node==null){
			return 0;
		}
		
		if(isBST(node)){
			return size2(node) +1;
			}
		return  0 ;
		
		
	}
	public void LevelOrder (){
		LevelOrder (root);
	}
	public void LevelOrder(Node node){
		  Queue<Node> q=new LinkedList <Node>();
		  q.add(root);
		  
		  while (!q.isEmpty()){
			 Node tempnode=  q.poll();
			 
			 System.out.println(tempnode.data);
			 
			 if (tempnode!=null){
				 q.add(tempnode.left);
			 }
			 if (tempnode!=null){
				 q.add(tempnode.right);
			 }
			  
			  
		  }
	}
	public void LevelOrder2 (){
		LevelOrder2(root);
	}
	
	public void LevelOrder2(Node node){
		
	}
	public void PrintGivenLevel (Node node,int lev){
		if (node==null){
			return;
			
		}
		if (lev==1){
			System.out.println(root.data + " ");
		}
		else if (lev>1){
			PrintGivenLevel(node.left, lev-1);
			PrintGivenLevel(node.right, lev-1);
		}
	}
	
	//GEEKS FOR GEEKS 
	// 10/01
	// 1.DELETE A TREE
	
	public void Q1(Node node){
		if (node==null){
			return;
		}
		
		Q1(node.left);
		Q1(node.right);
		node=null;
	}
	
	//2.Height of a Tree
	
	public int Q2(){
		return Q2(root);
	}
	
	public int Q2(Node node){
		if (node==null){
			return 0;
		}
		int l=Q2(node.left);
		int r=Q2(node.right);
		 
		if (l>r){
			return l+1;
		}
		else
			 return r+1;
				
		}
	
	
	//3.Determine if Two Trees are Identical
	
	public boolean Q3(Node node1,Node node2){
		if (node1==null && node2==null){
			return true;
			
		}
		
		if (node1!=null && node2!=null){
			return node1.data ==node2.data && Q3(node1.left, node2.left  ) && Q3(node1.right, node2.right);
		}
		return false;
		
	}
	//4.RETURN SIZE
	public int Q4(){
		return Q4(root);
	}
	
	
	 public int Q4(Node node){
		 if (node==null){
			 return 0;
		 }
		int l= Q4(node.left);
		int r= Q4(node.right);
		return l+r+1;
		 
	 }
	 
	   //5.Root to leaf path sum equal to a given number
	 
	   //6.determine if a binary tree is height-balanced?
	 
	 
	   //7.DIAMETER OF THE TREE
	 
	   //8.Check for Children Sum Property in a Binary Tree
	 
	
	 
	 
       //9.count leaf nodes in a binary tree
	 public int Q9(){
		 return Q9(root);
	 }
           public int  Q9(Node node){
        	   if (node==null){
        		   return 0;
        	   }
        	   
        	   if (node.left==null && node.right==null){
        		   return 1;
        	   }
        	   Q9(node.left);
        	   Q9(node.right);
        	   return Q9(node.left) + Q9(node.right);
           }
           
           //10.
           
           //11.Given a binary tree, print out all of its root-to-leaf paths one per line.
           //12.Populate Inorder Successor for all nodes
           
}
	 
	 
	 
	
	
	

	
	
	
	
	   


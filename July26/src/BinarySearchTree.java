

public class BinarySearchTree {

	Node root;
	int size;

	private class Node {
		int data;
		Node left;
		Node right;

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

	public int max(Node node) {
		if (node.right == null) {
			return node.data;
		} else {
			return max(node.right);
		}
	}

	public int max() {
		return max(root);
	}

	public int min() {
		return min(root);
	}

	private int min(Node node) {
		if (node.left == null) {
			return 0;

		} else {
			return min(node.right);
		}

	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;

		}

		if (node.data < data) {
			return find(node.right, data);
		}

		if (node.data > data) {
			return find(node.left, data);
		}
		return true;

	}

	public void add(int data) {
		add(root, data);
	}

	private void add(Node node, int data) {
		if (node.data > data) {
			if (node.left != null) {
				add(node.left, data);
			} else {
				Node cnode = new Node();
				cnode.data = data;
				size++;
				node.left = cnode;
			}
		}
		if (node.data < data) {
			if (node.right != null) {
				add(node.right, data);
			} else {
				size++;
				Node cnode = new Node();
				cnode.data = data;
				node.right = cnode;
			}
		} 
	}

	
	public BinarySearchTree(int[] arr) {
		root = BSTfromArray(arr, 0, arr.length - 1);
	}

	

	private Node BSTfromArray(int[] arr, int s, int e) {
		if (s > e) {
			return null;
		}
		int m = (s + e) / 2;
		Node cnode = new Node();
		cnode.data = arr[m];

		cnode.left = BSTfromArray(arr, s + 1, m - 1);
		cnode.right = BSTfromArray(arr, m + 1, e);

		return cnode;
	}

	

	public void inorder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data + " ,");
		inOrder(node.left);
		inOrder(node.right);
	}

	public void remove2(int data) {
		remove2(data, root, null, false);
	}

	private void remove2(int data, Node node, Node parent, boolean ilc) {
		if(node==null){
			return ;
		}
		if (data > node.data) {
			remove2(data, node.right, node, false);
		}
		else if (data < node.data) {
			remove2(data, node.left, node, true);
		} 
		else {
			if (node.left!=null && node.right!=null){
				int m=max (node.left);
				node.data=m;
				remove2(data,node.left,node,true);
			}
			else {
				size--;
				if (ilc)
					parent.left=(node.left !=null ? node.left :node.right);
				else 
					parent.right=(node.left !=null ? node.left :node.right);
			}
		}

	}
	 private class HeapMover  {
	
		 int sum=0;

	}
	 public void  replaceWS() {
		 HeapMover h=new  HeapMover();
		 replace(root,h);
		 
		
	}
	 public void replace(Node node,HeapMover h){
		 if (node==null){
			 return;
		 }
		  replace(node.right,h);
		  int temp= node.data;
		  node.data=h.sum;
		  h.sum+=temp;
		  replace(node.left,h);
	 }
	 public void pir(int l,int h,Node node){
		 if(node==null){
			 return ;
		 }
		 if (h<node.data){
			 pir( l,h,node.left);
			 }
		 else if(l>node.data) {
			 pir(l,h,node.right);
		 }
		 else {
			 System.out.println(node.data);
			 pir(l,h,node.left);
			 pir(l, h, node.right);
		 }
		 
	 }

}

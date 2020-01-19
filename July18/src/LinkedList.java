
public class LinkedList {

	Node head;
	Node tail;
	int size;

	public class Node {
		int data;
		Node next;
	}

	public void addLast(int data) {
		if (this.size == 0) {
			handleAdd0(data);

		} else {
			Node node = new Node();
			node.data = data;
			node.next = null;

			this.tail.next = node;
			this.tail = node;
			this.size++;

		}
	}

	private void handleAdd0(int data) {
		Node node = new Node();
		node.data = data;

		this.head = node;
		this.tail = node;
		this.size++;
	}

	public void addFirst(int data) {
		if (this.size == 0) {
			handleAdd0(data);
		} else {
			Node node = new Node();
			node.data = data;
			node.next = this.head;

			this.head = node;
			this.size++;

		}
	}

	public void addAt(int data, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			System.out.println("Out of Bound");
		}
		if (this.size == 0) {
			handleAdd0(data);
		}
		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size) {
			this.addLast(data);

		} else {
			Node m1 = getNodeAt(idx - 1);
			Node p1 = m1.next;

			Node n = new Node();
			n.data = data;
			m1.next = n;
			n.next = p1;
			this.size++;

		}

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public int getFirst() throws Exception {
		if (this.size == 0) {
			System.out.println("list is empty");
		}
		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			System.out.println("list is empty");
		}
		return this.tail.data;
	}

	public int getAt(int idx) throws Exception {
		if (this.size == 0) {
			System.out.println("list is empty");
		}
		if (idx < 0 || idx > this.size - 1) {
			throw new Exception("Out of bound");
		}
		int cidx = 0;
		Node cnode = this.head;
		while (cidx < idx) {
			cnode = cnode.next;
			cidx++;

		}
		return cnode.data;

	}

	private Node getNodeAt(int idx) throws Exception {

		if (this.size == 0) {
			System.out.println("list is empty");
		}
		if (idx < 0 || idx > this.size - 1) {
			throw new Exception("Out of bound");
		}
		int cidx = 0;
		Node cnode = this.head;
		while (cidx < idx) {
			cnode = cnode.next;
			cidx++;

		}
		return cnode;

	}

	private int HandleAt1() {
		int rv = this.head.data;
		this.head = null;
		this.tail = null;
		this.size--;
		return rv;

	}

	public int removeFirst() {
		if (this.size == 0) {
			System.out.println("list is empty");
		}

		if (size == 1) {
			return HandleAt1();
		} else {
			int rv = this.head.data;
			this.head = this.head.next;
			this.size--;
			return rv;
		}

	}

	public int removeLast() throws Exception {
		if (this.size == 0) {
			System.out.println("list is empty");
		}
		if (this.size == 1) {
			return HandleAt1();
		}
		int rv = this.tail.data;
		this.tail = this.getNodeAt(this.size - 2);
		this.tail.next = null;
		this.size--;
		return rv;

	}

	public int removeAt(int idx) throws Exception {
		if (idx < 0 || idx > this.size - 1) {
			System.out.println("Out of Bound");
		}
		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == size - 1) {
			return this.removeLast();
		} else {
			Node m1 = getNodeAt(idx - 1);
			Node n = m1.next;
			Node p1 = this.getNodeAt(idx + 1);
			m1.next = p1;
			this.size--;
			return n.data;
		}
	}

	// july 19

	public void reversePointerIterative() throws Exception {
		Node p = this.head;
		Node c = this.head.next;
		while (c != null) {
			Node ln = c.next;
			c.next = p;
			p = c;
			c = ln;

		}
		Node t = this.head;
		this.head = this.tail;
		this.tail = t;
		this.tail.next = null;

	}

	public void CallPointerRecursive() throws Exception {
		this.reversePointerRecursive(this.head, this.head.next);
		Node t = this.head;
		this.head = this.tail;
		this.tail = t;
		this.tail.next = null;

	}

	private void reversePointerRecursive(Node p, Node c) throws Exception {
		if (c == null) {
			return;
		}

		Node ln = c.next;
		c.next = p;
		p = c;
		c = ln;

		reversePointerRecursive(p, c);
	}

	public void displayReverse() {
		this.displayRR(this.head);
	}

	private void displayRR(Node n) {
		if (n == null) {
			return;
		}
		displayRR(n.next);
		System.out.println(n.data);
	}

	public void reverseDataR() {
		HeapMover l = new HeapMover();
		l.n = head;
		reverseDataRW(l, this.head, 0);
	}

	public class HeapMover {
		Node n;
	}

	private void reverseDataRW(HeapMover l, Node r, int f) {
		if (r == null) {
			return;
		}
		reverseDataRW(l, r.next, f + 1);
		if (f >= this.size / 2) {
			int temp = l.n.data;
			l.n.data = r.data;
			r.data = temp;
			l.n = l.n.next;

		}

	}

	public void fold() {
		HeapMover l = new HeapMover();
		l.n = head;
		fold(l, this.head, 0);
	}

	private void fold(HeapMover l, Node r, int f) {
		if (r == null) {
			return;
		}
		fold(l, r.next, f + 1);
		if (f > size / 2) {
			Node o = l.n.next;
			l.n.next = r;
			r.next = o;
			l.n = o;

		} else if (f == size / 2) {
			this.tail = r;
			this.tail.next = null;
		}
	}

	public int mid() {
		Node f = head;
		Node s = head;

		while (true) {
			if (f.next == null || f.next.next == null) {
				break;
			}

			s = s.next;
			f = f.next.next;
		}
		return s.data;
	}

	// without using this.size
	public int findK(int k) {
		Node f = head;
		Node s = head;

		for (int i = 0; i <= k; i++) {
			f = f.next;
		}
		while (true) {
			if (f.next == null) {
				break;

			}
			f = f.next;
			s = s.next;
		}
		return s.data;

	}

	private Node midNode() {

		Node f = head;
		Node s = head;

		while (true) {
			if (f.next == null || f.next.next == null) {
				break;
			}

			s = s.next;
			f = f.next.next;
		}
		return s;

	}

	public LinkedList mergeSortedLinked(LinkedList other) {
		LinkedList merged = new LinkedList();
		Node tt = this.head;
		Node ot = other.head;

		while (tt != null && ot != null) {
			if (tt.data < ot.data) {
				merged.addLast(tt.data);
				tt = tt.next;
			} else {
				merged.addLast(ot.data);
				ot = ot.next;
			}

		}
		while (tt != null) {
			merged.addLast(tt.data);
			tt = tt.next;

		}
		while (ot != null) {
			merged.addLast(ot.data);
			ot = ot.next;

		}
		return merged;

	}

	public LinkedList mergeSort() {
		if (this.size == 1) {
			return this;
		}

		Node mid = midNode();
		Node nmid = mid.next;

		LinkedList fhalf = new LinkedList();
		LinkedList shalf = new LinkedList();

		fhalf.head = this.head;
		fhalf.tail = mid;
		fhalf.tail.next = null;

		shalf.head = nmid;
		shalf.tail = this.tail;

		fhalf.size = (this.size + 1) / 2;
		shalf.size = (this.size) / 2;

		LinkedList ms = new LinkedList();

		fhalf = fhalf.mergeSort();
		shalf = shalf.mergeSort();
		ms = fhalf.mergeSortedLinked(shalf);
		return ms;

	}

	// 1. Implement code to swap two elements of a Linked List
	public void SwapElements(int idx1, int idx2) {

	}

	// 2. Eliminate duplicates from a sorted linked list
	public void EliminateDupli() throws Exception {
		int idx = 1;
		Node c = this.head;
		while (c != null) {
			if (c.data == c.next.data) {
				Node m1 = getNodeAt(idx - 1);
				Node n = m1.next;
				Node p1 = this.getNodeAt(idx + 1);
				m1.next = p1;
				this.size--;
			}
			c = c.next;
			idx++;
		}

	}
}


public class Stack {

	protected int[] data;
	protected int tos = -1;
	int value;
	int cap;

	public Stack() {
		this(5);

	}

	public Stack(int cap) {
		this.data = new int[cap];

	}

	public void push(int item) throws Exception {   
		if (tos == data.length - 1) {
			System.out.println("stack is full");
		}

		this.tos++;
		this.data[this.tos] = item;
	}

	public int pop() throws Exception {
		if (this.isempty()) {
			System.out.println("stack is empty");
		}
		int rv = this.data[tos];
		this.data[this.tos] = 0;
		this.tos--;

		return rv;
	}

	public void display() {
		for (int i = tos; i >= 0; i--) {
			System.out.println(this.data[i] + " ");
		}
		System.out.println("END");
	}

	public int top() throws Exception {
		if (this.isempty()) {
			System.out.println("stack is empty");
		}
		int rv = this.data[tos];
		return rv;
	}

	public boolean isempty() {
		return this.size() == 0;

	}

	public int size() {
		return this.tos + 1;

	}

}

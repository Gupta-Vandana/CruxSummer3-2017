
public class DynamicQueue extends Queue {

	public void enqueue(int val) throws Exception {
		if (this.size() == this.data.length) {
			int[] old = this.data;
			this.data = new int[2 * old.length];

			for (int i = 0; i < this.size; i++) {
				this.data[i] = old[(front + i) % old.length];

			}
			front = 0;

			
		}
		super.enqueue(val);

	}
	

}

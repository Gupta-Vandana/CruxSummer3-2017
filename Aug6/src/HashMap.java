import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> {
	private class HMNode {
		K key;
		V value;

		HMNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

	private int size;
	private LinkedList<HMNode>[] LLArray;

	public HashMap(int s) {
		this.LLArray = (LinkedList<HMNode>[]) new LinkedList[s];
		for (int i = 0; i < LLArray.length; i++) {
			LLArray[i] = new LinkedList<>();
		}
	}

	public void put(K key, V value) {
		int ai = this.HashFunction(key);
		LinkedList<HMNode> slot = this.LLArray[ai];
		int foundAt = this.FindInSlot(slot, key);

		if (foundAt == -1) {
			HMNode node = new HMNode(key, value);
			slot.addLast(node);
			this.size++;
		} else {
			HMNode addnode = slot.get(foundAt);
			addnode.value = value;
		}
		double lambda = (1.0 * this.size) / this.LLArray.length;
		if (lambda > 2.0) {
			this.rehashing();
		}
	}

	public boolean contansKey(K key) {
		int ai = this.HashFunction(key);
		LinkedList<HMNode> slot = this.LLArray[ai];
		int foundAt = this.FindInSlot(slot, key);

		if (foundAt == -1) {
			return false;
		} else {
			return true;
		}

	}

	public V get(K key) {
		int ai = this.HashFunction(key);
		LinkedList<HMNode> slot = this.LLArray[ai];
		int foundAt = this.FindInSlot(slot, key);

		if (foundAt == -1) {
			return null;
		} else {
			HMNode returnNode = slot.get(foundAt);
			return returnNode.value;
		}

	}

	public V remove(K key) {
		int ai = this.HashFunction(key);
		LinkedList<HMNode> slot = this.LLArray[ai];
		int foundAt = this.FindInSlot(slot, key);

		if (foundAt == -1) {
			return null;
		} else {
			HMNode removeNode = slot.remove(foundAt);
			this.size--;
			return removeNode.value;
		}

	}

	public int HashFunction(K key) {
		int hc = key.hashCode();
		int i = Math.abs(hc) % LLArray.length;
		return i;
	}

	private int FindInSlot(LinkedList<HMNode> slot, K key) {
		for (int i = 0; i < slot.size(); i++) {
			HMNode temp = slot.get(i);
			if (temp.key.equals(key)) {
				return i;
			}

		}
		return -1;
	}

	public int SIZE() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		System.out.println("--------------------------------------");
		for (int i = 0; i < LLArray.length; i++) {
			System.out.println("BUCKET" + i + "=>");
			for (int j = 0; j < LLArray[i].size(); j++) {
				HMNode node = LLArray[i].get(j);
				System.out.println("(" + node.value + "@" + node.key + ")");
			}
		}
		System.out.println("----------------------------------------");
	}

	public ArrayList<K> keySet() {
		ArrayList<K> rv = new ArrayList<>();
		for (int i = 0; i < LLArray.length; i++) {
			for (int j = 0; j < LLArray[i].size(); j++) {
				rv.add(LLArray[i].get(j).key);
			}
		}
		return rv;
	}

	public void rehashing() {
		LinkedList<HMNode>[] oba = this.LLArray;
		this.LLArray = (LinkedList<HMNode>[]) new LinkedList[2 * oba.length];
		for (int i = 0; i < LLArray.length; i++) {
			LLArray[i] = new LinkedList<>();
		}
		this.size = 0;
		for (int i = 0; i < oba.length; i++) {
			for (int j = 0; j < oba[i].size(); j++) {
				HMNode node = oba[i].get(j);
				this.put(node.key, node.value);
			}

		}

	}
}

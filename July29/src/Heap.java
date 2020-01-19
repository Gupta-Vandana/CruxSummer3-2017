import java.util.ArrayList;

public class Heap {
	private ArrayList<Integer> data = new ArrayList<>();
	private boolean isMin;

	public int size() {
		return data.size();
	}

	public void display() {
		System.out.println(data);
	}

	public boolean isEmpty() {
		if (data.size() == 0) {
			return true;
		}
		return false;
	}

	public Heap(boolean isMin) {
		this.isMin = isMin;
	}
	public Heap(boolean isMin,int [] usa){
		this.isMin=isMin;
		for (int val :usa)
		{
			add(val);
		}
		for (int i=data.size()-1/2;i>=0;i--){
			deheapify(i);
		}
	}

	public boolean isLarger(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);

		if (isMin) {
			if (ith < jth) {
				return true;
			} else
				return false;
		} else {
			if (ith > jth) {
				return true;
			} else
				return false;
		}
	}

	public void add(int val) {
		data.add(val);
		upheapify(data.size() - 1);
	} 

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;

		if (isLarger(ci, pi) == true) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	private void swap(int i, int j) {

		int ith = data.get(i);
		int jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);

	}

	private void deheapify(int pi) {

		int li = 2 * pi + 1;
		int ri = 2 * pi + 2;
		
		int max = pi;

		if (li < data.size() && isLarger(li, max) == true) {
			max = li;
		}
		if (ri < data.size() && isLarger(ri, max) == true) {
			max = ri;
		}
		if (max != pi) {
			swap(pi, max);
			deheapify(max);
		}

	}

	public int removeHP() {
		swap(0, data.size() - 1);
		int rv = data.remove(data.size() - 1);
		deheapify(0);
		return rv;
	}

}

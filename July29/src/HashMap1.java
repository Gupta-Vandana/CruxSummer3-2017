import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMap1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "ababababababababbadsgfk";
		int[] one = { 1, 1, 2, 2, 2, 3, 5 };
		int[] two = { 1, 1, 2, 2, 1, 4, 5 };
		System.out.println(highestfreq(word));
		System.out.println(gce1(one, two));
		System.out.println(gce2(one, two));
		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		Q1(arr);

	}

	public static Character highestfreq(String word) {
		HashMap<Character, Integer> hm = new HashMap();

		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);

			if (hm.containsKey(c)) {
				int o = hm.get(c);
				int n = o + 1;
				hm.put(c, n);
			} else {
				hm.put(c, 1);
			}
		}

		Character mC = ' ';
		int mF = 0;

		ArrayList<Character> keys = new ArrayList<>(hm.keySet());
		for (Character key : keys) {
			int f = hm.get(key);

			if (f > mF) {
				mF = f;
				mC = key;
			}
		}

		return mC;
	}

	public static ArrayList<Integer> gce1(int[] one, int[] two) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int val : one) {
			if (hm.containsKey(val)) {
				hm.put(val, hm.get(val) + 1);

			} else {
				hm.put(val, 1);
			}
		}

		ArrayList<Integer> al = new ArrayList<>();
		for (int val1 : two) {
			if (hm.containsKey(val1)) {
				al.add(val1);
				hm.remove(val1);

			} else {
			}
		}
		return al;

	}

	public static ArrayList<Integer> gce2(int[] one, int[] two) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int val : two) {
			if (hm.containsKey(val)) {
				hm.put(val, hm.get(val) + 1);

			} else {
				hm.put(val, 1);
			}
		}

		ArrayList<Integer> al = new ArrayList<>();
		for (int val1 : one) {

			if (hm.containsKey(val1)) {
				al.add(val1);
				if (hm.get(val1) > 1) {

					hm.put(val1, hm.get(val1) - 1);
				} else {
					hm.remove(val1);
				}

			}

		}
		return al;
	}

	public static void Q1(int[] arr) {
		HashMap<Integer, Boolean> hm = new HashMap<>();

		for (int val : arr) {
			hm.put(val, true);

		}
		for (int val : arr) {
			if (hm.containsKey(val - 1)) {
				hm.put(val, false);
			}
		}
		int m = 0;
		int n = 0;
		for (int val : arr) {
			if (hm.get(val) == true) {
				int c = 0;
				while (hm.containsKey(val + c)) {
					c++;
				}
				if (c > m) {
					m = c;
					n = val;
				}
			}
		}
		for (int i = n; i < m + n; i++) {
			System.out.println(i + " ");
		}

	}

}


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] usa = { 1, 2, 3, 4, 5, 6, 7, 8, 90 };
		Heap rh = new Heap(true, usa);
		// rh.add(250);
		// rh.add(500);
		// rh.add(200);
		// rh.add(300);
		// rh.add(100);
		// rh.add(150);
		// rh.add(10);
		rh.display();
		System.out.println(rh.isEmpty());
		System.out.println(rh.size());
		while (rh.size() != 0) {
			System.out.println(rh.removeHP());
		}
		rh.display();
	}

}

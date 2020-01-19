import java.util.ArrayList;
import java.util.Arrays;

public class GenericHeapClient {

	public static void main(String[] args) {
		Car[] cars = new Car[7];
		cars[0] = new Car("Audi", 100, 1000);
		cars[1] = new Car("BMW", 200, 1500);
		cars[2] = new Car("Porsche", 150, 800);
		cars[3] = new Car("Merc", 140, 900);
		cars[4] = new Car("Lambor", 160, 1400);
		cars[5] = new Car("ABC", 190, 1900);
		cars[6] = new Car("DEF", 210, 2100);
		
		GenericHeap<Car> heap = new GenericHeap<>(Car.namerevctor);
		for(Car car: cars){
			heap.add(car);
		}
		heap.display();
		
		while(heap.size() != 0){
			System.out.println(heap.removeHP());
		}
		
		ArrayList<Integer> zero=new ArrayList<>(Arrays.asList(10,15,20,25));
		ArrayList<Integer> one=new ArrayList<>(Arrays.asList(10,15,20,25));
		ArrayList<Integer> two=new ArrayList<>(Arrays.asList(10,15,20,25));
		ArrayList<Integer> three=new ArrayList<>(Arrays.asList(10,15,20,25));
		ArrayList<ArrayList<Integer>> lists=new ArrayList<>(Arrays.asList(zero,one,two,three));
	}
	public static ArrayList<Integer> mergeKLists(ArrayList<ArrayList<Integer>> lists){
		ArrayList <Integer> list=new ArrayList<>();
		ArrayList<Integer> heap=new GenericHeap<>(Pair.Comparator);
		//fill
		for (int i=0;i<lists.size();i++){
			Pair p=new Pair();
			p.ino=0;
			p.lno=i;
			p.data=lists.get(i).get(0);
			heap.add(p);
			
		}
	//while the heap is not empty
		while (heap.size()!=0){
			Pair top=heap.removeHP();
			list.add(top.data);
			top.ino++;
			if (top.ino<lists.get(top.ino.size()){
				top.data=lists.get(top.ino.get.top.ino);
				heap.add(top);
				
			}
		}
		return list;
	}
	private static class Pair{
		int data;
		int lno;
		int ino;
		
		public static final PairComparator Comparator=new PairComparator();
		private static class PairComprator implements Comparator<Pair>{
			
		}
	}
	private int Compare (Pair o1,Pair o2 ){
		return o2.data-o1.data;
	}
//	public static void mergeKlists(int arr){
//		arr.sort() ;
//	}
	

}


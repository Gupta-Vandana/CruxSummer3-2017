

public class Clientbst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr={1,2,3,4,5,6,7,8,9};
      BinarySearchTree bst=new BinarySearchTree(arr);
      bst.add(50);
      bst.add(25);
      bst.add(75);
      bst.add(12);
      bst.add(37);
      bst.add(62);
      bst.add(87);
      bst.add(30);
      bst.add(40);
      bst.add(60);
      bst.add(70);
//      System.out.println(bst.max());
//      System.out.println(bst.min());
//      System.out.println(bst.find(12));
      bst.inorder();
 //       bst.display();
   //     System.out.println("------------------");
   //     bst.remove2(5);
   //     bst.display();
      

}
}

 import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree { //REVISE PROPERLY  ..........!!!!!!!!!!!!!!!!!
	
	private Node root;
	private int size;
	
	public int  Size (){
		return this.size;
	}
	
	
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
		
		
	}
	public  GenericTree(){
		Scanner scn=new Scanner(System.in);
		root=takeInput(null,-1,scn);
		
	}
	private Node takeInput(Node parent,int chIdx, Scanner scn){
		if (parent==null){
			System.out.println("data for root");
			
		}
		else {
		System.out.println( "data for "+chIdx+" child");
		
		}
		int data=scn.nextInt();
		
		Node child =new Node();
		child.data=data;
		this.size++;
		
		System.out.println("Number of child " +child.data);
		 
		  int n=scn.nextInt();
		   for (int i=0;i<n;i++){
			   Node gchild=takeInput(child,i,scn);
			   child.children.add(gchild);
		  
		  
		}
		return child ;
		
	}
		  
		  
		  public void  display(){
			  display(root);
		  }
		  
		  private void display(Node node){
			  String s=node.data  + "=>";
	 		  
		  for (  Node child :node.children){
			 s+=child.data;
			
		  }
		  System.out.println( "----");
		  
		  for (  Node child :node.children){
            display(child);	
            System.out.println(s +",");
            
            
            }			  
		  
			  
		  }
		  public int size2(){
			  return size2(root);
		  } 
		  private int size2(Node node){
			  int sz=0;
			   for (Node child: node.children){
				   int c=size2(child);
				   sz=sz+c;
				   
			   }
			   return sz+1;
		  }
		  
		  
	    public int max(){
	    	return max(root);
	    }
	    private int max(Node node ){
	    	int max1=node.data;
	    	
	    	for (Node child : node.children){
	    		 max1=child.data;
	    		int temp=max(child);
	    		if (max1<temp){
	    			max1=temp;
	    		}
	    		}
	    	return max1;
	    }
	    public int Height(){
	    	return Height(root);
	    }
	    private int Height (Node node ){
	    	int rh=-1;
	       for ( Node child : node.children){
	    	   
	    		int th=Height(child);
	    		 if (th>rh){
	    			 th=rh;
	    		 }
	    		 
	    		
	    	}
	       return rh+1;
	    	
	    }
	    public boolean find (){
	    	return find(root,10);
	    }
	    private boolean find(Node node , int data){
	    	if (data==node.data){
	    		return true;
	    	}
	    		for ( Node child : node.children){
	    			
	    			boolean  t=find(child,data);
	    			if (node.data==data){
	    				return true;
	    			}
	    			
	    			
	    		}
	    		return false;
	    	}
	    public void mirror(){
	    	mirror (root);
	    }
	    private void mirror(Node node){
	    	if (node==null){
	    		return;
	    	}
	    	int l=0;
	    	int r=node.children.size()-1;
	    
	    	
	    	for (Node child : node.children){
	    		 mirror(child);
	    	}
	    		 while (l<r){
	    			Node x=node.children.get(l);
	    			Node y=node.children.get(r);
	    			
	    			node.children.set(l, y);
	    			node.children.set(r, x);
	    			
	    			l++;
	    			r--;
	    			 
	    		 }
	    		
	    }
	    
	    
	    private void preorder(Node node){
	    	
	    	for (Node child : node.children){
	    		preorder(child);
	    		System.out.println(node.data);
	    	}
	    }
       private void postorder(Node node){
	    	
	    	for (Node child : node.children){
	    		System.out.println(node.data);
	    		postorder(child);
	    		
	    	}
	    }
       
       private void levelOrder(Node node){
    	   LinkedList<Node> l=new LinkedList<>();
    	   l.addFirst(this.root);
    	   while (l.size()!=0){
    	   Node temp=l.removeFirst();
    	   System.out.println(temp.data);
    	   for (Node child : node.children){
    		   l.addLast(child);
    	   }
    	   }
    	   }
       
       public void leveOrderLine(Node node){
    	   LinkedList<Node> l1=new LinkedList<>();
    	   l1.addFirst(this.root);
    	   LinkedList<Node> l2=new LinkedList<>();
    	   while (l1.size()!=0){
    	   
    	   Node temp=l1.removeFirst();
    	   System.out.println(temp.data);
    	   for (Node child : node.children){
    		   l2.addLast(child);
    	   
    	  }
    	   if (l2.size()==0){
    		 l1 = l2;
    		 l2 = new LinkedList<>();
    		 System.out.println();
    		  
    		 }
    	    }
       }
       public class HeapMover {
   		int size;
   		int height;
   		int max=Integer.MIN_VALUE;
   		int min =Integer.MAX_VALUE;
   		boolean found;
//   		int pre;
//   		int suc;
   		Node  jl;
   	}

       
       public void multiSolver(int data){
    	 HeapMover h= new HeapMover(); 
    	 MultiSolver(root,h,80,0);    	 
       }
       private void MultiSolver ( Node node,HeapMover h, int data,int depth ){
    	   h.size++;
    	   
    	   if (node.data>h.max){
    		   h.max=node.data;
    		   
    	   }
           if (node.data<h.min){
        	   h.min=node.data;
    		   
    	   }
           if (node.data>data){
        	   if(h.jl==null){
        		   
           }
           else{
        		if (h.jl.data<node.data){
        		h.jl.data=node.data;
        		   
       }
       }
       }
         //for successor
           int temp=node.data;
           if (data==node.data){
        	   h.found=true;
        	   System.out.println(temp);
        	   }
           if (depth>h.height){
        	   h.height=depth;
           }
           
           for (Node child : node.children){
        	  MultiSolver(child,h,data,depth+1);
        	   
           }
           //for predesor;
           int temp1=node.data;
           if (data==node.data){
        	   System.out.println(temp1);
           }
            }
//       public int kthSmallest(int k){
//    	   int v=Integer.MIN_VALUE;
//    	    for (int i=0;i<k;i++){
//    	    	HeapMover h1=new HeapMover();
//    	    	
//    	    	
//    	    }
//    	    return v;
//    	   
//    	 }
       public void kSmallest(Node node,ArrayList<Integer>list){
    	   list.add(node.data);
    	   for (Node child : node.children){
    		   kSmallest( child,list);
    	   }
       }
       public void Sort(){

    	   
       }
       public void removeLeaf(){
    	   removeLeaf();
       }
       public void removeLeaf( Node node ){
    	       for (int i=node.children.size()-1;i>0;i++) {
    	    	    Node child =node.children.get(i);
    	    	    if (child.children.size()==0){
    	    	    	node.children.remove(child);
    	    	    }
    	       }
    	        for (Node child:node.children){
    	        	removeLeaf(child);
    	        }
    	       removeLeaf(node);
               }
       public void linearise ( Node node){
    	   
    	   for (int i=0;i<node.children.size();i++){
    		   if (node.children.get(0)==null){
    			   
    			  tail(node);
    			  
    			  
    			   
    			   
         }
    		   
    	}
    	   for (Node child:node.children){
    		   linearise(child);    	   }
    	   
        }
       
       
       public Node tail(Node node){
    	   while (node.children.size()!=0){
    		   node=node.children.get(0);
    		   
    		   
    	   }
    	   return node;
       }
}
      
       
       
       

	    


	    
		  
		  
		
		

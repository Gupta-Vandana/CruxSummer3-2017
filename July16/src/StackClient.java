
public class StackClient {

	public static void main(String[] args) throws Exception {
		
//		Stack s=new Stack(10);
//		
//		s.push(10);
//		s.push(20);
//		s.push(30);
//		s.push(40); 
//		s.push(50); 
//		s.push(60); 
//		s.push(70);
//		s.pop(); 
//		s.display();
//		
		Stack s1=new Stack (5);
		Stack s2=new Stack(5);

		
		
// implementing a queue using two stacks		
	    Queue q=new Queue(5);
	     
	    //push operation can done only on stack1
	    s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.push(4); 
		s1.push(5); 
		
		//now pop from stack1 and push on stack2
	    for(int i=0;i<s1.size();i++){
		int r= s1.pop();
		s2.push(r);
	    }
	     // now pop from s2
	    s2.pop();
	    
	    
	    
//  implementing a stack using two queues

	    Stack S=new Stack(); 
	    
	 
	 
	 
	}

}

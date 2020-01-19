
public class Queue {

	
		protected int [] data;
		protected int front;
		protected int size;
		
		
		
//		public Queue() {
//			this(5);
//
//		}

	
	public Queue(int cap){
		this.data=new int [cap];
	}
	
	public void enqueue(int val)   throws Exception{
		if (this.size() == this.data.length - 1) {
			System.out.println(" queue is full");
		}

		int tail=(this.front +this.size)%this.data.length;
		this.data[tail]=val;
		this.size++;
	}
	public int front (){
		return this.data[this.front];
	}
	public int dequeue(){
		int rv=data[front];
		this.data[front]=0;
		this.front=(this.front +1)%this.data.length;
		this.size--;                 
		return rv;
	}
	public int size(){
		return this.size;
	}
	public boolean isempty(){
		return this.size==0;
	}
	public void display(){
		System.out.println("-------------------");
	
		for (int i=0;i<this.size();i++){
			System.out.print(this.data[(front +i)%this.data.length]);
		}
		System.out.println(".");
		System.out.println("-------------------");
	}
		
	
	
}
	


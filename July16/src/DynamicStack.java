
public class DynamicStack extends Stack {
	
	
     public void push(int value ) throws Exception{
    	 if (tos==data.length-1){
    		 int[] old=this.data;
    	 
    	 this.data=new  
    	int [2*old.length];
    	 for (int i=0;i<old.length;i++){
    		 this.data[i]=this.data[i];
    	 }
     }
     
     super.push(value);

}
}

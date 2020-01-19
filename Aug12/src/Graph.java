import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class Graph {
	 
	private HashMap<String, Vertex> vces = new HashMap<>();
 
	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	
	public int numVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (this.containsVertex(vname)) {
			return;
		}
		Vertex vrtx = new Vertex();
		vces.put(vname, vrtx);
	}

	public int numEdges() {
		int rv = 0;
		ArrayList<String> vname = new ArrayList<>(vces.keySet());
		for (String vnam : vname) {
			Vertex vtx = vces.get(vnam);
			rv += vtx.nbrs.size();

		}
		return rv / 2;

	}

	// areNbrs (v1,v2)
	public boolean containsEdge(String v1name, String v2name) {
		Vertex vtx1 = vces.get(v1name);
		Vertex vtx2 = vces.get(v2name);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(v2name)) {
			return false;
		}
		return true;
	}

	public void addEdge(String v1name, String v2name, int weight) {
		Vertex vtx1 = vces.get(v1name);
		Vertex vtx2 = vces.get(v2name);
		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(v2name)) {
			return;
		}
		vtx1.nbrs.put(v2name, weight);
		vtx2.nbrs.put(v1name, weight);

	}

	public void removeEdge(String v1name, String v2name) {
		Vertex vtx1 = vces.get(v1name);
		Vertex vtx2 = vces.get(v2name);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(v2name)) {
			return;
		}
		vtx1.nbrs.remove(v2name);
		vtx2.nbrs.remove(v1name);
	}

	public void removeVertex(String vname) {
		Vertex vtr = vces.get(vname);
		ArrayList<String> nbrname = new ArrayList<>(vtr.nbrs.keySet());
		for (String n : nbrname) {
			Vertex nbrvtx = vces.get(n);
			nbrvtx.nbrs.remove(vname);
		}
		vces.remove(vname);
	}

	public void display() {
		ArrayList<String> nbrname = new ArrayList<>(vces.keySet());

		for (String vn : nbrname) {
			Vertex vtx = vces.get(vn);
			String str = vn + " -> ";
			ArrayList<String> nbr = new ArrayList<>(vtx.nbrs.keySet());
			for (String v : nbr) {
				str += v + "[" + vtx.nbrs.get(v) + "]";

			}
			System.out.println(str);
		}

	}

	public boolean hasPath(String v1name, String v2name) {
		return hasPathHelper(v1name, v2name, new HashMap<>(), v1name);

	}

	private boolean hasPathHelper(String v1name, String v2name, HashMap<String, Boolean> processed, String psf) {

		if (processed.containsKey(v1name) == true) {
			return false;
		}
		processed.put(v1name, true);

		if (this.containsEdge(v1name, v2name)) {
			System.out.println(psf + v2name);
			return true;
		}
		Vertex vtx = vces.get(v1name);
		ArrayList<String> nbrname = new ArrayList<>(vtx.nbrs.keySet());

		for (String nbrnames : nbrname) {
			if (this.hasPathHelper(v1name, v2name, processed, psf + nbrnames) == true) {
				return true;
			}
		}
		return false;
	}

	private class Pair {
		Vertex vtx;
		String vname;
		String psf;

		Pair(String vname, Vertex vtx, String psf) {
			this.vname = vname;
			this.vtx = vtx;
			this.psf = psf;
		}
	}

	public boolean bfs(String v1name,String v2name){
		 LinkedList<Pair> queue=new LinkedList<>();
		 HashMap<String, Boolean> processed=new HashMap<>();
		 
		 Vertex vtx=vces.get(v1name);
		 Pair pair=new Pair(v1name, vtx, v1name);
		 
		 queue.addLast(pair);
		
	 while (queue.size()!=0){
			
		 	 Pair rp=queue.removeFirst();
			 
			 
			 if (!processed.containsKey(rp.vname)){
				processed.put(rp.vname, true);
			 }
			
			 if (this.containsEdge(rp.vname, v2name)==true){
				 return true;
			 }
			 
			 System.out.println(rp.vname + " via " + rp.psf);
			 ArrayList<String>rpnbrnames=new ArrayList<>(rp.vtx.nbrs.keySet());
			 
			 for(String rpnbrname: rpnbrnames){
				 
				
				 if(!processed.containsKey(rpnbrname)){
			            Vertex nv= vces.get(rpnbrname);
			            Pair np=new Pair(rpnbrname, nv, rp.psf+rpnbrname);
			            queue.addLast(np);
			 }
			 }
			 
		 }
		 

	return false;
}
	
	public boolean dfs(String v1name,String v2name){
		 LinkedList<Pair> Stack=new LinkedList<>();
		 HashMap<String, Boolean> processed=new HashMap<>();
		 
		 Vertex vtx=vces.get(v1name);
		 Pair pair=new Pair(v2name, vtx, v2name);
		 
		 Stack.addFirst(pair);
		
		 while (Stack.size()!=0){
			
			 Pair rp=Stack.removeFirst();
			
			 if (!processed.containsKey(rp.vname)){
				processed.put(rp.vname, true);
			 }
			
			 if (this.containsEdge(rp.vname, v2name)==true){
				 return true;
			 }
			 
			 ArrayList<String>rpnbrnames=new ArrayList<>(rp.vtx.nbrs.keySet());
			 
			 for(String rpnbrname: rpnbrnames){
				
				 if(!processed.containsKey(rpnbrname)){
			            Vertex nv= vces.get(rpnbrname);
			            Pair np=new Pair(rpnbrname, nv, rp.psf+rpnbrname);
			            Stack.addFirst(np);
			 }
			 }
			 
		 }
		 return false;
}
}

	
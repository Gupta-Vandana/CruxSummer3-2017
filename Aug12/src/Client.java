
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		g.addEdge("A", "B", 10);
		g.addEdge("A", "D", 40);
		g.addEdge("B", "C", 10);
		g.addEdge("D", "E", 2);
		g.addEdge("D", "C", 10);
		g.addEdge("E", "F", 3);
		g.addEdge("E", "G", 8);
		g.addEdge("F", "G", 3);

		g.display();
		//g.hasPath("A", "G");
		//g.removeEdge("D", "E");
		//g.hasPath("A", "B");
		//System.out.println(g.bfs("A", "G"));
		//System.out.println(g.dfs("A","G"));
		
	}

}

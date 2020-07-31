package q1;

public class BellmanFordAlgo {
	public static class Edge{
		public int src, dest, weight;
	}
	
	public static class Graph{
		public int V, E;
		public Edge[] edges;
	}
	
	public Graph createGraph(int V, int E) {
		Graph graph = new Graph();
		graph.V = V;
		graph.E = E;
		graph.edges = new Edge[E];
		for(int i = 0; i < E; i++)
			graph.edges[i] = new Edge();
		

		return graph;
	}
	
	public void BellmanFord(Graph graph, int src) {
		int V = graph.V;
		int E = graph.E;
		int[] dist = new int[V];
		
		// Step 1 : Initialize distances from src to all others vertices as INFINITY 
		for(int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;
		
		
		// Step 2 : Relax all edges = [V] - 1
		for(int i = 0; i <= V - 1; i++) {
			for(int j = 0; j < E; j++) {
				int u = graph.edges[j].src;
				int v = graph.edges[j].dest;				
				int wgt = graph.edges[j].weight;
				if(dist[u] != Integer.MAX_VALUE &&
					dist[u] + wgt < dist[v])
						dist[v] = dist[u] + wgt;
			}
			
		}
		
		
		// Step 3: check for negative cycle.
		for(int j = 0; j < E; j++) {
			int u = graph.edges[j].src;
			int v = graph.edges[j].dest;				
			int wgt = graph.edges[j].weight;
		    if (dist[u] != Integer.MAX_VALUE && dist[u] + wgt < dist[v])
		    	System.out.println("Graph contains negative cycle.");
		}		
	
		
		printGraph(dist, V);	
}
	
	
private void printGraph(int dist[], int V) {
	System.out.println("Vertices| Distance");
	System.out.println("-------------------");
	for(int i = 0; i < V; i++)
		System.out.println(i+"\t|\t"+dist[i]);
	System.out.println("-------------------");	
	
}	
	
	
	
	

}

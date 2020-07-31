package driver;

import q1.BellmanFordAlgo;
import q1.BellmanFordAlgo.Graph;
import q2.FordFulkersonAlgo;

public class DriverClass {
	public static void main(String[] args) {
		
		
		System.out.println("###################################");
		System.out.println("------------Question 1------------\n");
		
		
			BellmanFordAlgo bf = new BellmanFordAlgo();
		    int V = 5;  
		    int E = 8;  
		    Graph graph = bf.createGraph(V, E);
		    
		    
		    graph.edges[0].src = 0;
			graph.edges[0].dest = 1;
		    graph.edges[0].weight = -1;
		 
		    graph.edges[1].src = 0;
		    graph.edges[1].dest = 2;
		    graph.edges[1].weight = 4;
		 
		    graph.edges[2].src = 1;
		    graph.edges[2].dest = 2;
		    graph.edges[2].weight = 3;
		 
		    graph.edges[3].src = 1;
		    graph.edges[3].dest = 3;
		    graph.edges[3].weight = 2;
		 
		    graph.edges[4].src = 1;
		    graph.edges[4].dest = 4;
		    graph.edges[4].weight = 2;
		 
		    graph.edges[5].src = 3;
		    graph.edges[5].dest = 2;
		    graph.edges[5].weight = 5;
		 
		    graph.edges[6].src = 3;
		    graph.edges[6].dest = 1;
		    graph.edges[6].weight = 1;
		 
		    graph.edges[7].src = 4;
		    graph.edges[7].dest = 3;
		    graph.edges[7].weight = -3;
		 
		    bf.BellmanFord(graph, 0);
		    

			System.out.println("\n###################################");
			System.out.println("------------Question 2------------\n");
			
			
			// Let us create a graph shown in the above example 
			int graph1[][] =new int[][] {{0, 0, 6, 0, 0, 0}, 
										{10, 0, 2, 0, 2, 0}, 
										{4, 0, 0, 0, 5, 0}, 
										{0, 4, 0, 0, 0, 6}, 
										{0, 6, 4, 6, 0, 0}, 
										{0, 0, 0, 4, 10, 0} 
									}; 
	       FordFulkersonAlgo m = new FordFulkersonAlgo(); 

			System.out.println("Maximum flow for the Q2 Graph is : " + 
							m.fordFulkerson(graph1, 0, 5)); 
			
			
			
			
		    
		    
		    
	}
}

package driver;

import java.util.ArrayList;

import dijkstra.DijkstraAlgo;
import kruskals.KruskalsGraph;
import prims.PrimsGraph;
import prims.PrimsGraph.EDGE;

public class DriverClass {

	public static void main(String[] args) {
		System.out.println("\nNote: Assuming the vertices are starting from 0, instead of 1.\n\n");
		
		
		System.out.println("#########################################");
		System.out.println("----------------Question 1---------------");
		
		
		// a
		System.out.println("a) Kruskal's : ");	
        int V = 7;  // Number of vertices in graph 
        int E = 9;  // Number of edges in graph 
        KruskalsGraph graph = new KruskalsGraph(V, E); 
  
        // add edge 0-1 
        graph.edge[0].src = 5; 
        graph.edge[0].dest = 6; 
        graph.edge[0].weight = 1; 
  
        // add edge 0-2 
        graph.edge[1].src = 4; 
        graph.edge[1].dest = 6; 
        graph.edge[1].weight = 2; 
  
        // add edge 0-3 
        graph.edge[2].src = 4; 
        graph.edge[2].dest = 5; 
        graph.edge[2].weight = 2; 
  
        // add edge 1-3 
        graph.edge[3].src = 3; 
        graph.edge[3].dest = 6; 
        graph.edge[3].weight = 2; 
  
        // add edge 2-3 
        graph.edge[4].src = 0; 
        graph.edge[4].dest = 3; 
        graph.edge[4].weight = 3; 
  
        // add edge 2-3 
        graph.edge[5].src = 2; 
        graph.edge[5].dest = 6; 
        graph.edge[5].weight = 4; 
  
        
        // add edge 2-3 
        graph.edge[6].src = 1; 
        graph.edge[6].dest = 3; 
        graph.edge[6].weight = 4; 
  
        
        // add edge 2-3 
        graph.edge[7].src = 1; 
        graph.edge[7].dest = 2; 
        graph.edge[7].weight = 5; 
  
        
        // add edge 2-3 
        graph.edge[8].src = 3; 
        graph.edge[8].dest = 5; 
        graph.edge[8].weight = 5; 
  
        graph.KruskalMST(); 
		
		// b
        
        
   	   System.out.println("b) Prim's : ");	
       EDGE[] edges = new EDGE[9];
        
        edges[0] = new EDGE(6, 7, 1);
        edges[1] = new EDGE(5, 7, 2);
        edges[2] = new EDGE(5, 6, 2);
        edges[3] = new EDGE(4, 7, 2);
        
        edges[4] = new EDGE(1, 4, 3);
        edges[5] = new EDGE(3, 7, 4);
        edges[6] = new EDGE(2, 4, 4);
        edges[7] = new EDGE(2, 3, 5);
        
        edges[8] = new EDGE(4, 6, 5);
    
        
        PrimsGraph pg = new PrimsGraph();
        
        ArrayList<ArrayList<EDGE>> graph2 = pg.createGraph(edges);
        ArrayList<EDGE> mst = pg.prims(graph2);
        System.out.println("\n\nMST: ");
        for(EDGE e:mst){
            System.out.println(e.from+" - "+e.to+" : "+e.weight);
        }  
        
        
		System.out.println("#########################################");
		System.out.println("----------------Question 3---------------");
		
		// a
		System.out.println("a) Kruskal's : ");	
        int V1 = 6;  // Number of vertices in graph 
        int E2 = 10;  // Number of edges in graph 
        KruskalsGraph q3 = new KruskalsGraph(V1, E2); 
  
        // add edge 0-1 
        q3.edge[0].src = 2; 
        q3.edge[0].dest = 4; 
        q3.edge[0].weight = 21; 
  
        // add edge 0-2 
        q3.edge[1].src = 5; 
        q3.edge[1].dest = 3; 
        q3.edge[1].weight = 32; 
  
        // add edge 0-3 
        q3.edge[2].src = 5; 
        q3.edge[2].dest = 4; 
        q3.edge[2].weight = 37; 
  
        // add edge 1-3 
        q3.edge[3].src = 2; 
        q3.edge[3].dest = 3; 
        q3.edge[3].weight = 47; 
  
        // add edge 2-3 
        q3.edge[4].src = 0; 
        q3.edge[4].dest = 1; 
        q3.edge[4].weight = 53; 
  
        // add edge 2-3 
        q3.edge[5].src = 0; 
        q3.edge[5].dest = 5; 
        q3.edge[5].weight = 55; 
  
        
        // add edge 2-3 
        q3.edge[6].src = 3; 
        q3.edge[6].dest = 4; 
        q3.edge[6].weight = 56; 
  
        
        // add edge 2-3 
        q3.edge[7].src = 5; 
        q3.edge[7].dest = 2; 
        q3.edge[7].weight = 68; 
  
        
        // add edge 2-3 
        q3.edge[8].src = 5; 
        q3.edge[8].dest = 1; 
        q3.edge[8].weight = 70; 
  
        q3.KruskalMST(); 
		
		
		System.out.println("");
        
   	   System.out.println("b) Prim's : ");	
       EDGE[] edges2 = new EDGE[10];
        
        edges2[0] = new EDGE(3, 5, 21);
        edges2[1] = new EDGE(6, 4, 32);
        edges2[2] = new EDGE(6, 5, 37);
        edges2[3] = new EDGE(3, 4, 45);
        
        edges2[4] = new EDGE(2, 3, 47);
        edges2[5] = new EDGE(1, 2, 53);
        edges2[6] = new EDGE(1, 6, 55);
        edges2[7] = new EDGE(5, 4, 56);
        
        edges2[8] = new EDGE(6, 3, 68);
        edges2[9] = new EDGE(6, 2, 70);
    
        
        PrimsGraph pg1 = new PrimsGraph();
        
        ArrayList<ArrayList<EDGE>> graph3 = pg.createGraph(edges2);
        ArrayList<EDGE> mst1 = pg.prims(graph3);
        System.out.println("\nMST: ");
        for(EDGE e:mst1){
            System.out.println(e.from+" - "+e.to+" : "+e.weight);
        }  
        
        
    
		
		
		
		
		
		
		
		
		System.out.println("#########################################");
		System.out.println("----------------Question 4---------------");
	      int graph4[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
              { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
              { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
              { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
              { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
              { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
              { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
              { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
              { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
              DijkstraAlgo t = new DijkstraAlgo(); 
              t.V = 9;
              t.dijkstra(graph4, 0); 
	

		System.out.println("#########################################");
		System.out.println("----------------Question 5---------------");
		
		System.out.println("\n\nc) Dijkratas : ");	

		   int graph5[][] = new int[][] {{ 0, 5, 3, 0, 0, 0, 0 }, 
         { 5, 0, 4, 6, 2, 0, 0 }, 
         { 3, 4, 0, 5, 0, 11, 0 }, 
         { 0, 6, 5, 0, 7, 9, 0 }, 
         { 0, 2, 0, 7, 0, 12, 8 }, 
         { 0, 0, 11, 9, 12, 0, 7 }, 
         { 0, 0, 0, 0, 8, 7, 0 }};
         
         DijkstraAlgo t1 = new DijkstraAlgo(); 
         t1.V = 7;
         t1.dijkstra(graph5, 0); 	
		
		
     
 	   System.out.println("\nb) Prim's : ");	
       EDGE[] edges6 = new EDGE[12];
        
        edges6[0] = new EDGE(1, 2, 5);
        edges6[1] = new EDGE(1, 3, 3);
        edges6[2] = new EDGE(2, 5, 2);
        edges6[3] = new EDGE(2, 4, 6);
        
        edges6[4] = new EDGE(2, 3, 4);
        edges6[5] = new EDGE(4, 3, 5);
        edges6[6] = new EDGE(4, 6, 9);
        edges6[7] = new EDGE(3, 6, 11);
        
        edges6[8] = new EDGE(4, 5, 7);
        edges6[9] = new EDGE(5, 7, 8);
        edges6[10] = new EDGE(6, 5, 12);
        edges6[11] = new EDGE(6, 7, 7);
    
        
        
        PrimsGraph pg2 = new PrimsGraph();
        
        ArrayList<ArrayList<EDGE>> graph7 = pg2.createGraph(edges6);
        ArrayList<EDGE> mst2 = pg.prims(graph7);
        System.out.println("\nMST: ");
        for(EDGE e:mst2){
            System.out.println(e.from+" - "+e.to+" : "+e.weight);
        }  
         

	}

}

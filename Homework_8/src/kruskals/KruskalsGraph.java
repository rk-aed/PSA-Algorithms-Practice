package kruskals;

import java.util.Arrays;

public class KruskalsGraph {
	
	int V, E;     
	public Edge edge[]; 
  
    public KruskalsGraph(int v, int e) 
    { 
        V = v; 
        E = e; 
        edge = new Edge[E]; 
        for (int i=0; i<e; ++i) 
            edge[i] = new Edge(); 
    } 
  
	public class Edge implements Comparable<Edge> 
    
    { 
        public int src, dest, weight; 
        public int compareTo(Edge compareEdge) 
        { 
            return this.weight-compareEdge.weight; 
        } 
        @Override
        public String toString() { 
            return "Source : "+this.src+" Dest. : " + this.dest +" Weight :  "+this.weight; 
        }  
        
        
    } 
  
    
    
    
    // Disjoint Data Structure
    class subset 
    { 
        int parent, rank; 
    }; 
  
    int find(subset subsets[], int i) 
    { 
        if (subsets[i].parent != i) 
            subsets[i].parent = find(subsets, subsets[i].parent); 
  
        return subsets[i].parent; 
    } 

    void Union(subset subsets[], int x, int y) 
    { 
        int xroot = find(subsets, x); 
        int yroot = find(subsets, y); 
  
        if (subsets[xroot].rank < subsets[yroot].rank) 
            subsets[xroot].parent = yroot; 
        else if (subsets[xroot].rank > subsets[yroot].rank) 
            subsets[yroot].parent = xroot; 
  
        else
        { 
            subsets[yroot].parent = xroot; 
            subsets[xroot].rank++; 
        } 
    } 
    
    public void printSS(subset[] ss) {
    	
    	int i = 0;
    	for(subset s : ss)
    		System.out.println(++i +" Parent : " +(s.parent+1)+" rank : "+(s.rank));
    	
    	
    	
    
    	
    }
    
    // Method for MST finding using Kruskal's
  
    public void KruskalMST() 
    { 
        Edge result[] = new Edge[V];   
        int e = 0;   
        int i = 0;  
        for (i=0; i<V; ++i) 
            result[i] = new Edge(); 
  
        Arrays.sort(edge); 
  
        subset subsets[] = new subset[V]; 
        for(i=0; i<V; ++i) 
            subsets[i]=new subset(); 
  
        for (int v = 0; v < V; ++v) 
        { 
            subsets[v].parent = v; 
            subsets[v].rank = 0; 
        } 
        // printSS(subsets);
        
        i = 0; 
        while (e < V - 1) 
        { 
            Edge next_edge = new Edge(); 
            next_edge = edge[i++]; 
         //   System.out.println(next_edge);
            int x = find(subsets, next_edge.src); 
            int y = find(subsets, next_edge.dest); 
  
            if (x != y) 
            {   result[e++] = next_edge; 
                Union(subsets, x, y); 
            } 
       /*     System.out.println("###### Start ######");
            printSS(subsets);
            System.out.println("##### End #######");
       */   
        } 
  
        System.out.println("Kruskal's MST"); 
        for (i = 0; i < e; ++i) 
            System.out.println("Source: "+result[i].src+" -- Dest. : " +  
                   result[i].dest+" == Weight ( " + result[i].weight+" ) "); 
    } 
	
	

}

package prims;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PrimsGraph {

	
	
	// Define Edge Class
    public static class EDGE{
       public int from, to;
       public double weight;
        
      public EDGE(int f, int t, double w){
            from = f;
            to = t;
            weight = w;
        }
    }

    
    // Create Graph Method
    public ArrayList<ArrayList<EDGE>> createGraph(EDGE[] edges){
        ArrayList<ArrayList<EDGE>> G = new ArrayList<>();
        int length = edges.length*2;
        for(int i=0;i<length;++i){
            G.add(new ArrayList<>());
        }
        
        for(EDGE e:edges){
            EDGE other = new EDGE(e.to, e.from, e.weight);
            G.get(e.from).add(e);
            G.get(e.to).add(other);
        }
        
        return G; 
    }
	
    // Prim's Algo
    public static ArrayList<EDGE> prims(ArrayList<ArrayList<EDGE>> G){
        ArrayList<EDGE> mst = new ArrayList<>();
        PriorityQueue<EDGE> pq = new PriorityQueue<>((Object o1, Object o2) -> {
            EDGE first = (EDGE)o1;
            EDGE second = (EDGE)o2;
            
            if(first.weight < second.weight)return -1;
            else if(first.weight > second.weight)return 1;
            else return 0;
        });
        
        for(EDGE e:G.get(1)){
            pq.add(e);
        } 
        
        boolean[] marked = new boolean[G.size()];
        marked[0] = true;
        while(!pq.isEmpty()){
        	EDGE e = pq.peek();
            pq.poll();
            if(marked[e.from] && marked[e.to])continue;
            marked[e.from] = true;  
            for(EDGE edge:G.get(e.to)){
                if(!marked[edge.to]){
                    pq.add(edge);  
                }
            }
            marked[e.to] = true; 
            mst.add(e);
            
        }
        return mst;
    }
    
	

}

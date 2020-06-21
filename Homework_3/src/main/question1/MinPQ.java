package main.question1;

public class MinPQ {
	   private Comparable[] pQueue;
	    private int index;
	     
	    public MinPQ(int capacity){
	        pQueue = new Comparable[capacity];
	    }
	     
	    public void insert(Comparable item ){
	        if(index == pQueue.length){
	            System.out.println("The priority queue is filled completely");
	            return;
	        }
	        pQueue[index] = item;
	        index++;
	        System.out.println("Adding element: "+item);
	    }
	     
	    public Comparable remove(){
	        if(index == 0){
	            System.out.println("The priority queue is empty.");
	            return null;
	        }
	        int minIndex = 0;
	        for (int i=1; i<index; i++) { 
	            if (pQueue[i].compareTo (pQueue[minIndex]) <  0) { 
	                minIndex = i; 
	            } 
	        } 
	        Comparable result = pQueue[minIndex]; 
	        System.out.println("removing: "+result);
	        index--; 
	        pQueue[minIndex] = pQueue[index]; 
	        return result;
	    }
}

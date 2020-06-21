package main.question1;


public class MaxPQ {
	
    private Comparable[] pQueue;
    private int index;
     
    public MaxPQ(int capacity){
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
        int maxIndex = 0;
        for (int i=1; i<index; i++) { 
            if (pQueue[i].compareTo (pQueue[maxIndex]) > 0) { 
                maxIndex = i; 
            } 
        } 
        Comparable result = pQueue[maxIndex]; 
        System.out.println("removing: "+result);
        index--; 
        pQueue[maxIndex] = pQueue[index]; 
        return result;
    }
	
	
	
	

}

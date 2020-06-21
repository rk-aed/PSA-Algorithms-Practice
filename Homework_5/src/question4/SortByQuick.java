package question4;

import java.util.ArrayList;

public class SortByQuick {
    public int partition(ArrayList<Double> a, int left, int right) {
       
    	// Pivot on first
    	Double pivot = a.get(left); //[left];
        while(left<=right) {
            while(a.get(left) < pivot)
                left++;
            while(a.get(right)> pivot)
                right--;
            if(left<=right) {
                Double leftN = a.get(left);
                Double rightN = a.get(right);
                
                a.add(left, rightN);
                a.add(right, leftN);
                
                left++;
                right--;
            }
        }
        return left;
    }
    public void recursiveQuickSort(ArrayList<Double> a, int i, int j) {
       int idx = partition(a, i, j);
       if(i < idx-1) {
           recursiveQuickSort(a, i, idx-1);
        }
       if(j > idx) {
           recursiveQuickSort(a, idx, j);
        }
    }

    void printarray(int arr[]){
        int len = arr.length;
        for(int i=0; i<len; i++)
            System.out.print(arr[i]+" ");
    }
	
	
	

}

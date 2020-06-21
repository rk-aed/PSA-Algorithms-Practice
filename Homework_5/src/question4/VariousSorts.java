package question4;

import java.util.ArrayList;

public class VariousSorts {
	/*
	 * Homekeeping stuff
	 * 
	 * */
	
	
	private void swap(Integer[] arr, int i,int j) {
		int temp = arr[i];
		arr[i]  = arr[j];
		arr[j]   = temp;		
	}		
	
	
	private void swap1(ArrayList<Double> arr, int i,int j) {
		Double ith = arr.get(i);
		Double jth = arr.get(j);
		arr.set(i, jth);
		arr.set(j, ith);		
	}		
	
	
	public void printAll(int[] arr) {
		for(int a : arr)
			System.out.print(" "+a);
		System.out.println("");
	}

	public void printAll(ArrayList<Double> arr) {
		for(Double a : arr)
			System.out.print(" "+a);
		System.out.println("");
	}
	
	
	
	/*
	 * Bubble Sort. Descending
	 * 
	 * */
	
	public void sortByBubble(ArrayList<Double> arr) {
		for(int i = 0; i < arr.size(); i++) {
			for(int j = i + 1; j < arr.size() ; j++) {				
				if(arr.get(i) < arr.get(j)) swap1(arr, i, j);	
			}
		}
	}
	
	
	

	/*
	 * Selection Sort. Descending
	 * 
	 * */
	
	public void sortBySelection(ArrayList<Double> arr) {
		for(int i = 0; i < arr.size(); i++) {
			int maxNum = i;
			
			for(int j = i+1; j < arr.size(); j++) 
				if(arr.get(maxNum) < arr.get(j)) 
					maxNum = j;
			
			if(maxNum != i) swap1(arr, i, maxNum);
			
		}
	}
	
	
	

	/*
	 * Insertion Sort
	 * 
	 * 
	public void sortByInsert(ArrayList<Double> arr) {
		
		
		for(int i = 0; i < arr.size(); i++) {
		System.out.println("Insertion "+i);	
			// Pick Number
			Double pick = arr.get(i);
			
			
			// Traverse till you find the correct position of the number
			int j = i;			
			while(j > 0 && pick < arr.get(j-1)) {
				System.out.println(" Insertion "+j);
				swap1(arr, j, (j-1));
				j--;
			}
			
			
			// Put the number in that position
			arr.add(j, pick);
			
		}
	}
	*/
	
	// Descending
	
    public static void insertionSort(ArrayList<Double> arr) {
        for (int i = 1; i < arr.size(); i++) {
        	Double valueToSort = arr.get(i);  // [i];
            int j = i;
            while (j > 0 && arr.get(j-1)  < valueToSort) {
       
                arr.add(j,arr.get(j-1));
                j--;
            }
            arr.add(j,valueToSort);
            

        }
    }
	
	

}

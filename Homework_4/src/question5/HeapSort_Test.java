package question5;

public class HeapSort_Test {
	// min heap sort Check difference
    // main function to do heap sort 
    public void heapSortMin(int arr[], int n) 
    { 
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
        	heapifyMin(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i = n - 1; i >= 0; i--) { 
              
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapifyMin(arr, i, 0); 
        } 
    } 
	// end
	   public void sort(int arr[]) 
	    { 
	        int n = arr.length; 
	  
	        for (int i = n / 2 - 1; i >= 0; i--) 
	            heapify(arr, n, i); 
	  

	        for (int i=n-1; i>0; i--) 
	        { 
	            // Move current root to end 
	            int temp = arr[0]; 
	            arr[0] = arr[i]; 
	            arr[i] = temp; 
	  

	            heapify(arr, i, 0); 
	        } 
	    } 
	   
	   
	    public void heapify(int arr[], int n, int i) 
	    { 
	        int largest = i; // Initialize largest as root 
	        int l = 2*i + 1; // left = 2*i + 1 
	        int r = 2*i + 2; // right = 2*i + 2 
	  
	        // If left child is larger than root 
	        if (l < n && arr[l] > arr[largest]) 
	            largest = l; 
	  
	        // If right child is larger than largest so far 
	        if (r < n && arr[r] > arr[largest]) 
	            largest = r; 
	  
	        // If largest is not root 
	        if (largest != i) 
	        { 
	            int swap = arr[i]; 
	            arr[i] = arr[largest]; 
	            arr[largest] = swap; 
	  
	            // Recursively heapify the affected sub-tree 
	            heapify(arr, n, largest); 
	        } 
	    } 
	    
	    // Decreasing order code, building min heap for the same
	    
	    
	    public void heapifyMin(int arr[], int n, int i) 
	    { 
	        int smallest = i; // Initialize smalles as root 
	        int l = 2 * i + 1; // left = 2*i + 1 
	        int r = 2 * i + 2; // right = 2*i + 2 
	  
	        // If left child is smaller than root 
	        if (l < n && arr[l] < arr[smallest]) 
	            smallest = l; 
	  
	        // If right child is smaller than smallest so far 
	        if (r < n && arr[r] < arr[smallest]) 
	            smallest = r; 
	  
	        // If smallest is not root 
	        if (smallest != i) { 
	            int temp = arr[i]; 
	            arr[i] = arr[smallest]; 
	            arr[smallest] = temp; 
	  
	            // Recursively heapify the affected sub-tree 
	            heapifyMin(arr, n, smallest); 
	        } 
	    } 
	  
	    
	    
	    
	    public void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        System.out.println(); 
	    } 
	
	
	
	
	
	
}

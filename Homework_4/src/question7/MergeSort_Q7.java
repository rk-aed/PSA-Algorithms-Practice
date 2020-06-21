package question7;

public class MergeSort_Q7 {
	  public  void mergeSort(String[] a, int from, int to) {
		  System.out.println("Sort Left : "+from+", Right : "+to);
	        if (from == to) {
	        	System.out.println("pop");
	            return;
	        }
	        int mid = (from + to) / 2;
	        // sort the first and the second half
	        System.out.println("Sort first half Left : "+from+", mid : "+mid);
		    mergeSort(a, from, mid);
		    System.out.println("Sort Second half mid+1 : "+mid+", right : "+to);
		    mergeSort(a, mid + 1, to);
	        

		    merge(a, from, mid, to);
		    
		    System.out.println("Sort ended pop");
	    }// end mergeSort
	//work

	    public static void merge(String[] a, int from, int mid, int to) {
	    	
	    	System.out.println("Merge left : "+from+", mid : "+mid+", to : "+to);
	        int n = to - from + 1;       // size of the range to be merged
	        String[] b = new String[n];   // merge both halves into a temporary array b
	        int i1 = from;               // next element to consider in the first range
	        int i2 = mid + 1;            // next element to consider in the second range
	        int j = 0;                   // next open position in b

	        // as long as neither i1 nor i2 past the end, move the smaller into b
	        while (i1 <= mid && i2 <= to) {
	            if (a[i1].compareTo(a[i2]) < 0) {
	                b[j] = a[i1];
	                i1++;
	            } else {
	                b[j] = a[i2];
	                i2++;
	            }
	            j++;
	        }

	        // note that only one of the two while loops below is executed
	        // copy any remaining entries of the first half
	        while (i1 <= mid) {
	            b[j] = a[i1];
	            i1++;
	            j++;
	        }

	        // copy any remaining entries of the second half
	        while (i2 <= to) {
	            b[j] = a[i2];
	            i2++;
	            j++;
	        }

	        // copy back from the temporary array
	        for (j = 0; j < n; j++) {
	            a[from + j] = b[j];
	        }
	        
	        System.out.println("Merge Pop");
	    }//end merge
	
	
	
	
	

}

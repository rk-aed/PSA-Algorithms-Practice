package question4;

import java.util.ArrayList;

public class SortByTimSort64  
{ 
  
     static int RUN = 64; 
  
    // this function sorts array from left index to  
    // to right index which is of size atmost RUN  
    public static void insertionSort(ArrayList<Double> arr, int left, int right)  
    { 
    	
//    	System.out.println("Before IS : left : "+left+" : right : "+right);
   
        
        for (int i = left + 1; i <= right; i++)  
        { 

            Double temp = arr.get(i); 
            int j = i - 1; 
            while (j >= left && arr.get(j) < temp) 
            { 
//                arr[j + 1] = arr[j]; 
                arr.add(j+1, arr.get(j));
                j--; 
            } 
            arr.add(j+1, temp);
            

        }

             
    } 
  
    // merge function merges the sorted runs  
    public static void merge(ArrayList<Double> arr, int l,  
                                int m, int r) 
    { 
 
        // original array is broken in two parts  
        // left and right array  
        int len1 = m - l + 1, len2 = r - m; 
        Double[] left = new Double[len1]; 
        Double[] right = new Double[len2]; 
        for (int x = 0; x < len1; x++)  
        { 
            left[x] = arr.get(l+x);//[l + x]; 
        } 
        for (int x = 0; x < len2; x++)  
        { 
            right[x] = arr.get(m + 1 + x); //arr[m + 1 + x]; 
        } 
  
        int i = 0; 
        int j = 0; 
        int k = l; 
  
        // after comparing, we merge those two array  
        // in larger sub array  
        while (i < len1 && j < len2)  
        { 
            if (left[i] <= right[j])  
            { 
                arr.add(k, left[i]); // [k] = left[i]; 
                i++; 
            } 
            else 
            { 
                arr.add(k, right[j]);
//            	arr[k] = right[j]; 
                j++; 
            } 
            k++; 
        } 
  
        // copy remaining elements of left, if any  
        while (i < len1) 
        { 
            arr.add(k, left[i]);
       // 	arr[k] = left[i]; 
            k++; 
            i++; 
        } 
  
        // copy remaining element of right, if any  
        while (j < len2)  
        { 
            arr.add(k, right[j]);
//            arr[k] = right[j]; 
            k++; 
            j++; 
        } 
        
        

    } 
  
    // iterative Timsort function to sort the  
    // array[0...n-1] (similar to merge sort)  
    public static void timSort(ArrayList<Double> arr, int n)  
    { 

        // Sort individual subarrays of size RUN  
        for (int i = 0; i < n; i += RUN)  
        { 
            insertionSort(arr, i, Math.min((i + 31), (n - 1))); 
        } 
  
        // start merging from size RUN (or 32). It will merge  
        // to form size 64, then 128, 256 and so on ....  
        for (int size = RUN; size < n; size = 2 * size)  
        { 
              
        	

            // pick starting point of left sub array. We  
            // are going to merge arr[left..left+size-1]  
            // and arr[left+size, left+2*size-1]  
            // After every merge, we increase left by 2*size  
            for (int left = 0; left < n; left += 2 * size)  
            { 
                  
                // find ending point of left sub array  
                // mid+1 is starting point of right sub array  
                int mid = left + size - 1; 
                int right = Math.min((left + 2 * size - 1), (n - 1)); 
  
                // merge sub array arr[left.....mid] &  
                // arr[mid+1....right]  
                merge(arr, left, mid, right); 
            } 
        } 
    } 
  
    // utility function to print the Array  
    public static void printArray(ArrayList<Double> arr) 
    { 
        for (int i = 0; i < arr.size(); i++) 
        { 
            System.out.print(arr.get(i) + " "); 
        } 
        System.out.print("\n"); 
    } 
  

} 
  
package question4;

import java.util.ArrayList;

public class SortByTimSort  
{ 
  
     static int RUN = 32; 
  
    public static void insertionSort(ArrayList<Double> arr, int left, int right)  
    {        
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
  
    public static void merge(ArrayList<Double> arr, int l,  
                                int m, int r) 
    { 
 
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
  
        while (i < len1) 
        { 
            arr.add(k, left[i]);
       // 	arr[k] = left[i]; 
            k++; 
            i++; 
        } 
  
        while (j < len2)  
        { 
            arr.add(k, right[j]);
//            arr[k] = right[j]; 
            k++; 
            j++; 
        } 
        
        

    } 
  
    public static void timSort(ArrayList<Double> arr, int n)  
    { 

        for (int i = 0; i < n; i += RUN)  
        { 
            insertionSort(arr, i, Math.min((i + 31), (n - 1))); 
        } 
  
        for (int size = RUN; size < n; size = 2 * size)  
        { 
        	for (int left = 0; left < n; left += 2 * size)  
	            { 
	                int mid = left + size - 1; 
	                int right = Math.min((left + 2 * size - 1), (n - 1)); 
	                merge(arr, left, mid, right); 
	            } 
        } 
    } 

} 
  
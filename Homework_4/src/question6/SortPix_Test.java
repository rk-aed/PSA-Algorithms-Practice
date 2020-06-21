package question6;

import java.awt.Color;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class SortPix_Test {
	   BufferedImage image;
	   int width;
	   int height;
	   
	   public SortPix_Test() {
		   
		   
	   }
	      
	   public SortPix_Test(String path) {
	      try {
	    	  
//	    	  
	         File input = new File(path);
	         image = ImageIO.read(input);
	         width = image.getWidth();
	         height = image.getHeight();
	         
	         int count = 0;
	         
	         for(int i=0; i<height; i++) {
	         
	            for(int j=0; j<width; j++) {
	            
	               count++;
	               Color c = new Color(image.getRGB(j, i));
	               System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
	            }
	         }

	      } catch (Exception e) {
	    	  
	    	  System.out.println("Error");
	    	  
	      }
	   }

	   public ArrayList<Double> getIntensityForEachPixel(String path) {
		   ArrayList<Double> intensityList = new ArrayList<Double>();
		      try {
		    	 File input = new File(path);
		         image = ImageIO.read(input);
		         width = image.getWidth();
		         height = image.getHeight();
		         
		         int count = 0;
		         
		         for(int i=0; i<height; i++) {
		         
		            for(int j=0; j<width; j++) {
		            
		               count++;
		               Color c = new Color(image.getRGB(j, i));
//		               System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
		               double r = c.getRed();
		               double g = c.getGreen();
		               double b = c.getBlue();
		               
		               double intensity  = (0.2989*r) + (0.5870*g) + (0.1140*b);
		               intensityList.add(intensity);
		               
		               
		            
		            }
		         }

		      } catch (Exception e) {
		    	  
		    	  System.out.println("Error");
		    	  
		      }
		      
		      return intensityList;
		
	   }
	   
	   public void sortByMerge(ArrayList<Double> arr, int l, int r) {
		   
	        if (l < r) 
	        { 
	            // Find the middle point 
	            int m = (l+r)/2; 
	  
	            // Sort first and second halves 
	            sortByMerge(arr, l, m); 
	            sortByMerge(arr , m+1, r); 
	  
	            // Merge the sorted halves 
	            merge(arr, l, m, r); 
	        } 
		   
		   
	   }
	   
	   

	    static void merge(ArrayList<Double> arr, int l, int m, int r) 
	    { 
	        // Find sizes of two subarrays to be merged 
	        int n1 = m - l + 1; 
	        int n2 = r - m; 
	  
	        /* Create temp arrays */
	        double L[] = new double [n1]; 
	        double R[] = new double [n2]; 
	  
	        /*Copy data to temp arrays*/
	        for (int i=0; i<n1; ++i) 
	            L[i] = arr.get(l + i); 
	        for (int j=0; j<n2; ++j) 
	            R[j] = arr.get(m + 1+ j); 
	  
	  
	        /* Merge the temp arrays */
	  
	        // Initial indexes of first and second subarrays 
	        int i = 0, j = 0; 
	  
	        // Initial index of merged subarry array 
	        int k = l; 
	        while (i < n1 && j < n2) 
	        { 
	            if (L[i] <= R[j]) 
	            { 
	                arr.set(k, L[i]);
	                i++; 
	            } 
	            else
	            { 
	                arr.set(k, R[j]);
	                j++; 
	            } 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of L[] if any */
	        while (i < n1) 
	        { 
                arr.set(k, L[i]);

	            i++; 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of R[] if any */
	        while (j < n2) 
	        { 
	            arr.set(k, R[j]);
		        j++; 
	            k++; 
	        } 
	    } 
	  
	   
	   public void sortByHeap(ArrayList<Double> intensity) {
		   heapSort(intensity);		   
	   }

	   
	   public void heapSort(ArrayList<Double> arr) 
	    { 
	        int n = arr.size(); 
	  
	        // Build heap (rearrange array) 
	        for (int i = n / 2 - 1; i >= 0; i--) {
	            heapify(arr, n, i); }
	    //    System.out.println("after for loop");
	        // One by one extract an element from heap 
	        for (int i=n-1; i>0; i--) 
	        { 
	            // Move current root to end 
	            Double temp = arr.get(0); //[0];
	            
	            arr.set(0, arr.get(i));
	            //arr[0] = arr[i]; 

	            arr.set(i, temp);
	            // arr[i] = temp; 
	  
	            // call max heapify on the reduced heap 
	            heapify(arr, i, 0); 
	        } 
	    } 
	  
	    // To heapify a subtree rooted with node i which is 
	    // an index in arr[]. n is size of heap 
	    void heapify(ArrayList<Double> arr, int n, int i) 
	    { 
	    	int largest = i; // Initialize largest as root 
	        int l = 2*i + 1; // left = 2*i + 1 
	        int r = 2*i + 2; // right = 2*i + 2 
	  
	        // If left child is larger than root 
	        if (l < n && arr.get(l) > arr.get(largest) ) 
	            largest = l; 
	  
	        // If right child is larger than largest so far 
	        if (r < n && arr.get(r) > arr.get(largest)) 
	            largest = r; 
	  
	        // If largest is not root 
	        if (largest != i) 
	        { 

	        	Double swap = arr.get(i);
	        	//	            int swap = arr[i]; 
	            
	        	arr.set(i, arr.get(largest));
	        	//arr[i] = arr[largest]; 

	        	//arr[largest] = swap; 
	        	arr.set(largest, swap);
	        	
	            // Recursively heapify the affected sub-tree 
	            heapify(arr, n, largest); 
	        } 
	    } 
	  	  
	   
	   
	   

}

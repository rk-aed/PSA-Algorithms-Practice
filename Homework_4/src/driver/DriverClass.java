package driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import question1.Factorial_Test;
import question1.Fibo_Test;
import question1.Hanoi_Test;
import question5.HeapSort_Test;
import question2.NGray_Test;
import question3.CountBin;
import question4.MergeSort_Test;
import question6.SortPix_Test;
import question7.MergeSort_Q7;

public class DriverClass {
	
	
	public static void main(String args[]) {
		
		
		System.out.println("################## 1st Question ##############");
		
		/* 
		 * Question 1st Question
		*/		
		
		/* 
		 * A) Factorial 
		 * 
		 * 
		*/
		
		System.out.println("########## Factorial ##################");
		
	
		
		
		Factorial_Test ft = new Factorial_Test();
		long start = System.nanoTime();
		System.out.println("Factorial of 5 : "+ft.fact(5));
		long end = System.nanoTime();
		System.out.println("\n\nTime taken by Factorial Method (Nano Time) : " + (end-start));
		
		
		System.out.println("-----------------------------------");
		/* 
		 * B) Fibonnaci Series 
		 * 
		 * 
		*/
		
		
		System.out.println("########## Fibonnaci Series ##################");		
		
		Fibo_Test fibT = new Fibo_Test();
		System.out.println("Fibo Sequence (Using Recursion) : ");
		for(int i = 0; i < 5; i++){
			System.out.print(fibT.fibonacciRecursion(i) +" ");
		}
		System.out.println();
		
		System.out.println("Fibo sequence  (Using Iterative) : "); fibT.fiboUsingIterative(5);
		System.out.println();
		
		
		
		
		System.out.println("-----------------------------------");
		/* 
		 * C) Tower of Hanoi 
		 * 
		 * 
		*/
		System.out.println("########## Tower of Hanoi ##################");
		
		Hanoi_Test hanoiT = new Hanoi_Test();
		
		
		System.out.println("Hanoi Operation to shift 7 discs is as follows : ");
	    hanoiT.moves(7, true);
        
        /* ---------------------------------------------------------------
         * ----For step by step recursion uncomment below line and run----
         * ------------------------------------------------------------- */		
	    
//	  System.out.println("############Stack recursion step-by-step################");  hanoiT.towerOfHanoi(7, 'c', 'r','l'); System.out.println("-----------------------------------"); System.out.println("-----------------------------------");		
	
	    /* 
		 * Question 2nd n-bit Gray code
		*/		
		
		
		System.out.println("################## 2nd Question ##############");
		NGray_Test ng = new NGray_Test();
		System.out.println("n-bit Gray Code for n = 4, result : ");
		ng.generateGrayarr(4);
		System.out.println();
		
		
		
		/* 
		 * Question 3rd countBinary
		*/		
		
		
		System.out.println("################## 3rd Question ##############");
		CountBin cb = new CountBin();
		
		System.out.println("Count Binary with parameter 4  :  "+cb.countStrings(4));
		
		System.out.println(" ");
		
		
		
		
		/* 
		 * Question 4th Test Merge Sort
		*/
		System.out.println("################## 4th Question ##############");
				
		int[] sample = {11, 27, 43, 38, 3, 9, 82, 10, 21, 8, 34, 19, 6};

		MergeSort_Test ms = new MergeSort_Test();
        System.out.println("Input to MergeSort method: Array"); 
        ms.printArray(sample); 
        System.out.println();
        ms.sort(sample, 0, sample.length-1); 

        System.out.println("After MergeSort Call, array is"); 
        ms.printArray(sample); 
		
		System.out.println();
		
		
		/* 
		 * Question 5th Test Heap Sort
		*/
		System.out.println("################## 5th Question ##############");
				
		int[] arr = {11, 27, 43, 38, 3, 9, 82, 10, 21, 8, 34, 19, 6};
		int[] arr1 = {11, 27, 43, 38, 3, 9, 82, 10, 21, 8, 34, 19, 6};

		question5.HeapSort_Test hs = new question5.HeapSort_Test();
		System.out.println("Input to Heap Sort : ");
		hs.printArray(arr);
		
		System.out.println();
        hs.sort(arr); 
        
        System.out.println("After Heapsort (Increasing order, Max Heap), array is"); 
        hs.printArray(arr); 
		
		System.out.println();

		hs.heapSortMin(arr1, arr1.length);
		System.out.println("After Heapsort (Decreasing order, Min Heap), array is"); 
        hs.printArray(arr1); 
		
        
        System.out.println();
        System.out.println();		
		
		
		// Question 6th Test :
		
		/*
		*  Give Image Path
		* For windows machine, copy paste below. For Linux, Mac no need to run the path.replace line.
		*/
		
		String path = "C:\\Users\\rohit\\OneDrive\\Desktop\\Boston.jpeg";
		path = path.replace("\\", "/");
//		String path = "C:/Users/rohit/OneDrive/Desktop/Boston.jpeg";
		SortPix_Test sp = new SortPix_Test();
		
		// First we get the intensity of each pixel in two ArrayLists.
		ArrayList<Double> intensityList  = sp.getIntensityForEachPixel(path);
		ArrayList<Double> intensityList1  = new ArrayList<Double>(intensityList);
		System.out.println("################## 6th Question ##############");
		int size = intensityList.size();
		System.out.println("Intensity of each pixel in the given image, going from top left till bottom right, pixel by pixel : ");
		System.out.println(intensityList);
		
		// Merge Sort test
		start = System.nanoTime();
		sp.sortByMerge(intensityList, 0, size - 1);
	    end = System.nanoTime();
		System.out.println("\n\nTime taken by Merge algorithm: " + (end-start));
		System.out.println("Sort by Merge "+intensityList);

		
		
	
		// Heap Sort test
		start = System.nanoTime();
		sp.sortByHeap(intensityList1);
		end = System.nanoTime();
		System.out.println("\n\nTime taken by Heap algorithm: " + (end-start));
		System.out.println("Sort by Heap "+intensityList1);
		System.out.println("################################");

		
		
		System.out.println();
		System.out.println();

	// Question 7th Test :
       /* System.out.println("################################");
		MergeSort_Q7 msq = new MergeSort_Q7();
		
        String[] values = {"m", "e", "r", "g", "e", "s", "o", "r","t","e",
        		"x","a","m","p","l","e"};
        msq.mergeSort(values, 0, values.length - 1);
		
        System.out.println("Result " + Arrays.toString(values));
        */
	}
	

	
}

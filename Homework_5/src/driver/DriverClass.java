package driver;

import java.util.ArrayList;
import java.util.Arrays;

import question1.SortByQuick;
import question2.HeapSort_Test;
import question2.MergeSort_Test;
import question2.SortByInsertion;
import question3.SortByTim;
import question3.SortByTim64;
import question4.SortByTimSort;
import question4.SortByTimSort64;
import question4.SortPixel;
import question4.VariousSorts;

public class DriverClass {

	
	public static void main(String[] args) {
	
	
	VariousSorts vs = new VariousSorts();
	int[] a  = {11, 27, 43, 38, 3, 9, 82, 10, 21, 8, 34, 19, 6};
	int[] b  = {11, 27, 43, 38, 3, 9, 82, 10, 21, 8, 34, 19, 6};
	int[] c =  {11, 27, 43, 38, 3, 9, 82, 10, 21, 8, 34, 19, 6};
	int[] d =  {11, 27, 43, 38, 3, 9, 82, 10, 21, 8, 34, 19, 6};
	int[] e =  {11, 27, 43, 38, 3, 9, 82, 10, 21, 8, 34, 19, 6};
	
	
	// Question 1
	System.out.println("#################################");
	System.out.println("Question 1");
	System.out.println("#################################");
	
	
	System.out.println("Input Array of Quick Sort : ");
	vs.printAll(a);
	SortByQuick quick = new SortByQuick();
	long start = System.nanoTime();
	quick.quickSort(a, 0, a.length - 1);
	long end = System.nanoTime();
	System.out.println("Output Array of Quick Sort : ");
	vs.printAll(a);	
	long quickSortTime = (end-start);
	
	
	System.out.println();
	
	System.out.println("#################################");
	System.out.println("Question 2");
	System.out.println("#################################");

	System.out.println("Input Array of Insertion : ");
	vs.printAll(b);
	SortByInsertion insertion = new SortByInsertion();
	start = System.nanoTime();
	insertion.sortByIS(b);
	end = System.nanoTime();
	System.out.println("Output Array of Insertion: ");
	vs.printAll(b);	
	long insSortTime = (end-start);
			

	MergeSort_Test ms = new MergeSort_Test();
	start = System.nanoTime();
	ms.sort(c, 0, c.length - 1);
	end = System.nanoTime();
	long megSortTime = (end-start);
	
	
	
	HeapSort_Test hs = new HeapSort_Test();
	
	start = System.nanoTime();	
	hs.sort(d);
	end = System.nanoTime();
	long heapSortTime = (end-start);
	
	System.out.println();
	
	System.out.println("#################################");
	System.out.println("Question 3");
	System.out.println("#################################");

	SortByTim tim = new SortByTim();
	
	System.out.println("\nInput to TimSort with RUN = 32");
	vs.printAll(e);

	start = System.nanoTime();	
	tim.timSort(e, e.length);
	end = System.nanoTime();
	long timSortTime = (end-start);

	
	System.out.println("\nOutput of TimSort with RUN = 32 ");
	vs.printAll(e);
	
	SortByTim64 tim64 = new SortByTim64();
	
	System.out.println("\nInput to TimSort with RUN = 64");
	vs.printAll(e);

	start = System.nanoTime();	
	tim64.timSort(e, e.length);
	end = System.nanoTime();
	long timSortTime1 = (end-start);

	
	System.out.println("\nOutput of TimSort with RUN = 64");
	vs.printAll(e);
	
	
	
	
	
	System.out.println("\n\n ~~~~~~~~~~Summary~~~~~~~~~~ ");

	System.out.println("\n\nTime taken by Quick Sort (Nano Time) : " + quickSortTime);
	System.out.println("\n\nTime taken by Insertion Sort (Nano Time) : " + insSortTime);
	System.out.println("\n\nTime taken by Tim Sort (RUN = 32) (Nano Time) : " + timSortTime);
	System.out.println("\n\nTime taken by Tim Sort (RUN = 64) (Nano Time) : " + timSortTime1);
	System.out.println("\n\nTime taken by Merge Sort (Nano Time) : " + megSortTime);
	System.out.println("\n\nTime taken by Heap Sort (Nano Time) : " + heapSortTime);
	
	
	System.out.println("\n\nInsertion sort is faster for small n because Quick Sort has extra overhead from the recursive function calls.");

	System.out.println("\nInsertion sort is fastest among other sorts.");
	
	
	
	
	
	
	System.out.println();
	System.out.println("#################################");
	System.out.println("Question 4");
	System.out.println("#################################");

	String path = "C:\\Users\\rohit\\OneDrive\\Desktop\\Boston.jpeg";
	path = path.replace("\\", "/");
	
	
	SortPixel sp = new SortPixel();
	ArrayList<Double> intensityList  = sp.getIntensityForEachPixel(path);
	ArrayList<Double> intensityList1  = new ArrayList<Double>(intensityList);
	int size = intensityList.size();
	System.out.println("Intensity of each pixel in the given image, going from top left till bottom right, pixel by pixel : ");
	System.out.println(intensityList);
	

	// Bubble Sort Test
	start = System.nanoTime();
    vs.sortByBubble(intensityList);
	end = System.nanoTime();
	System.out.println("\n\nTime taken by Bubble Sort algorithm: " + (end-start));
	System.out.println("Sort by Bubble "+intensityList);



	// Selection Sort Test
	start = System.nanoTime();
    vs.sortBySelection(intensityList);
	end = System.nanoTime();
	System.out.println("\n\nTime taken by Selection Sort algorithm: " + (end-start));
	System.out.println("Sort by Selection "+intensityList);
	
	
	
	// Insertion and Quick Sort Takes N^2 of time, hence not useful to sort using such long array.
	// But it can be done, just uncomment the following lines to run.

	
	/*	
	// Insertion Sort Test
	start = System.nanoTime();
    vs.insertionSort(intensityList); 
	end = System.nanoTime();
	System.out.println("\n\nTime taken by Insertion Sort algorithm: " + (end-start));
	System.out.println("Sort by Insertion "+intensityList);

	
	// Quick Sort Pivot on 1st Test
	
	question4.SortByQuick qk = new question4.SortByQuick();
	start = System.nanoTime();
	qk.recursiveQuickSort(intensityList, 0, intensityList.size()-1);
	end = System.nanoTime();
	System.out.println("\n\nTime taken by Quick Sort algorithm: " + (end-start));
	System.out.println("Sort by Quick Sort (pivot on 1st index) "+intensityList);
	
	*/
	

	
	}

}

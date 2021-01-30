package practice;

public class MergeSortImpl {

	
	public static void printArray(int[] arr) {
		for(int i : arr)
			System.out.print(" "+i);
	}
	
	
	public static void mergeCall(int[] arr, int l, int h){
		if(l < h) {
			int m = (l + h)/2;
			mergeCall(arr, l, m);
			mergeCall(arr, m+1, h);
			merge(arr, l, m, h);
		}
	}
	
	public static void merge(int[] arr, int l, int m, int h){
		
		int size1 = m + 1;
		int size2 = h - m + 1;

		int[] left  = new int[size1];
		int[] right = new int[size2];
		
		for(int i  = 0; i < size1; i++) {
			left[i] = arr[i];	
		}
		for(int i = 0; i < size2; i++) {
			right[i] = arr[m+i];
		}
		
		int k = 0, i = 0, j = 0;
		
		while(i < size1 && j < size2) {
			if(left[i] >= right[j]) {
				arr[k] = right[j];
				j++;
			}
			else {
				arr[k] = left[i];
				i++;
			}
			k++;
		}
		

		
	}
	
	
	public static void main(String args[]) {
		int[] arr = {9,1,4,6,8,3,10,11,3};
		mergeCall(arr, 0, arr.length-1);
		
		
		printArray(arr);
		
		
	}
}

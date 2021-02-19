package basics;

public class QuickSort {
	
	public static void callQuickSort(int[] arr, int L, int R) {
		if(L < R) {
			int pivot = quickSort(arr, L, R);
			callQuickSort(arr, L, pivot-1);
			callQuickSort(arr, pivot+1, R);
		}
	}
	
	public static int quickSort(int[] arr, int L, int R) {
		System.out.println(" L : "+L+ " R : "+R );
		System.out.println();
		int pivot = arr[L];
		int start = L;
		int end   = R;

		while(start < end) {
			while(arr[start] <= pivot) {
				start++;
			}
			while(arr[end] > pivot){
				end--;
			}
			if(start < end) {
				swap(arr, start, end);
			}
		}
		swap(arr, L, end);
		printArr(arr);
		System.out.println();
		return end;
	}
	
	public static void swap(int[] arr, int L, int R) {
		int temp  = arr[L];
		arr[L] 	  = arr[R];
		arr[R]    = temp;
	}
	
	public static void printArr(int[] arr) {
		for(int i : arr)
			System.out.print(" | "+i);
	}
	
	public static void main(String args[]) {
		
		int[] arr = {9, 10, 1, 2, 5, 11, 12, 8, 3};
		callQuickSort(arr, 0, arr.length-1);
		printArr(arr);
			
	}

}

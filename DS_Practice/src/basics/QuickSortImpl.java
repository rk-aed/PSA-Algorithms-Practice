package basics;

public class QuickSortImpl {
	
	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j]  = temp;		
	}
	
	public static void quickSortCall(int arr[], int lb, int ub) {
		
		if(lb < ub){
			int loc = pivotPartition(arr, lb, ub);
			quickSortCall(arr, lb, loc-1);
			quickSortCall(arr, loc+1, ub);
		}
	}
	
	
	public static int pivotPartition(int arr[], int low, int high) {
		
		int pivot = arr[low];
		int start = low;
		int end   = high; 
		
		while(start < end) {
			
			while(arr[start] <= pivot) {
				start++;
			}
			while(arr[end] > pivot) {
				end--;
			}
			
			if(start < end)
				swap(arr, start, end);
		}
		
		
		
		return end;
	}
	

}

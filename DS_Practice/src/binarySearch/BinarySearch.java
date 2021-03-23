package binarySearch;

public class BinarySearch {

	
	private static int binarySearch(int[] arr, int element) {
		
		int start = 0;
		int end   = arr.length - 1;
		
		while(start >= end) {
			int mid = start  + ((end - start)/2);
			
			if(arr[mid] == element)
				return mid;
			else if(arr[mid] > element)
				end = mid-1;
			else if(arr[mid] < element)
				start = mid+1;
		}
		return -1;	
	}
	
	
	
	
	
	
	public static void main(String[] args) {

	}

}

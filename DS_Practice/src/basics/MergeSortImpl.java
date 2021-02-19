package basics;

public class MergeSortImpl {
	public static void mergeSortCall(int[] arr, int L, int R) {
		
		if(L < R) { // This means, we go till there is only one element 
			int  M = (L+R)/2;
			mergeSortCall(arr, L, M);
			mergeSortCall(arr, M+1, R);
			mergeThemAll(arr, L, M, R);
		}
		
	}
	
	public static void mergeThemAll(int[] arr, int L, int M, int R) {
		int i = L;
		int j = M+1;
	 	int k = L;
		
		int[] b  = new int[arr.length];
		while(i <= M && j <= R) 
		{
			if(arr[i] <= arr[j]){
				b[k] = arr[i];
				i++;
			}
			else {
				b[k] = arr[j];
				j++;
			}
			k++;
		}
		if(i > M) {
			while(j <= R)
			{
				b[k] = arr[j];
				j++;
				k++;
			}
		}
		else {
			while(i <= M) {
				b[k] = arr[i];
				i++;
				k++;
			}
		}
	}
	
	public static void printAllArray(int[] arr) {
		for(int  i  : arr)
			System.out.print(" | "+i);
		
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {9, 10, 1, 2, 5, 11, 12, 8, 3};
		mergeSortCall(arr, 0, arr.length-1);
		printAllArray(arr);
		
	}
	
	
	
	
	
	

}

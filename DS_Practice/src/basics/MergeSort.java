package basics;

public class MergeSort {
	public static void mergeSortCall(int[] arr, int L, int R) {
		if(L < R) {
			int M = (L+R)/2;
			mergeSortCall(arr, L, M);
			mergeSortCall(arr, M+1, R);
			mergeThemAll(arr, L, M, R);
			
		}
	}
	
	public static void mergeThemAll(int[] arr, int L, int M, int R) {
		int size1 = M - L + 1;
		int size2 = R - M;
		
		int[] left = new int[size1];
		int[] right = new int[size2];
		
		for(int i = 0; i < size1; i++)
			left[i] = arr[L+i];
		
		for(int i = 0; i < size2; i++)
			right[i] = arr[M+1+i];
		
		int i = 0, j = 0, k = L;
		
		while(i < size1 &&
				j < size2)
		{
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
		
		
		while(i < size1) {
			
			arr[k]= left[i];
			i++;
			k++;
			
			
		}
		while(j < size2){
			arr[k] = right[j];
			j++;
			k++;
		}
		
	}
	
	public static void printArr(int[] arr) {
		
		for(int i : arr)
			System.out.print(" | "+i);
		
	}
	
	public static void main(String[] arg) {
		
		
		int[] arr = {9, 10, 1, 2, 5, 11, 12, 8, 3};
		mergeSortCall(arr, 0, arr.length-1);
		printArr(arr);
		
	}

}

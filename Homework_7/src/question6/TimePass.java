package question6;

public class TimePass {

	static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	static void printAll(int[] arr) {
		
		for(int i : arr) System.out.print(i+" ");
			
		System.out.println();
		
	}
	
	static void sSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int pick = i;
			
			for(int j = i+1;j < arr.length; j++) {
				if(arr[pick] > arr[j]) {
					pick = j;					
				}
			}
			if(pick != i) swap(arr, i, pick);

		}
	}
	
	
	static void bSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length-1; j++) {
				if(arr[j] > arr[j+1]) swap(arr, j+1, j);
			}
		}
	}
	
	
	static void iSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int pick = arr[i];
			int j = i;
			while(j > 0
					&&
					pick < arr[j-1]) {
				swap(arr, j, j-1);;
				j--;
			}
			arr[j] = pick;
		}
		
	}
	
	
	static void test(int N) {
     int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j=0; j < i; j++) {
				count++;		
			}
		}
		System.out.println("Final : "+count);
	}
	

	static void test1(int N) {
     int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j=0; j < N; j++) {
				count++;		
			}
		}
		System.out.println("Final : "+count);
	}
	
	
	public static void main(String[] args) {
		int[] temp = {43,45,12,65,867,1,54,76,2,5,6};
		
		
		/*
		System.out.println("Before sort : ");
		printAll(temp);

		
		
		iSort(temp);
		System.out.println("After sort : ");
		printAll(temp);
		*/
		
		
		
		

	
	}

}

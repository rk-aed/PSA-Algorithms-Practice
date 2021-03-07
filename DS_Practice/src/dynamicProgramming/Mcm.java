package dynamicProgramming;

public class Mcm {
	
	
	private static int calcMcm(int[] arr) {
		
		// This is an MCM problem...
		// Steps to calc MCM?
		// 1. Initialize i and j...
			int i = 1; // Cant be 0...since there is no i-1...
			int j = arr.length-1; // yeah
			
		return doMcm(arr, i, j);	
	}
	
	
	private static int doMcm(int[] arr, int i, int j) {
		// 2. Base Condition
			// Smallest invalid inputs..
		
		if(i >= j) return 0;
		
		
		int result = Integer.MAX_VALUE;
		// 3. For Loop and possible k schemes
		for(int k = i; k <= j-1; k++) {			
			int sum = doMcm(arr, i, k) + doMcm(arr, k+1, j) + arr[i-1] * arr[j] * arr[k];
			result = Math.min(sum, result);			
		}
		
		// 4. calc and return	
		return result;	
	}
	
	public static void main(String args[]) {
		
		int[] arr = {40,20,30,10,30};
		
		// Calculate Matrix Chain Multiplication...
		// Minimum Cost...	
		System.out.println("Answer for MCM : "+calcMcm(arr));
		
		
		
	}
}

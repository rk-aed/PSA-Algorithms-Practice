package dynamicProgramming;

import java.util.ArrayList;

public class Practice {
	
	static int temp;
	private static int knapsackWRecursion(int[] v, int[] w, int W, int size) {
		
		// 1. Base condition
		if(W == 0 ||   size == 0)
			return 0;
		
		
		// 2. Choice Diagram
		
		if(w[size-1] <= W) 
			return Integer.max(v[size-1] + knapsackWRecursion(v, w, W - w[size-1], size-1), knapsackWRecursion(v,w,W,size-1));
		else 
			return knapsackWRecursion(v,w,W,size-1);			
			
	}
	private static void printMat(int[][] mat) {
		
		 for (int i = 0; i < mat.length; i++)
			 	{
			 	System.out.println("");
	            // Loop through all elements of current row
	            for (int j = 0; j < mat[i].length; j++)
	                System.out.print(mat[i][j] + " ");	
			 	}
			System.out.println("");
		 System.out.println("#################################");
		
	}
    private static int[][] initT(int W,int size){
		
		// 1. Initialize matrix
			int[][] t = new int[W+1][size+1];
			
			for(int i = 0; i <= W; i++)
				for(int j = 0; j <= size; j++) {
					
					t[i][j] = -1;
				}
			return t;
	}
	private static int ksMem(int[] v, int[] w, int W, int size) {
		 int[][] t = initT(W,size);
	     return realKSMem( v,  w,  W, size, t);
		
	}
	private static int realKSMem(int[] v, int[] w, int W, int size, int[][] t) {
		if(size == 0 || W == 0)
			return 0;
		
		
		// 3. Check if present already, return
		if(t[W][size] != -1)
			return t[W][size];
		
	//	printMat(t);
		// 4. Choice Diagram
		
		if(w[size-1] <= W) {
			t[W][size] = Math.max(v[size-1] + realKSMem(v, w, W - w[size-1], size-1,t), realKSMem(v,w,W,size-1,t));
			return t[W][size];
		}
		
		else {
			t[W][size] = realKSMem(v,w,W,size-1,t);
			return t[W][size];			
		}
		
		
		
	}
	private static int ksBU(int[] v, int[] w, int W, int size) {
		int[][] t = new int[W+1][size+1];
		
		// Initialize... Initialize to zero, but in java its already 0. So set.
		
		
		// Iterate
		
		for(int i = 1; i <= W; i++)
			for(int j = 1; j <= size; j++) {
				if(w[j-1] <= i) {
					t[i][j] = Math.max(v[j-1] + t[W-w[j-1]][j-1], t[i][j-1]); 
				}
				else {
					t[i][j] =  t[i][j-1];
					
				}
			}
		
		return t[W][size];
	}
	
	// ############################### Subset sum ########################
	
	private static boolean subsetSum(int[] arr, int sum, int size) {
		
		 // 1. Initialize
		boolean[][] t  =  new boolean[size+1][sum+1];
		
			// Smallest valid input? sum = 0; size = 0...true...
		
		for(int i = 0; i <= size; i++)
			t[i][0] = true;
		
		for(int i = 1; i <= sum; i++)
			t[0][i] = false;
		
		
		//  2. Iterate
		for(int i = 1; i <= size; i++) {
			for(int j = 1; j <= sum; j++) {
				if(arr[i-1] <= j) 
					t[i][j] =  t[i-1][j-arr[i-1]]  || t[i-1][j];					
				else 
					t[i][j]  = t[i-1][j];
			}
		}
		
		
		
		
		
		
		
		return t[size][sum];
	}
	
    // ############################### Equal sum partition ################	
	
	private static boolean equalSumPartition(int [] arr, int size) {
		int sum = 0;
		
		for(int i = 0; i < size; i++)
			sum += arr[i];
		
		
		if((sum % 2) != 0) {
			int newSum = sum/2;
			return subsetSum(arr, newSum, arr.length);
		}
		else 
			return false;
	}
	
	
    // ############################### Count no. of subset sum  ################	
	
	
	private static int countSumPartition(int [] arr, int sum) {
		
		int[][] t = new int[arr.length+1][sum+1];
		
		
		// 1. Initialize
		for(int i = 0; i <= arr.length; i++)
			t[i][0] = 1;
			
			
		for(int i = 0; i <= sum; i++)
			t[1][sum] = 0;
		
		
		
		// 2. Iterate
		for(int i = 1; i <= arr.length; i++)
			for(int j = 1; j <= sum; j++)
			{
				if(arr[i-1] <= j) {
					
					t[i][j] = t[i-1][j - arr[i-1]] + t[i-1][j];
				}
				else {
					
					t[i][j] = t[i-1][j];
					
				}
			}	
		
		
		
		
		
		return t[arr.length][sum];
	}
	
	
    // ############################### Minimum Subset sum difference  ################	
	
	private static int minSubsetSumDiff(int[] arr) {
		// we need to find two subsets whose difference is minimum...
		// subset 1 - subset 2 = diff --- 1
		// subset 1 + subset 2 = sum ---  2 
		// 2 subset 1 = diff + sum; that is also subset = (diff + sum) / 2
		// Range of possible values -> 0 to sum
			
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		int halfway = sum/2;
		
		ArrayList<Integer> possibleValues = new ArrayList<Integer>();
		
		for(int i = 1; i < halfway; i++) {
			if(subsetSum(arr, i, arr.length)) {
					possibleValues.add(i);
			}
		}
		
		System.out.println("possibleValues "+possibleValues);
		int min = Integer.MAX_VALUE;
		// subset 2 =  subset 1 + diff
		// subset 1 + diff - subset 1 = diff
		
		for(int i : possibleValues) {
				if(min > i)
						min = i;
		}
		return min;
	}

	
    // ############################### Count the number of subset with a given difference  ################	
		
	private static int numberSubsetGivenDiff(int[] arr, int diff) {
		
		// we need to find two subsets whose difference is minimum...
				// subset 1 - subset 2 = diff --- 1
				// subset 1 + subset 2 = sum ---  2 
				// 2 subset 1 = diff + sum; that is also subset = (diff + sum) / 2
		int sum = 0;
	    for(int i = 0; i < arr.length; i++)
	    	sum += arr[i];
		
		int subsetValue  = (diff + sum) / 2;
		
		System.out.println(subsetValue);
		int[][] t = new int[arr.length + 1][subsetValue+1];
		
		// Initialization
				
		for(int i = 0; i <= arr.length; i++)
			t[i][0] = 1;
		
		for(int i = 1; i <= subsetValue; i++)
			t[0][i] = 0;
		
		// Iterator
		
		for(int i = 1; i <= arr.length; i++) {
			for(int j = 1; j <= subsetValue; j++) {
				if(arr[i-1] <= j)
					t[i][j] = t[i-1][j - arr[i-1]] + t[i-1][j];
				else 
					t[i][j] = t[i-1][j];
			}
		}
		
		printMat(t);
		
		return countSumPartition(arr, subsetValue);
		
		// return t[arr.length][subsetValue];
	}	
	
	
	// ################################### Unbounded Knapsack & Rod Cutting problem #########################
	
	private static int unboundedKnapsack(int[] w,int[] val, int W) {
		int len = w.length;
		int[][] t = new int[len+1][W+1];
 		
	
		
		// Iterate
		
		for(int i = 1; i < len+1; i++) {
			for(int j = 1; j < W+1; j++) {
				if(w[i-1] <= j) 
					t[i][j] = Math.max(val[i-1]+t[i][j-w[i-1]], t[i-1][j]);
				else 
					t[i][j] = t[i-1][j];
			}
		}
		
		
		return t[len][W];
		
	}


	
	
	public static void main(String[] args) {
/*
		int v[] = { 20, 5, 10, 40, 15, 25 };
		int w[] = {  1, 2,  3,  8,  7, 4 };
		int W = 10;
		int n = 6;

		System.out.println("Answer : "+knapsackWRecursion(v, w, W, n));
		System.out.println("Answer : "+ksMem(v, w, W, n));
		System.out.println("Answer : "+ksBU(v, w, W, n));
		
		int w1[] = {  5 , 5 , 10 , 12,12,434,567,2345,67 };
		System.out.println("Answer : "+subsetSum(w1,  446  , 9));		
		System.out.println("Answer : "+ equalSumPartition(w1, w1.length));
	
		int w1[] = {  1,5,5,11 ,25,13,34,16,27,25};
		int arr[] = {1,1,1,1};
		System.out.println("Answer : "+countSumPartition(arr, 1));		
		
*/	
			
		int w1[] = {1, 6, 11, 5};
		int arr[] = {1,1,1,1};
	//	System.out.println("Answer : "+minSubsetSumDiff(w1));		
		
		
		
		
        int W = 100;
        int val[] = {10, 30, 20};
        int wt[] = {5, 10, 15};
        System.out.println(unboundedKnapsack(wt,val, W));
		
		
		
		
		
		
		
	}

}

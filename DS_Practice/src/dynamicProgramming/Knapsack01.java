package dynamicProgramming;

public class Knapsack01 {
	
	// Recursion Knapsack
	
	static private int knapsackWRecursion(int[] val, int[] wgt, int W, int n) {
		// Base condition    - Smallest valid inputs.
		if(n ==0 || W == 0)
			return 0;
		// Choice Diagram
		if(wgt[n-1] <= W) return Math.max(val[n-1] + knapsackWRecursion(val, wgt, W - wgt[n-1], n-1), // Selected, 				
				knapsackWRecursion(val, wgt, W, n-1));  // Not selected..)
		else if(wgt[n-1] > W) return knapsackWRecursion(val, wgt, W, n-1);
		
		return 0;
	}
	
	
	
	// Knapsack using Memoization
	
	static private int ksMem(int[] val, int[] wgt, int W, int n) {
		
		int[][] dp = new int[W+1][n+1];
		
		// Initialize dp
		for(int i = 0; i < W+1; i++)
			for(int j = 0; j < n+1; j++)
				dp[i][j] = -1;
		
		// Base condition
		
		if(n == 0 || W == 0) return 0;
		
		
		if(dp[W][n] == -1) {			
			// Condition Diagram
			if(wgt[n-1]  <= W) { 
				dp[W][n] = Math.max(val[n-1] + ksMem(val, wgt, W - wgt[n-1], n-1), ksMem(val, wgt, W, n-1));
				return dp[W][n];
				
			}
			else if(wgt[n-1] > W) { 
				dp[W][n] = ksMem(val, wgt, W, n-1);
				return dp[W][n];
			}
		}
		else if(dp[W][n] != -1) return dp[W][n];
		return 0;
	}
	
	
	
	// Bottom Up approach
	
	
	
	static private int ksBU(int[] val, int wgt[], int W, int n) {
		int[][] dp = new int[W+1][n+1];		
		
		// Base condition - Initialization
		for(int i = 0; i < W + 1; i++)
			for(int j = 0; j < n + 1; j++)
				if(i == 0 || j == 0)
						dp[i][j] = 0;
		
		// Choice diagram - Iterative approach
		for(int i = 1; i < W + 1; i++)
		{
			for(int j = 1; j < n + 1; j++)
			{
				if(wgt[j-1] <= i) dp[i][j] =  Math.max(val[j-1] + dp[i - wgt[j-1]][j-1], dp[i][j-1]);
				else if(wgt[j-1] > i) dp[i][j] =  dp[i][j-1];		
			}
		}
			
		return dp[W][n];
	}
	
	
	
	
	public static void main(String[] args) {
		int v[] = { 20, 5, 10, 40, 15, 25 };
		int w[] = {  1, 2,  3,  8,  7, 4 };
		int W = 10;
		int n = 6;

		System.out.println("Answer : "+knapsackWRecursion(v, w, W, n));
		System.out.println("Answer : "+ksMem(v, w, W, n));
		System.out.println("Answer : "+ksBU(v, w, W, n));
		
		
	}

}

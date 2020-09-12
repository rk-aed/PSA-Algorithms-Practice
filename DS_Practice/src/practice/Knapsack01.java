package practice;

public class Knapsack01 {
	
	
	// Knapsack Recursive method
	private static int ksR(int[] val, int[] wgt, int W, int n) {
		
		// base condition
		if(n == 0 || W == 0)
			return 0;
		
		// choice diagram
		if(wgt[n-1] <= W) return Math.max(val[n-1] + ksR(val, wgt, W - wgt[n-1], n-1), ksR(val, wgt, W, n-1));
		else if(wgt[n-1] > W) return ksR(val, wgt, W, n-1);
		
		
		return 0;
	}
	
	
	
	// KS mem
	private static int ksM(int[] val, int[] wgt, int W, int n) {
		

		// Base condition
		
		if(n == 0 || W == 0) return 0;

		// Make DP table
		int[][] dp = new int[W+1][n+1];
		for(int i = 0; i < W+1; i++)
			for(int j =0; j < n+1; j++)
				dp[i][j] = -1;
		
		
		if(dp[W][n] != -1) return dp[W][n];
		else {
			// choice diagram
			if(wgt[n-1] <= W) {
				dp[W][n] = Math.max(val[n-1] + ksM(val, wgt, W - wgt[n-1], n-1), ksM(val, wgt, W, n-1));
				return dp[W][n]; 
			}
			else if(wgt[n-1] > W) {
				dp[W][n] = ksM(val, wgt, W, n-1);
				return dp[W][n];
			}
		}

		
		
		return 0;
	}
	
	// KS bottom up
	private static int ksTab(int[] val, int[] wgt, int W, int n) {
		
		// Base condition - initialize 
		int[][] dp = new int[W+1][n+1];
		for(int i = 0; i < W+1; i++)
			for(int j = 0; j < n+1; j++)
				if(i == 0 || j == 0) dp[i][j] = 0;

		// Choice diagram - iterative approach
		for(int i = 1; i < W+1; i++)
			for(int j = 1; j < n+1; j++)
			{
				if(wgt[j-1] <= i) dp[i][j] = Math.max(val[j-1] + dp[i-wgt[j-1]][j-1], dp[i][j-1]);
				else if(wgt[j-1] > i) dp[i][j] = dp[i][j-1];	
			}
		
		
		
		// Return bottom right
		return dp[W][n];
	}

	public static void main(String[] args) {
		
		
		int v[] = { 20, 5, 10, 40, 15, 25 };
		int w[] = {  1, 2,  3,  8,  7, 4 };
		int W = 10;
		int n = 6;

		System.out.println("Answer : "+ksR(v, w, W, n));
		System.out.println("Answer : "+ksM(v, w, W, n));
		System.out.println("Answer : "+ksTab(v, w, W, n));

	}

}

package dynamicProgramming;

public class SubsetSumProb {

	private static boolean subsetTab(int[] arr, int sum, int n) {
		boolean[][] dp = new boolean[n+1][sum+1];
		
		// Initialize 
		for(int i = 0; i < n+1; i++)
			for(int j = 0; j < sum+1; j++) {
				if(i == 0 && j == 0) dp[i][j] = true;
				else if(i == 0 && j != 0) dp[i][j] = false;
				else if(j == 0 && i != 0) dp[i][j] = true;
			}
	//	printDP(dp, n, sum);
			
		
		// Choice diagram
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= sum; j++) {
				if(arr[i-1] <= j) {
					dp[i][j] = dp[i-1][j-arr[i-1]]  // Selected
							|| 
							dp[i-1][j]; // Not selected
					
				}
				else if(arr[i-1] > j) dp[i][j] = dp[i-1][j]; // Not selected
		}
		
//		printDP(dp, n, sum);
		
		return dp[n][sum];
	}
	
	static private void printDP(boolean[][] dp, int n, int sum) {
		
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < sum+1; j++) {
				if(dp[i][j]) System.out.print(" T");
				else System.out.print(" F");
			}		
		System.out.println();
		}
	}

		
	public static void main(String[] args) {
	
		int arr[] = {2,3,6,8,12,18};
		int n = arr.length;
		int sum = 11;
		
		System.out.println("Does arr has sum of 11 : "+subsetTab(arr, sum, n));
		
		
		
        int set[] = { 6, 34, 4, 12, 3, 2 }; 
        sum = 9; 
        n = set.length; 
        System.out.println("Does arr has sum of 9 : "+subsetTab(set, sum, n));
		
		
		
		

	}

}

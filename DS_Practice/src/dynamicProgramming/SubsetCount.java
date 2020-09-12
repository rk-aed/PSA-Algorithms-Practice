package dynamicProgramming;

public class SubsetCount {

	
	static private int subsetCount(int[] arr, int sum) {
		
		// Init
		int[][] dp = new int[arr.length+1][sum+1];
		
		dp[0][0]=1;
		for(int i = 0; i < arr.length+1; i++)
			for(int j = 0; j < sum; j++) {
				if(i == 0 && j != 0) dp[i][j] = 0;
				else if(j == 0 && i != 0) dp[i][j] = 1;
			}
		// Choice diagram
		for(int i = 1; i < arr.length+1; i++)
			for(int j = 1; j < sum+1; j++)
				if(j >= arr[i-1]) dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];					
				else if(j < arr[i-1]) dp[i][j] = dp[i-1][j];
		
		
		
		return dp[arr.length][sum];
	}
	
	
	
	public static void main(String[] args) {

		 int[] arr = {2,3,5,8,10};
		 int sum = 10;
		 
		 
		 System.out.println("# of subsets in the given array is : "+subsetCount(arr, sum));
		
		
		
	}

}

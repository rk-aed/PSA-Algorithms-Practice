package practice;

public class EqualSumPartition {
	
	
	private static boolean equalSum(int[] arr, int length) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum = sum + arr[i];
		
		if(sum%2 == 0) {
			// even
			
			sum = sum/2;
			boolean[][] dp = new boolean[sum+1][arr.length+1];

			
			dp[0][0] = true;
			// Initialization
			for(int i  = 0; i < sum+1; i++)
				for(int j  = 0; j < arr.length+1; j++)
				{
					if(j == 0 && i != 0) dp[i][j] = false;
					else if(j != 0 && i == 0) dp[i][j] = true;
				}
			
			// Iterative solve of choice diagram		
			for(int i = 1; i < sum+1; i++)
			{
				for(int j = 1; j < arr.length+1; j++)
				{
					if(i >= arr[j-1]) dp[i][j] = dp[i - arr[j-1]][j-1] || dp[i][j-1];
					else if (i < arr[j-1]) dp[i][j] = dp[i][j-1];
				}		
			}
			
			return dp[sum][arr.length];
			
		}
		
		// odd
		else return false;
	}
	
	
	
	
	
	
	
	
	public static void main(String args[]) {
		
		int[] arr = {2,5,5,12};
		
		
		System.out.println("Arr has equal sum partition : "+equalSum(arr, arr.length));
		
		
		
		
		
	}
	
}

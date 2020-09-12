package dynamicProgramming;

public class EqualSumPratition {

	private static boolean equalSum(int[] arr, int n) {
		
		// Check even odd
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum = sum + arr[i];
		
		if((sum % 2) == 0) {
			// Even
			sum = sum/2;
			System.out.println("sum : "+sum);
			boolean dp[][] = new boolean[sum+1][n+1];
			dp[0][0] = true;
			
			// Init
			for(int i = 0; i <= sum ; i++)
				for(int j = 0; j <= n; j++)
				{
					if(i == 0 && j != 0) dp[i][j] = false;
					else if(j == 0 && i != 0) dp[i][j] = true;
				}
			
			// Choice diagram
			for(int i = 1; i <= sum ; i++) 			
				for(int j = 1; j <= n; j++)
				{
					if(arr[j-1] <= i) dp[i][j] = dp[i - arr[j-1]][j-1] || dp[i][j-1];
					else if(arr[j-1] > i) dp[i][j] = dp[i][j-1];
				}			
			return dp[sum][n];
		}
		
		
		else return false; // Odd
	}
	
	
	public static void main(String args[]) {
		
		
		int[] arr = {2,5,5,14};
		
		System.out.println("Equal sum partition : "+equalSum(arr, arr.length));
		
		
	}
	
	
}

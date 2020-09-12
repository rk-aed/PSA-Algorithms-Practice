package practice;

public class SubsetSumProb {
	
	private static boolean ssp(int[] arr, int sum, int n) {
		boolean dp[][] = new boolean[sum+1][n+1];
		
		for(int i = 0; i <= sum; i++)
			for(int j = 0; j <= n; j++)
				{
					if(i == 0 && j == 0)      dp[i][j] = true;
					else if(i == 0 && j != 0) dp[i][j] = true;
					else if(j == 0 && i != 0) dp[i][j] = false;		
				}
		

		for(int i = 1; i <= sum; i++)
			for(int j = 1; j <= n; j++){
				if(arr[j-1] <= i) dp[i][j] = dp[i - arr[j-1]][j-1] || dp[i][j-1];
				else if(arr[j-1] > i) dp[i][j] = dp[i][j-1];				
			}
		
		return dp[sum][n];
	}
	
	public static void main(String[] args) {
		int arr[] = {2,3,6,8,12,18};
		int n = arr.length;
		int sum = 11;
		System.out.println("Does arr has sum of 11 : "+ssp(arr, sum, n));
		
        int set[] = { 3, 34, 4, 12, 3, 1 }; 
        sum = 9; 
        n = set.length; 
        System.out.println("Does arr has sum of 9 : "+ssp(set, sum, n));
		
        
        

        int set1[] = { 2,5,5,14 }; 
        sum = 13; 
        n = set1.length; 
        System.out.println("Does arr has sum of 9 : "+ssp(set1, sum, n));
	}

}

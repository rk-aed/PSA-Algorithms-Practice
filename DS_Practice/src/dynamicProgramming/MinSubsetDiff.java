package dynamicProgramming;

import java.util.ArrayList;

public class MinSubsetDiff {
	
	
	static private boolean[][] getSubsetDP(int[] arr,int sum)
	{
		boolean[][] dp= new boolean[sum+1][arr.length+1];
		dp[0][0] = true;
		for(int i = 0; i < sum+1; i++)
			for(int j = 0; j < arr.length+1; j++) {
				if(i == 0 && j != 0) dp[i][j] = true ;
				else if(j == 0 && i != 0) dp[i][j] = false;
			}

		
		for(int i = 1; i < sum+1; i++)
			for(int j = 1; j < arr.length+1; j++) {
		//		if(i >= arr[j-1]) dp[i][j] = dp[i-arr[j-1]][j-1] || dp[i][j-1];
		//		else if(i < arr[j-1]) dp[i][j] = dp[i][j-1];
			}
		
		return dp;
	}
	
	static private int minSubsetDiff(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum = sum + arr[i];
		System.out.println("Sum : "+sum);
		
		boolean[][] dp = getSubsetDP(arr, sum);
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i = 0; i < sum+1; i++) 
			if(dp[i][arr.length]) 
				arrList.add(i);
		
		int min = Integer.MAX_VALUE;
		
		for(int i  : arrList)  
			min = Math.min(min, (sum - (2*i)));
			
		return min;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1,5,6,11};
		
		
		System.out.println("Min Subset Diff : "+ minSubsetDiff(arr));
		

	}

}

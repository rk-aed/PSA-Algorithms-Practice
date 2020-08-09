package q1;

public class UboundedKnapsack {
	private static int max(int i, int j) { 
		return (i > j) ? i : j; 
} 
 
private static int unboundedKnapsack(int W, int n, 
							int[] val, int[] wt) { 
	
	int dp[] = new int[W + 1]; 
	
	for(int i = 0; i <= W; i++){ 
		for(int j = 0; j < n; j++){ 
			if(wt[j] <= i){ 
				dp[i] = max(dp[i], dp[i - wt[j]] + 
							val[j]); 
			} 
		} 
	} 

	return dp[W]; 
} 


static void printDP(int dp[]) {
	for(int i : dp)
  	System.out.print(" "+i);
	System.out.println(" "+dp.length);
}
public static void main(String[] args) { 
	int W = 36; 
	int val[] = {4, 5, 10, 11, 12}; 
	int wt[] = {3, 4, 7,8,9}; 
	int n = val.length; 
	System.out.println("Q1) Max value that can be achieved for the given parameters is "+unboundedKnapsack(W, n, val, wt)); 
} 

	
	

}

package dynamicProgramming;

public class StringLCS {

	private static int lcsRecursive(String s1, String s2, int n, int m) {
		
		// 1. Base condition
		if(n == 0 || m == 0)
			return 0;
		
		// 2. Recursive
		if(s1.charAt(n-1) == s2.charAt(m-1)) 
			return 1 + lcsRecursive(s1, s2, n-1, m-1);
		else
			return Math.max(lcsRecursive(s1, s2, n-1, m), lcsRecursive(s1, s2, n, m-1));
		
	}
	
	
	private static int[][] makeMatrix(int n, int m){
		int[][] t = new int[n+1][m+1];
		// initialize t with -1
		for(int i = 0; i < n+1; i++)
			for(int j = 0; j < m+1; j++) 
					t[i][j] = -1;
		
		return t;
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
	
	
	private static int lcsMemo(String s1, String s2, int n, int m,  int[][] t) {

		printMat(t);
		// 1. Base condition
		if(n == 0 || m == 0)
			return 0;	
		if(t[n-1][m-1] != -1)
			return t[n-1][m-1];
		
		if(s1.charAt(n-1) == s2.charAt(m-1)) { 		
		
			t[n-1][m-1] = 1 + lcsMemo(s1, s2, n-1, m-1,t);
			return t[n-1][m-1];
		}	
		else
		{
			t[n-1][m-1] = Math.max(lcsMemo(s1, s2, n-1, m,t), lcsMemo(s1, s2, n, m-1,t));
			return t[n-1][m-1];
		}		
	}
	
	
	private static int lcsDP(String s1, String s2, int n, int m) {
		int[][] t = new int[n+1][m+1];
		StringBuilder result = new StringBuilder();
		// 1. Initialize
		for(int i = 0; i < n+1; i++)
			t[i][0] = 0;
		
		for(int j = 0; j < m+1; j++)
			t[0][j] = 0;
		
		for(int i = 1; i < n+1; i++)
			for(int j = 1; j < m+1; j++)
			{
				
				if(s1.charAt(i-1) == s2.charAt(j-1)) 
					t[i][j] = 1 + t[i-1][j-1];				
				else
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
			}		
		
		
		System.out.println(result);
		
		// 2. Iterate
		
		return t[n][m];
				
	}	
	
	
	
	private static String printLcs(String x, String y) {
		StringBuilder result = new StringBuilder();

		int m = x.length();
		int n = y.length();
		
		int[][] t = new int[x.length()+1][y.length()+1];
		
		
		// 1. Initialize
		for(int i = 0; i < m+1; i++)
			t[i][0] = 0;
		for(int j = 0; j < n+1; j++)
			t[0][j] = 0;
		
		// 2. Iterate
		for(int i = 1; i < m+1; i++)
			for(int j = 1; j < n+1; j++)
			{
				if(x.charAt(i-1) == y.charAt(j-1)) {
					
				//	result.append(x.charAt(i-1));
					t[i][j] = 1 + t[i-1][j-1];
				}
				else
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]); 
			}
		
		
		// 3. Backtracking
		int i = m;
		int j = n;
		
		while(i > 0 && j > 0)
		{
			if(x.charAt(i-1) == y.charAt(j-1)) {
				result.append(x.charAt(i-1));
				i--;
				j--;
			}
			else {
				if(t[i][j-1] > t[i-1][j])
					j--;
				else 
					i--;
			}
		}
	
		return new String(result.reverse());
	}
	
	
	
	
	
	
	
	
	public static void main(String args[]) {
		
		String s1 = "abcefg";
		String s2 = "cgfpiwg";
		
//	   System.out.println("Answer : "+ lcsRecursive(s1, s2, s1.length(), s2.length()));
		
		int[][] t = makeMatrix(s1.length()+1, s2.length()+1);
	//	System.out.println("Answer : "+ lcsMemo(s1, s2, s1.length(), s2.length(), t));
	
		
		
		 System.out.println("Answer : "+ lcsDP(s1, s2, s1.length(), s2.length()));
			
		
		
		System.out.println("Answer : "+ printLcs(s1, s2));
		
		
		
		
		
		
	}
	
	
}

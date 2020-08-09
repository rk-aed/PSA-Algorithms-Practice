package q2;

import java.util.Arrays;

public class GreedyAlgo {
	
	static int greedyApproach(int[] A, int T) {
		int noOfTasksCompleted = 0;
		int currTime = 0;
		
		Arrays.sort(A);
		
		for(int i  : A) {
			if(T > currTime) {
				currTime += i;
				noOfTasksCompleted++;
			}
			else break;
		}
		
		return noOfTasksCompleted;
	}
	
	public static void main(String[] args) {
		int[] A = {8,7,6,5,4,3,2,1};
		int T = 15;
		
		
		System.out.println("Q2) Greedy approach, solution for the given parameters : "+greedyApproach(A, T));
	}
	
	

}

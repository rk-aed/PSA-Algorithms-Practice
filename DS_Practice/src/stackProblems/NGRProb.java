package stackProblems;

import java.util.Stack;

public class NGRProb {
	
	
	private static int[] ngrProb(int[] arr) {
		
		int[] result = new int[arr.length];
	//	int index = 0;
		Stack<Integer> stk = new Stack<Integer>();
		for(int i = arr.length-1; i >= 0; i--) {
			int temp = arr[i];
			// Case 1 - Stack empty
			if(stk.isEmpty()) { 
				result[i] = -1;
				stk.push(temp);
				//index++;
			}
			// Case 2 : Stack not empty, stk.peek < stk.pop
			else if(stk.peek() < temp) {
					while(stk.isEmpty())
					{
						stk.pop();
						if(stk.peek() > temp) {
							result[i] = stk.peek();
							stk.push(temp);
					//		index++;
							break;
						}
						else if(stk.isEmpty()) { result[i] = -1; 
						//index++; 
						}
					}	
			}
			else if(stk.peek() > temp) {
				result[i] = stk.peek();
				stk.push(temp);
			//	index++;
			}
		}
		
//		java.util.Stack<Integer> stk = new java.util.Stack<Integer>();
//		for(int i = arr.length-1; i >= 0; i--) {
//			if(stk.empty()) result[i] = -1;
//			else if(!stk.empty() && stk.peek() > arr[i] ) result[i] = stk.peek();
//			else if(!stk.empty() && stk.peek() <= arr[i] ) { 
//				while(!stk.empty() && stk.peek() > arr[i]) {					
//					stk.pop();
//				}
//				if(stk.size() == 0) 
//				
//				
//				result[i] = stk.peek();}
//			else stk.pop();
//		}
		
		return result;
	}
	
	
	
	public static void main(String args[]) {
		
		int[] arr = {1,3,0,0,1,2,4};
		
		int[] result = ngrProb(arr);
		
		for(int i : result) System.out.print(" "+i);
		
		
	}
}

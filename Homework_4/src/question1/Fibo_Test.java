package question1;

public class Fibo_Test {
	
			
	public int fibonacciRecursion(int n){
	if(n == 0){
		return 0;
	}
	if(n == 1 || n == 2){
			return 1;
		}
	
	return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
	}
		public void fiboUsingIterative(int a) {
	        int i=1;
	        int previousNumber = 0;
	        int nextNumber = 1;
	        while(i <= a)
	        {
	            System.out.print(previousNumber+" ");
	            int sum = previousNumber + nextNumber;
	            previousNumber = nextNumber;
	            nextNumber = sum;
	            i++;
	        }
		}
	

}

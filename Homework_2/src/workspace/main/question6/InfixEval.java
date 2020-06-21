package workspace.main.question6;

import java.util.HashMap;
import java.util.Stack;

public class InfixEval {
	
	Stack<Double> oprnd; // = new Stack();
	Stack<Character> oprt; //  = new Stack();
	HashMap<Character  , Integer> oprts; // = new HashMap<Character , Integer>();
	
	public InfixEval()
	{
		 oprnd = new Stack<Double>();
		 oprt = new Stack<Character>();
		 oprts = new HashMap<Character , Integer>();
		 
			oprts.put('(', Integer.MIN_VALUE);		 
			oprts.put('*', 4); 
			oprts.put('/', 3); 
			oprts.put('+', 2); 
			oprts.put('-', 1); 
	
	}
	
	private Double doProcess(Stack<Double> values, Stack<Character> operator) {
		Double result = 0.00;

		 System.out.println("Operands "+ values);
		 System.out.println("Operators "+ operator);
		 
		 Double op1 = values.pop();
		 Double op2 = values.pop(); 
		System.out.println("Operator 1 "+op1);
		System.out.println("Operator 2 "+op2);
		
		Character operate = operator.pop();
		
		switch(operate) {
			case '*':
				return op1 * op2;
			
			case '/':
				return op2/op1;								
			
			case '+':
				return op1 + op2;						
			
			case '-':
				return op1 - op2;
		}
		return result;
		
	}
	
	
	public Double evaluate(String s){
		
		char[] ch = s.toCharArray();
		
		Double result = 0.00;
		
		
		// Iterate
		for(char c : ch) {
			
			// If Operands, add into the stack
			if(!oprts.containsKey(c) && c != '(' && c != ')') {
				oprnd.push(Double.parseDouble((String.valueOf(c))));				
			}
			else if(oprts.containsKey(c)){
				if(oprt.empty()) oprt.push(c);
				else{
					int operatorRank = oprts.get(c);
					int stackTopRank = oprts.get(oprt.peek());
					if(operatorRank >= stackTopRank) oprt.push(c);
					if(operatorRank < stackTopRank) {
	                    Double output = doProcess(oprnd, oprt);
	                    oprnd.push(output);
						
						
					} 
				}
			}
			
			else if(c == ')' || c == '(') {
				if(c == '(') oprt.push(c);
				if(c == ')'){
					while(oprt.peek() != '(') {
	                    Double output = doProcess(oprnd, oprt);
	                    oprnd.push(output);					
	                    
					}
					if(oprt.peek() == '(') oprt.pop();
				}	
			}
			
		}
		
		  while(!oprt.isEmpty()){
              Double output = doProcess(oprnd, oprt);
              oprnd.push(output);					
              
		  }	        
		
		return oprnd.pop();
	}
	
	
	
	

}

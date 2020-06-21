package main.question5;

import java.util.Stack;

public class InfixPostFix {
	
	
	   private Stack theStack;
	   private String input;
	   private String output = "";
	   public InfixPostFix(String expression) {
	      input = expression;
	      int stackLength = input.length();
	      theStack = new Stack();
	   }
	   public String evaluate() {
	      for (int j = 0; j < input.length(); j++) {
	         char ch = input.charAt(j);
	         switch (ch) {
	            case '+': 
	            case '-':
	               getOperator(ch, 1); 
	               break; 
	            case '*': 
	            case '/':
	               getOperator(ch, 2); 
	               break; 
	            case '(': 
	               theStack.push(ch);
	               break;
	            case ')': 
	               gotParen(ch); 
	               break;
	            default: 
	               output = output + ch; 
	               break;
	         }
	      }
	      while (!theStack.isEmpty()) {
	         output = output + theStack.pop();
	      }

	      return output; 
	   }
	   public void getOperator(char opThis, int prec1) {
	      while (!theStack.isEmpty()) {
	         char opTop =(char)theStack.pop();
	         if (opTop == '(') {
	            theStack.push(opTop);
	            break;
	         } else {
	            int prec2;
	            if (opTop == '+' || opTop == '-')
	            prec2 = 1;
	            else
	            prec2 = 2;
	            if (prec2 < prec1) { 
	               theStack.push(opTop);
	               break;
	            } 
	            else output = output + opTop;
	         }
	      }
	      theStack.push(opThis);
	   }
	   public void gotParen(char ch) { 
	      while (!theStack.isEmpty()) {
	         char chx = (char)theStack.pop();
	         if (chx == '(') 
	         break; 
	         else output = output + chx; 
	      }
	   }
	   
	   
	   
	   // Evaluate PostFix function
	    private static boolean isOperator(char ch) {
	        return ch == '*' || ch == '/' || ch == '+' || ch == '-';
	    } 
	   
	    public Double evaluatePostfix(String exp) 
	    { 
	    	
	        Stack<Double> s = new Stack<Double>();

	        // Convert expression to char array
	        char[] chars = exp.toCharArray();

	        // Cache the length of expression
	        int N = chars.length;

	        for (int i = 0; i < N; i++) {
	            char ch = chars[i];

	            if (isOperator(ch)) {
	                // Operator, simply pop out two numbers from stack and perfom operation
	                // Notice the order of operands
	                switch (ch) {
	                    case '+': s.push(s.pop() + s.pop());     break;
	                    case '*': s.push(s.pop() * s.pop());     break;
	                    case '-': s.push(-s.pop() + s.pop());    break;
	                    case '/': s.push(1 / s.pop() * s.pop()); break;
	                }
	            } else if(Character.isDigit(ch)) {
	                // Number, push to the stack
	                s.push(0.0);
	                while (Character.isDigit(chars[i]))
	                    s.push(10.0 * s.pop() + (chars[i++] - '0'));
	            }
	        }

	        // The final result should be located in the bottom of stack
	        // Otherwise return 0.0
	        if (!s.isEmpty()) 
	            return s.pop();
	        else
	            return 0.0;
	    	
	    	
		    } 
}

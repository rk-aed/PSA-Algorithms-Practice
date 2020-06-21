package main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

import main.question1.MaxPQ;
import main.question1.MinPQ;
import main.question2.HuffmanCodeImpl;
import main.question2.HuffmanNode;
import main.question3.CircularQueue;
import main.question5.InfixPostFix;
import main.question6.User;


public class TestApp {

	
	public static void main(String args[]) {

		/*
		 * Question 1 MaxPQ MinPQ test
		 * 
		 */			
		
	       System.out.println("########################################## 1. MAX PQ AND MIN PQ  ############################################");
				
			// Enter the source path of the local	
			String sourcePath = "/Users/rohit/OneDrive/Desktop/inputData.txt";	
			ArrayList<Integer> digits  = readInputFile(sourcePath);
			
			
			MaxPQ maxPQ = new MaxPQ(20);
			MinPQ minPQ = new MinPQ(20);
			
			for(Integer digit  : digits) {
				maxPQ.insert(digit);
				minPQ.insert(digit);
			}
			
			System.out.println("Max PQ" + maxPQ.remove());
			System.out.println("Min PQ" + minPQ.remove());		
			

		    System.out.println("######################################################################################");		

		/*
		 * Question 2 Huffman code test
		 * 
		 */			
		    

		       System.out.println("########################################## 2. Huffman Compression  ############################################");
					
			HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
			String test = "There are sunny days, rainy days, and windy days";
			
			// Get the letters and their frequencies
			
			char[] letters = test.toCharArray();
			for(char c : letters) {
				
				if(hm.containsKey(c)) {
					int value = hm.get(c);
					value++;
					hm.put(c, value);
				}
				else {
					hm.put(c, 1);
				}
			}
			
			
			// Create Priority Queue for Huffman decompression
			
			
			PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>();
			
			Iterator<Entry<Character, Integer>> it = hm.entrySet().iterator(); // entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>) it.next();
				
				HuffmanNode hn = new HuffmanNode();
				hn.setC(pair.getKey());
				hn.setData(pair.getValue());
				hn.setLeft(null);
				hn.setRight(null);

				pq.add(hn);
			}
		
			HuffmanNode root = null;
			
			 // all the nodes are extracted. 
	        while (pq.size() > 1) { 
	  
	            HuffmanNode x = pq.peek(); 
	            pq.poll(); 
	  
	            HuffmanNode y = pq.peek(); 
	            pq.poll(); 
	  
	            HuffmanNode f = new HuffmanNode(); 
	  
	            // to the sum of the frequency of the two nodes 
	            // assigning values to the f node. 
	            f.data = x.data + y.data; 
	            f.c = '-'; 
	  
	            // first extracted node as left child. 
	            f.left = x; 
	  
	            // second extracted node as the right child. 
	            f.right = y; 
	  
	            // marking the f node as the root node. 
	            root = f; 

	            
	            // add this node to the priority-queue. 
	            pq.add(f); 
	        } 
	        

	        System.out.println(pq);
	  
	       System.out.println("######################################################################################");
	       
			
			
		/*
		 * Question 3 implementation test: Circular Queue
		 * 
		*/
	       
		    System.out.println("####################################### 3.Circular Queue ##############################################");
			ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(21, 18,  38, 3, 9, 82, 10, 31, 25, 29));
			CircularQueue cQueue = new CircularQueue(20);
			
			// Adding all elements into the circular queue
			for(Integer element : arr) {
				cQueue.enQueue(element);
			}
			
			// Displaying the circular queue
			cQueue.displayQueue();
		
			// Dequeue 3 elements
			int count = 3;
			while(count != 0)
			{
				System.out.println("element dequeued : "+cQueue.deQueue());
				count--;
			}
			
			// Displaying the circular queue
			cQueue.displayQueue();
			
			
			// Enqueue 2 elements
				cQueue.enQueue(99);
				cQueue.enQueue(100);
				
			// Displaying the circular queue
				cQueue.displayQueue();
			
				
				
			// Dequeue all 
				for(int i = 0; i < cQueue.getSize(); i++)
						cQueue.deQueue();
			
				
			// Displaying the circular queue
				cQueue.displayQueue();
				
				
				
			    System.out.println("######################################################################################");
				
		/*
		 * Question 5 implementation for Infix to PostFix
		 * 
		 */	
			    
			    
			System.out.println("########################################## 5. Infix to Postfix  ############################################");

			String exp = "(4+8)*(6-5)/((3- 2)*(2+2))";
			InfixPostFix infixPostfix = new InfixPostFix(exp);
			
			
			System.out.println("Infix Expression : "+exp);
			System.out.println("Postfix Expression : "+infixPostfix.evaluate());
		
		/*
		 * Question 5 evaluate PostFix
		 * 
		 */					
			
			System.out.println(infixPostfix.evaluatePostfix(infixPostfix.evaluate()));
			System.out.println("######################################################################################");
			
			

		/*
		 * Question 6 Test cases for User class
		 * 
		 */
			System.out.println("########################################## 6. Test cases for equals, compareTo, hashcode ############################################");

			User u1 = new User("ABC", 1, new Date());
			User u2 = new User("XYZ", 2, new Date());
			
			System.out.println("User 1 "+u1);
			System.out.println("User 2 "+u2);
			
			
			System.out.println("Equals method result : "+u1.equals(u2));
			System.out.println("Equals method result (for same user) : "+u1.equals(u2));
			
			
			System.out.println("CompareTo method result : "+u1.compareTo((u2)));
			System.out.println("CompareTo method result (for same user): "+u1.compareTo((u1)));
			
			System.out.println("Hashcode of u1 : "+u1.hashCode());
			System.out.println("Hashcode of u2 : "+u2.hashCode());
			System.out.println("######################################################################################");
			
			
			
		/*
		 * Question 7 
		 * 
		 */					
			System.out.println("########################################## 7. Hashcode of String ############################################");
				
			String s1 = "Welcome Students to Class";
			
			System.out.println("Hashcode for '"+s1+ "' below");
			System.out.println(s1.hashCode());							
			System.out.println("######################################################################################");
			
			
			
		
	}
	
	
	
	

	static public ArrayList<Integer> readInputFile(String sourcePath){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		
		Path path = Paths.get(sourcePath);
		Scanner scanner;
		try {
			scanner = new Scanner(path);
			
			//read line by line
			while(scanner.hasNextLine()){
				 String line = scanner.nextLine();
				 String[] digits = line.split(" ");
					 for(String s : digits)
						 {
							 Integer temp = Integer.parseInt(s);
						 	 result.add(temp);
						 }
			}
			
			scanner.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	
	}
	
	  
	
}

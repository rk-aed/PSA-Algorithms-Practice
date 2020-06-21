package workspace.main;

import java.util.ArrayList;

import workspace.main.question6.InfixEval;
import workspace.question5.ReadTxtFile;
import workspace.question5.Student;

public class TestQueues {
	
	public static void main(String Args[]) {
		
		
	// Read file
		ReadTxtFile txtFile = new ReadTxtFile();
		String sourcePath = "/Users/rohit/OneDrive/Desktop/input.txt";    // Please add the path of the input file. Input file is in the zip folder
		ArrayList<Student> allStudents = txtFile.read(sourcePath);	
		
		
		
	// Create objects of LLQueue, ArrayQueue	
		workspace.question5.LLQueue queue = new workspace.question5.LLQueue();
		workspace.question5.ArrayQueue queue1 = new workspace.question5.ArrayQueue(20);
	

	// Enqueue 3 elements into the queue
		for(int i = 0; i < 3; i++) {
			Student std = allStudents.get(i);
			queue.enqueue(std);
			queue1.enqueue(std);
		}
		
		
		
	// Dequeue 2 elements from the queue
		for(int i = 0; i < 2; i++) {
			queue.dequeue(); 
			queue1.dequeue(); 
		}
		
	// Dequeue all elements from the queue
		for(int i = 0; i < queue.size(); i++) {
			queue.dequeue();
		}
		
		for(int i = 0; i < queue1.size(); i++) {
			queue1.dequeue();
		}
		
		
	// Enqueue all elements into the queue	
		for(Student std : allStudents) {
			
			// Add into Linked List Queue
			queue.enqueue(std);
	
			// Add into Array Queue
			queue1.enqueue(std);

		}
		
		
		
		
		
	// Print the queues.
	System.out.println("####################################");
	System.out.println();
	System.out.println();
	System.out.println("Array Queue PrintAll Function");

	System.out.println();
	System.out.println();
	
	queue1.printAll();
	System.out.println("####################################");
	System.out.println();
	System.out.println();
	System.out.println("LinkedList Queue PrintAll Function");
	System.out.println();
	System.out.println();
	
	queue.printAll();
	
	System.out.println("####################################");	
	
	System.out.println();
	System.out.println();	
	System.out.println("Array Queue Reverse PrintAll Function");

	System.out.println();
	System.out.println();
	
	queue1.printAllReverse();
	
	System.out.println();
	System.out.println();

	System.out.println("LinkedList Queue Reverse PrintAll Function");
	System.out.println();
	System.out.println();

	queue.printAllReverse();		
	
		
	System.out.println("####################################");	
	
	System.out.println("####################################");	
	
	System.out.println("####################################");	
	
	System.out.println("####################################");	
	
	System.out.println("####################################");	
	
	System.out.println("####################################");	
	
	System.out.println("####################################");	
	
	
	
	
	InfixEval infixExp = new InfixEval();
	
	String s = "4+8*6-5/3-2*2+2";
	
	System.out.println(" Infix answer :  "+infixExp.evaluate(s));
	
	
	
	
	
	
	}
}

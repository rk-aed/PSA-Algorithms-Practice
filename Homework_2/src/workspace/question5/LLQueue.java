package workspace.question5;

import java.util.Collection;
import java.util.Stack;

public class LLQueue {
	
	private Node front, rear;
	private int size;
	
	private class Node
	{
		Student data;
		Node next;
		
	}
	
	public LLQueue() {
		this.front = null;
		this.rear = null;
		this.size = 0;
		System.out.println("Queue created");
		
	}
	
	public boolean isEmpty() {
		if(size == 0) {return true;} 
		else return false;
		
	}
	
	
	public void enqueue(Student data) {
		Node old = this.rear; 
		rear = new Node();
		this.rear.data = data;
		this.rear.next = null;
		if(isEmpty()) {
			front   = rear;
			
		}
		else		old.next = rear;
		size++;
		
		System.out.println(" "+ data+ " added to the queue.");
	}
	public Student dequeue() {
		Node takeOut = this.front;
		
		this.front = takeOut.next;
		 if (isEmpty()) 
		 {
			 rear = null;
		 }
		 size--;
		System.out.println(" "+ takeOut.data+ " removed from the queue.");
			
		return takeOut.data;
	}
	
	public Student peek() {
		
		return front.data;
	}
	
	
	// Print all elements
	public void printAll() {
		Node temp = front;
		while(temp != null)
		{
			System.out.println(" Student : "+temp.data);
			temp = temp.next;
		}
		
	}

	
	// Print all elements in reverse
	public void printAllReverse() {
		
        Stack<Student> stack = new Stack<>(); 
        Node temp = front;
        while(temp != null)
        	{
	        	stack.add(temp.data); 
	        	temp = temp.next;
        	}
        
        while (!stack.isEmpty()) { 
            System.out.println(stack.pop());
        } 
	
	}
	
	

	public int size() {
		int result = 0;
		Node temp = front;
		while(temp != null)
		{
			result++;
			temp = temp.next;
		}
		
		return result;
	}
	
	
	
	

}

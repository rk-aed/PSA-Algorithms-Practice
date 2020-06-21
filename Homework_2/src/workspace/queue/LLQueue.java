package workspace.queue;

public class LLQueue {
	
	private Node front, rear;
	private int size;
	
	private class Node
	{
		int data;
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
	
	
	public void enqueue(int data) {
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
	public int dequeue() {
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

}

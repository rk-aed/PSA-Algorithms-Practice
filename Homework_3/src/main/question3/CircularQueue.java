package main.question3;

public class CircularQueue {
	
	  int capacity; // Size of Circular Queue
	  int front, rear;
	  int arr[];
	  int size;

	  public CircularQueue(int size) {
	    front = -1;
	    rear = -1;
	    this.capacity = size;
	    this.size = 0;
	    this.arr = new int[capacity];
	    
	  }

	  public boolean isFull() {
	    if (front == 0 && rear == capacity - 1) {
	      return true;
	    }
	    if (front == rear + 1) {
	      return true;
	    }
	    return false;
	  }

	  public boolean isEmpty() {
	    if (front == -1)
	      return true;
	    else
	      return false;
	  }

	  // Adding an element
	  public void enQueue(int element) {
	    if (isFull()) {
	      System.out.println("Overflow");
	    } else {
	      if (front == -1)
	        front = 0;
	      rear = (rear + 1) % capacity;
	      arr[rear] = element;
	      this.size++;
	      System.out.println("Element Inserted " + element);
	    }
	  }


	  public int deQueue() {
	    int element;
	    if (isEmpty()) {
	      System.out.println("Underflow");
	      return -1;
	    } else {
	      element = arr[front];
	      if (front == rear) {
	        front = -1;
	        rear = -1;
	      } 
	      else {
	        front = (front + 1) % capacity;
	      }
	      this.size--;
	      return (element);
	    }
	  }

	  public  void displayQueue() {
	    int i;
	    if (isEmpty()) {
	      System.out.println("Empty Queue");
	    } else {
	      for (i = front; i != rear; i = (i + 1) % capacity)
	        System.out.print(arr[i] + " ");
	      System.out.println(arr[i]);
	    }
	  }

	public int getSize() {
		return size;
	}


}

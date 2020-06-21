package workspace.question5;

import java.util.Stack;

public class ArrayQueue {
	
	Student arrQueue[];
	int front, rear, currSize, capacity;
	
	public ArrayQueue(int size){
		this.capacity = size;
		front = 0;
		rear = -1;
		arrQueue = new Student[capacity];
		this.currSize = 0;
		
	}
	
	
	public boolean isEmpty() {
		if(currSize == 0) {
			return true;
		}else return false;
	}
	
	public boolean isFull() {
		if (currSize == capacity) {
			return true;
		}
		return false;
	}
	
	
	public void enqueue(Student data) {
		if (isFull()) {
			System.out.println("Queue is full!! Can not add more elements");
		} else {
			rear++;
			if (rear == capacity - 1) {
				rear = 0;
			}
			arrQueue[rear] = data;
			currSize++;
			System.out.println(data + " added to the queue");
		}
	}
	
	
	
	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty!! Can not dequeue element");
		} else {
			front++;
			if (front == capacity - 1) {
				System.out.println(arrQueue[front - 1] + " removed from the queue");
				front = 0;
			} else {
				System.out.println(arrQueue[front - 1] + " removed from the queue");
			}
			currSize--;
		}
	}
	
	
	public void printAll() {
		for(Student std : arrQueue) {
			if(std != null)
				System.out.println(std);
		}
	}
	
	public void printAllReverse() {
		Stack<Student> stk = new Stack<>();
		
		for(Student std : arrQueue) {
			if(std != null)
				stk.add(std);
		}
		
		while(stk.size() != 0)
			System.out.println(stk.pop());
		
	}	
	
	public int size() {
		return currSize;
	}
}

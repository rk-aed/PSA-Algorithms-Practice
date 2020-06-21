package main.question2;

import java.util.Comparator;

public class HuffmanNode implements Comparable<HuffmanNode> {
    public int data; 
    public char c; 
    public HuffmanNode left; 
    public HuffmanNode right;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public char getC() {
		return c;
	}
	public void setC(char c) {
		this.c = c;
	}
	public HuffmanNode getLeft() {
		return left;
	}
	public void setLeft(HuffmanNode left) {
		this.left = left;
	}
	public HuffmanNode getRight() {
		return right;
	}
	public void setRight(HuffmanNode right) {
		this.right = right;
	}

    
	class MyComparator implements Comparator<HuffmanNode> { 
	    public int compare(HuffmanNode x, HuffmanNode y) 
	    { 
	        return x.data - y.data; 
	    } 
	}


	@Override
	public int compareTo(HuffmanNode y) {
		// TODO Auto-generated method stub
		return data - y.data;
	}
	@Override
	public String toString() {
		return "HuffmanNode [data=" + data + ", c=" + c + ", left=" + left + ", right=" + right + "]";
	} 
    

}

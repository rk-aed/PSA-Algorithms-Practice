package question5;


/*
 * Referred this https://youtu.be/CROCIVMKlRc youTube video for the code
 * 
 */

class NodeData1 {
	private long key;
	
	public long getKey() { return key; }
	public void setKey(long key) { this.key = key; }
	//Simple constructor
	public NodeData1(long keyval) { this.key = keyval; }
	//Method that displays the key used for printing only
	public String displayItem() { return ("[" + getKey() + "]"); }
}

class Node2 {
	//Controls the number the number of children per Node2.
	private static final int MAX_CHILDREN = 4;
	private static final int MAX_ITEMS_PER_Node2 = MAX_CHILDREN - 1;
	private Node2 parent;
	//Array that stores all pointer(s) to child/children
	private Node2 childArray [] = new Node2[MAX_CHILDREN];
	//Each Node2 will contain a number of items equal to the number of children - 1
	private NodeData1 itemArray [] = new NodeData1[MAX_ITEMS_PER_Node2];
	//Number of item(s) currently stored
	private int numItems;

	//Useful methods for dealing with numItems
	public int getNumItems() { return numItems; }
	public void increaseItemNum() { numItems++; }
	public void decreaseItemNum() { numItems--; }
	//Useful methods to do work on childArray
	public Node2 getChild(int childNum) { return childArray[childNum]; }
	public void setChild(int childNum, Node2 child) { childArray[childNum] = child; }
	//Useful methods for dealing with itemArray
	public NodeData1 getItem(int index) { return itemArray[index]; }
	public void setItem(int index, NodeData1 item) { itemArray[index] = item; }
	public boolean isItemNull(int index) { return (itemArray[index] == null) ? true : false; }
	//Useful methods to retrieve child, parent and check whether the Node2 is a leaf
	public Node2 getParent() { return parent; }
	public boolean isLeaf() { return (getChild(0) == null) ? true : false; }
	public boolean isFull() { return (getNumItems() == MAX_ITEMS_PER_Node2) ? true : false; }
	
	//Connect child to this Node2
	public void connectChild(int childNum, Node2 child) {
		//Update the pointers array
		setChild(childNum, child);
		//If the child exists, have the child pointing at this Node2
		//The two Node2s will now be connected
		if(child != null) child.parent = this;
	}

	//Disconnect child from this Node2
	public Node2 disconnectChild(int childNum) {
		//Get a pointer to the child that has to be disconnected
		Node2 tempNode2 = getChild(childNum);
		//Remove the pointer to this child from the arrays
		setChild(childNum, null);
		//Return the pointer at the deleted item which still exists in memory
		return tempNode2;
	}

	//If found, return index of item within Node2 
	public int findItem(long key) {
		for(int x = 0; x < MAX_ITEMS_PER_Node2; x++) {
			//Exit now as no more items in this Node2
			if(isItemNull(x)) break;
			//Check whether this is the right key 
			else if(getItem(x).getKey() == key)
			//Return the index of the found item
			return x;
		}
		//Could not find the item
		return -1;
	}  
	
	public int insertItem(NodeData1 newItem) {
		//Assuming the Node2 is not full, increase the counter
		increaseItemNum();
		// Start on the right, analyze items
		for(int x = MAX_ITEMS_PER_Node2 - 1; x >= 0; x--) {
			//If item is null, move left one cell
			if(isItemNull(x)) continue;
			//Not null therefore get the key
			else {
				//If the new item is smaller, move the old item right to make some place
				if(newItem.getKey() < getItem(x).getKey()) setItem(x + 1, getItem(x));
				//They are already sorted, do insert
				else {
					setItem(x + 1, newItem);
					//Return the index of the new item
					return x + 1;
				}
			}
		}
		//First item in this Node2
		setItem(0, newItem);
		//Return the index of the new item
		return 0;
	}

	//Remove the largest item
	public NodeData1 removeItem() {
		//Assuming the Node2 is empty, save the item
		NodeData1 temp = getItem(getNumItems() - 1);
		//Disconnect the item
		setItem(getNumItems() - 1, null);
		//Decrease the counter
		decreaseItemNum();
		
		return temp;
	}
	
	public String displayNode2() {
		String x = new String("");
		for(int Node2 = 0; Node2 < getNumItems(); Node2++) x = x + getItem(Node2).displayItem();
		
		return x;
	}
}

public class Tree234 {
	private Node2 root;
	//Get and set for the root Node2
	public Node2 getRoot() { return root; }
	public void setRoot(Node2 root) { this.root = root; }
	
	//A simple constructor
	public Tree234() { this.root = new Node2(); }
	
	public int find(long key) {
		//Pointer used during the search starting from rot
		Node2 curNode2 = getRoot();
		//Child bookmark
		int childNumber;

		while(true) {
			// Return the child number...
			if((childNumber = curNode2.findItem(key)) != -1) return childNumber;
			//If end of tree reached returned error
			else if(curNode2.isLeaf()) return -1;		
			//Move to the next children
			else curNode2 = getNextChild(curNode2, key);
		}
	}

	// insert a NodeData1
	public void insert(long dValue) {
		Node2 curNode2 = getRoot();
		NodeData1 tempItem = new NodeData1(dValue);

		while(true) {
			// If the Node2 is full do the split
			if(curNode2.isFull()) {
				split(curNode2);
				// Back up
				curNode2 = curNode2.getParent();
				// Search once
				curNode2 = getNextChild(curNode2, dValue);
            		}
            		// If this is a leaf do the insert
            		else if(curNode2.isLeaf()) break;
            		// Neither a leaf nor full hence go to lower level
            		else curNode2 = getNextChild(curNode2, dValue);
        	}
		curNode2.insertItem(tempItem);
	}

	public void split(Node2 oldNode2ForSplit) {
    		//Assuming the Node2 is full, two pointers at 'B' and 'C' items are prepared
		NodeData1 bItem;
		NodeData1 cItem;
		//Parent Node2
		Node2 parent;
		//Assuming the Node2 is full, two pointers at the two rightmost children are
		//prepared
		Node2 child2;
		Node2 child3;
		//Index of items used later on
		int itemIndex;
		//Regardless whether or not root is being split, item 'C' and 'B' have to be
		//disconnected
		cItem = oldNode2ForSplit.removeItem();
		bItem = oldNode2ForSplit.removeItem();
		//Regardless whether or not root is being split, the two rightmost children
		//have to be disconnected
		child2 = oldNode2ForSplit.disconnectChild(2);
		child3 = oldNode2ForSplit.disconnectChild(3);
		//Create a new Node2 that will be used by the split. Item 'C' will move here
		//regardless whether or not root is being split
		Node2 newNode2ForSplit = new Node2();

		//If this is the root, create a new Node2, promote and connect it
		if(oldNode2ForSplit == getRoot()) {
			//Create a new Node2
			setRoot(new Node2());
			//The new root becomes the parent of the current Node2
			parent = getRoot();
			//Connect the new root to the old root
			root.connectChild(0, oldNode2ForSplit);
		}
		//This is not the root hence grab the parent of this Node2
		else parent = oldNode2ForSplit.getParent();
		
		//Always move 'B' up (root/non-root) 
		itemIndex = parent.insertItem(bItem);
		
		//Make some space for the new children
		//Move parent's connections one child to the right
		for(int itemN = parent.getNumItems() - 1; itemN > itemIndex; itemN--) {
			Node2 temp = parent.disconnectChild(itemN);
			parent.connectChild(itemN + 1, temp);
		}
		//Connect newNode2ForSplit to parent
		parent.connectChild(itemIndex + 1, newNode2ForSplit);
		//Always insert 'C' into the new Node2 (root/non-root split)
		newNode2ForSplit.insertItem(cItem);
		//Connect child 2
		newNode2ForSplit.connectChild(0, child2);
		//Connect child 3
		newNode2ForSplit.connectChild(1, child3);
	}

	public Node2 getNextChild(Node2 theNode2, long theValue) {
		//If less, return left child. 
		int k;
		for(k = 0; k < theNode2.getNumItems(); k++)
			if(theValue < theNode2.getItem(k).getKey()) return theNode2.getChild(k);
		//Return the right one otherwise
		return theNode2.getChild(k);
	}

}

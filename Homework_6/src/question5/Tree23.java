package question5;


/*
 * Referred this https://youtu.be/CROCIVMKlRc youTube video for the code
 * 
 */

class NodeData {
	private long key;
	
	public long getKey() { return key; }
	public void setKey(long key) { this.key = key; }
	//Simple constructor
	public NodeData(long keyval) { this.key = keyval; }
	//Method that displays the key used for printing only
	public String displayItem() { return ("[" + getKey() + "]"); }
}

class Node {
	//Controls the number the number of children per node.
	private static final int MAX_CHILDREN = 3;
	private static final int MAX_ITEMS_PER_NODE = MAX_CHILDREN - 1;
	private Node parent;
	//Array that stores all pointer(s) to child/children
	private Node childArray [] = new Node[MAX_CHILDREN];
	//Each node will contain a number of items equal to the number of children - 1
	private NodeData itemArray [] = new NodeData[MAX_ITEMS_PER_NODE];
	//Number of item(s) currently stored
	private int numItems;

	//Useful methods for dealing with numItems
	public int getNumItems() { return numItems; }
	public void increaseItemNum() { numItems++; }
	public void decreaseItemNum() { numItems--; }
	//Useful methods to do work on childArray
	public Node getChild(int childNum) { return childArray[childNum]; }
	public void setChild(int childNum, Node child) { childArray[childNum] = child; }
	//Useful methods for dealing with itemArray
	public NodeData getItem(int index) { return itemArray[index]; }
	public void setItem(int index, NodeData item) { itemArray[index] = item; }
	public boolean isItemNull(int index) { return (itemArray[index] == null) ? true : false; }
	//Useful methods to retrieve child, parent and check whether the node is a leaf
	public Node getParent() { return parent; }
	public boolean isLeaf() { return (getChild(0) == null) ? true : false; }
	public boolean isFull() { return (getNumItems() == MAX_ITEMS_PER_NODE) ? true : false; }
	
	//Connect child to this node
	public void connectChild(int childNum, Node child) {
		//Update the pointers array
		setChild(childNum, child);
		//If the child exists, have the child pointing at this node
		//The two nodes will now be connected
		if(child != null) child.parent = this;
	}

	//Disconnect child from this node
	public Node disconnectChild(int childNum) {
		//Get a pointer to the child that has to be disconnected
		Node tempNode = getChild(childNum);
		//Remove the pointer to this child from the arrays
		setChild(childNum, null);
		//Return the pointer at the deleted item which still exists in memory
		return tempNode;
	}

	//If found, return index of item within node 
	public int findItem(long key) {
		for(int x = 0; x < MAX_ITEMS_PER_NODE; x++) {
			//Exit now as no more items in this node
			if(isItemNull(x)) break;
			//Check whether this is the right key 
			else if(getItem(x).getKey() == key)
			//Return the index of the found item
			return x;
		}
		//Could not find the item
		return -1;
	}  
	
	public int insertItem(NodeData newItem) {
		//Assuming the node is not full, increase the counter
		increaseItemNum();
		// Start on the right, analyze items
		for(int x = MAX_ITEMS_PER_NODE - 1; x >= 0; x--) {
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
		//First item in this node
		setItem(0, newItem);
		//Return the index of the new item
		return 0;
	}

	//Remove the largest item
	public NodeData removeItem() {
		//Assuming the node is empty, save the item
		NodeData temp = getItem(getNumItems() - 1);
		//Disconnect the item
		setItem(getNumItems() - 1, null);
		//Decrease the counter
		decreaseItemNum();
		
		return temp;
	}
	
	public String displayNode() {
		String x = new String("");
		for(int node = 0; node < getNumItems(); node++) x = x + getItem(node).displayItem();
		
		return x;
	}
}

public class Tree23 {
	private Node root;
	//Get and set for the root node
	public Node getRoot() { return root; }
	public void setRoot(Node root) { this.root = root; }
	
	//A simple constructor
	public Tree23() { this.root = new Node(); }
	
	public int find(long key) {
		//Pointer used during the search starting from rot
		Node curNode = getRoot();
		//Child bookmark
		int childNumber;

		while(true) {
			// Return the child number...
			if((childNumber = curNode.findItem(key)) != -1) return childNumber;
			//If end of tree reached returned error
			else if(curNode.isLeaf()) return -1;		
			//Move to the next children
			else curNode = getNextChild(curNode, key);
		}
	}

	// insert a NodeData
	public void insert(long dValue) {
		Node curNode = getRoot();
		NodeData tempItem = new NodeData(dValue);

		while(true) {
			// If the node is full do the split
			if(curNode.isFull()) {
				split(curNode);
				// Back up
				curNode = curNode.getParent();
				// Search once
				curNode = getNextChild(curNode, dValue);
            		}
            		// If this is a leaf do the insert
            		else if(curNode.isLeaf()) break;
            		// Neither a leaf nor full hence go to lower level
            		else curNode = getNextChild(curNode, dValue);
        	}
		curNode.insertItem(tempItem);
	}

	public void split(Node oldNodeForSplit) {
    		//Assuming the node is full, two pointers at 'B' and 'C' items are prepared
		NodeData bItem;
		NodeData cItem;
		//Parent node
		Node parent;
		//Assuming the node is full, two pointers at the two rightmost children are
		//prepared
		Node child2;
		Node child3;
		//Index of items used later on
		int itemIndex;
		//Regardless whether or not root is being split, item 'C' and 'B' have to be
		//disconnected
		cItem = oldNodeForSplit.removeItem();
		bItem = oldNodeForSplit.removeItem();
		//Regardless whether or not root is being split, the two rightmost children
		//have to be disconnected
		child2 = oldNodeForSplit.disconnectChild(2);
		child3 = oldNodeForSplit.disconnectChild(3);
		//Create a new node that will be used by the split. Item 'C' will move here
		//regardless whether or not root is being split
		Node newNodeForSplit = new Node();

		//If this is the root, create a new node, promote and connect it
		if(oldNodeForSplit == getRoot()) {
			//Create a new node
			setRoot(new Node());
			//The new root becomes the parent of the current node
			parent = getRoot();
			//Connect the new root to the old root
			root.connectChild(0, oldNodeForSplit);
		}
		//This is not the root hence grab the parent of this node
		else parent = oldNodeForSplit.getParent();
		
		//Always move 'B' up (root/non-root) 
		itemIndex = parent.insertItem(bItem);
		
		//Make some space for the new children
		//Move parent's connections one child to the right
		for(int itemN = parent.getNumItems() - 1; itemN > itemIndex; itemN--) {
			Node temp = parent.disconnectChild(itemN);
			parent.connectChild(itemN + 1, temp);
		}
		//Connect newNodeForSplit to parent
		parent.connectChild(itemIndex + 1, newNodeForSplit);
		//Always insert 'C' into the new node (root/non-root split)
		newNodeForSplit.insertItem(cItem);
		//Connect child 2
		newNodeForSplit.connectChild(0, child2);
		//Connect child 3
		newNodeForSplit.connectChild(1, child3);
	}

	public Node getNextChild(Node theNode, long theValue) {
		//If less, return left child. 
		int k;
		for(k = 0; k < theNode.getNumItems(); k++)
			if(theValue < theNode.getItem(k).getKey()) return theNode.getChild(k);
		//Return the right one otherwise
		return theNode.getChild(k);
	}

}

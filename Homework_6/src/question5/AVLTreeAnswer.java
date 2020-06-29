package question5;

import question5.AVLTree.Node;

public class AVLTreeAnswer {
    private int key;
    private NodeAVL leftNode;
    private NodeAVL rightNode;
    private int height = 1;
    

    public AVLTreeAnswer(int key, NodeAVL leftNode, NodeAVL rightNode) {
        this.key = key;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }   
    
    

    public AVLTreeAnswer(int key){
	        this.key = key;
	 }
	 public int getKey() {
	        return key;
	 }
	 public NodeAVL getLeftNode() {
	        return leftNode;
	 }
	 public NodeAVL getRightNode() {
	        return rightNode;
	 }
	 public void setKey(int key) {
	        this.key = key;
	 }
	 public void setLeftNode(NodeAVL leftNode) {
	        this.leftNode = leftNode;
	 }

	 public void setRightNode(NodeAVL rightNode) {
	        this.rightNode = rightNode;  
	 
	 }
	


	 
	 
	 
	// Define AVL Node
	private class NodeAVL{
		int value;
		NodeAVL left;
		NodeAVL right;
		int height = 1;
		NodeAVL(int value){
			this.value = value;
			this.left= null;
			this.right=null;
			
		}
		
		
		}
		
		/*
		 * Insert Function
		 */
		
	    public NodeAVL insert(NodeAVL node, int value) {
	    	
	        /* 1.  Perform the normal BST rotation */
	        if (node == null) {
	            return(new NodeAVL(value));
	        }

	        if (value < node.value)
	            node.left  = insert(node.left, value);
	        else
	            node.right = insert(node.right, value);

	        /* 2. Update height of this ancestor node */
	        node.height = Math.max(height(node.left), height(node.right)) + 1;

	        /* 3. Get the balance factor of this ancestor node to check whether
	           this node became unbalanced */
	        int balance = getBalance(node);

	        // If this node becomes unbalanced, then there are 4 cases

	        // Left Left Case
	        if (balance > 1 && value < node.left.value)
	            return rightRotate(node);

	        // Right Right Case
	        if (balance < -1 && value > node.right.value)
	            return leftRotate(node);

	        // Left Right Case
	        if (balance > 1 && value > node.left.value)
	        {
	            node.left =  leftRotate(node.left);
	            return rightRotate(node);
	        }

	        // Right Left Case
	        if (balance < -1 && value < node.right.value)
	        {
	            node.right = rightRotate(node.right);
	            return leftRotate(node);
	        }

	        /* return the (unchanged) node pointer */
	        return node;
	    }

	    private NodeAVL rightRotate(NodeAVL y) {
	    	NodeAVL x = y.left;
	    	NodeAVL T2 = x.right;

	        // Perform rotation
	        x.right = y;
	        y.left = T2;

	        // Update heights
	        y.height = Math.max(height(y.left), height(y.right))+1;
	        x.height = Math.max(height(x.left), height(x.right))+1;

	        // Return new root
	        return x;
	    }

	    private NodeAVL leftRotate(NodeAVL x) {
	        NodeAVL y = x.right;
	        NodeAVL T2 = y.left;

	        // Perform rotation
	        y.left = x;
	        x.right = T2;

	        //  Update heights
	        x.height = Math.max(height(x.left), height(x.right))+1;
	        y.height = Math.max(height(y.left), height(y.right))+1;

	        // Return new root
	        return y;
	    }

	    // Get Balance factor of node N
	    private int getBalance(NodeAVL N) {
	        if (N == null)
	            return 0;
	        return height(N.left) - height(N.right);
	    }

		
	    private int height (NodeAVL N) {
	        if (N == null)
	            return 0;
	        return N.height;
	    }		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}

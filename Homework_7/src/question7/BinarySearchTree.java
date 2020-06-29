package question7;


public class BinarySearchTree { 
	Node root; 
	class Node { 
		int key; 
		Node left, right; 

		public Node(int item) { 
			key = item; 
			left = right = null; 
		} 
	} 


	public BinarySearchTree() { 
		root = null; 
	} 

	public void insert(int key) { 
	root = insertRec(root, key); 
	} 
	
	Node insertRec(Node root, int key) { 

		/* If the tree is empty, return a new node */
		if (root == null) { 
			root = new Node(key); 
			return root; 
		} 

		if (key < root.key) 
			root.left = insertRec(root.left, key); 
		else if (key > root.key) 
			root.right = insertRec(root.right, key); 
		return root; 
	} 

	public void inorder() { 
		inorderRec(root); 
	} 

	void inorderRec(Node root) { 
		if (root != null) { 
			inorderRec(root.left); 
			System.out.print(root.key+" "); 
			inorderRec(root.right); 
		} 
	} 

	public void preorder() { 
		preorder(root); 
	} 

	void preorder(Node root) { 
		if (root != null) { 
			System.out.print(root.key+" "); 
			preorder(root.left); 
			preorder(root.right); 
		} 
	} 

	
	

	public void postorder() { 
		postorder(root); 
	} 

	void postorder(Node root) { 
		if (root != null) { 
			postorder(root.left); 
			postorder(root.right); 
			System.out.print(root.key+" ");
		} 

	} 

		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} 

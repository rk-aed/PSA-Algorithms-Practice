package question5;

public class BST {
	
	
	int count = 0;

	
	public class Node{
		int key;
		Node left;
		Node right;
		
		Node(int data){
			this.key = data;
			this.left = null;
			this.right = null;
		}
		
		
	}
	
	
	// Insert
	public Node insert(Node root, int key) {
		Node newNode = new Node(key);
		
		if(root == null) {
			count++;
			return newNode;	
		}
		else 
		{
			if(key < root.key) {
				root.left = insert(root.left, key);
			}
			else {
				root.right = insert(root.right, key);				
			}
		}
		return root;
		}
	
	
	// Display
	public void inOrderTraversal(Node root) {
		if(root != null) {
			inOrderTraversal(root.left);
			System.out.print(" "+root.key);
			inOrderTraversal(root.right);
		}

	}
	

	/*
	 * Question 4 j)
	 */
	
	//search a key
		public Node search(Node node, int key){
			
			if(node == null || node.key == key){
				return node;
			}
			if(key<node.key){
					return search(node.left,key);
			}
			return search(node.right, key);
			
			
		}
		
		//search min key
		public Node searchMin(Node node){
			
			if(node.left == null){
				return node;
			}
			return searchMin(node.left);
			
		}
		
		//search max key
		public Node searchMax(Node node){
			
			if(node.right == null){
				return node;
			}
			return searchMax(node.right);
			
		}
		
		public Node delete(Node root, int key){
			
			if(root == null){return root;}
			
			
			if(key<root.key){
				root.left = delete(root.left,key);
				
			}
			
			else if(key>root.key){
				root.right = delete(root.right,key);
			}
			
			else{
				
				//if node has one child or no child
				if(root.left == null){
					Node temp = root.right;
					count--;
					return temp;
				}
				else if(root.right == null){
					Node temp = root.left;
					count--;
					return temp;
				}
				
				//if not a leaf node, find the next inorder successor
				//replace the current node with its next inorder successor
				//delete the inorder successor
				else{
					Node temp = searchMin(root.right);
					root.key = temp.key;
					 delete(root.right, temp.key);
					 count--;
				}
			}
			
			return root;
		}
		
		//delete minimum element in the tree
		public Node deleteMin(Node root){
			
			if(root == null){
				return root;
			}
			count--;
			return delete(root,searchMin(root).key);
		}
		
		public Node deleteMax(Node root){
			
			if(root == null){
				return root;
			}
			count--;
			return delete(root,searchMax(root).key);
		}
		
	
	
	
}


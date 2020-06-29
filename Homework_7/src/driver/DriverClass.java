package driver;

import btree.Btree;
import question1.AdjList;
import question6.DirGraph;
import question7.BinarySearchTree;

public class DriverClass {
	
	public static void main(String args[]) {
		
		/*
		 * Question 1
		 */
		System.out.println("#################################");		
		System.out.println("Question 1 : Undirected Graph");
		System.out.println("#################################");		
		
		
		// Create Graph Object
		AdjList graph = new AdjList(10);
		
		// Add Edges
		graph.addEdge(5, 6);
		graph.addEdge(4, 6);
		graph.addEdge(3, 7);
		graph.addEdge(6, 7);
		graph.addEdge(5, 7);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);
		graph.addEdge(2, 3);
		graph.addEdge(4, 7);
		graph.addEdge(4, 8);
		graph.addEdge(5, 9);
		
		// Print
		System.out.println(graph);
	
		
		/*
		 * Question 2
		 */
		System.out.println("#################################");		
		System.out.println("Question 2 : DFS");
		System.out.println("#################################");		
		
		
		System.out.println("DFS : ");
		graph.DFS(1);
		

		System.out.println("\n\n#################################");		
		System.out.println("Question 3 : BFS");
		System.out.println("#################################");		
		
		
		System.out.println("BFS : ");
		graph.BFS(1);
		
		

		System.out.println("\n\n#################################");		
		System.out.println("Question 6 : Directed Graph Adjacency List");
		System.out.println("#################################");		
		
		// Creating a new object of the same class created for question 1, using new edges.
		
		DirGraph graph1 = new DirGraph(13);
		
		graph1.addEdge(0, 1);
		graph1.addEdge(0, 5);
		graph1.addEdge(2, 0);
		graph1.addEdge(6, 0);
		graph1.addEdge(3, 2);
		graph1.addEdge(2, 3);
		graph1.addEdge(4, 2);
		graph1.addEdge(5, 4);
		graph1.addEdge(3, 5);
		graph1.addEdge(4, 3);
		graph1.addEdge(11, 4);
		graph1.addEdge(6, 4);
		graph1.addEdge(6, 8);
		graph1.addEdge(8, 6);
		graph1.addEdge(7, 6);
		graph1.addEdge(7, 9);
		graph1.addEdge(9, 10);
		graph1.addEdge(9, 11);
		graph1.addEdge(6, 9);
		graph1.addEdge(12, 9);
		graph1.addEdge(11, 12);
		graph1.addEdge(10, 12);
		
		
		System.out.println(graph1);
		
		
		System.out.println("\n\n#################################");		
		System.out.println("Question 7 : Binary Search Tree - Traversals");
		System.out.println("#################################");		
		
		BinarySearchTree tree = new BinarySearchTree(); 

		tree.insert(42); 
		tree.insert(12); 
		tree.insert(53); 
		tree.insert(8); 
		tree.insert(2); 
		tree.insert(16); 
		tree.insert(22); 
		tree.insert(19);
		tree.insert(60);
		tree.insert(57);
		tree.insert(65);

		// print inorder traversal of the BST 
		System.out.println("\n\nIn Order Traversal : ");
		tree.inorder();
		
		
		// print preorder traversal of the BST 
		
		System.out.println("\n\nPre Order Traversal : ");
		tree.preorder();
		
		
		// print postorder traversal of the BST 
		System.out.println("\n\nPost Order Traversal : ");
		tree.postorder();
		
		
		
		System.out.println("\n\n#################################");		
		System.out.println("Question 8 : B-Tree - Order 4");
		System.out.println("#################################");		
		
			Btree t = new Btree(4); // A B-Tree with minium degree 3 
		   
		    t.insert(3); 
		    t.insert(7); 
		    t.insert(9); 
		    t.insert(23); 
		    t.insert(45); 
		    t.insert(1); 
		    t.insert(5); 
		    t.insert(14); 
		    t.insert(5);  
		    t.insert(24); 
		    t.insert(13); 
		    t.insert(11); 
		    t.insert(8); 
		    t.insert(19); 
		    t.insert(4); 
		    t.insert(31); 
		    t.insert(35); 
		    
		    t.insert(131);
		    t.insert(56); 
		    t.insert(17); 
		    t.insert(29); 
		    t.insert(6);  
		    t.insert(22);
		  
		    System.out.println("Constructing Btree (order 4) : ");
		    t.traverse();
		    
		    
		    System.out.println("After deleting the elements 45, 11, 31, 4 : ");
		    t.remove(45);
		    t.remove(11);		    
		    t.remove(31);		    
		    t.remove(4);		
	
		    t.traverse();	
		    
		    System.out.println("\n\n#################################");		
			System.out.println("Question 9 : B-Tree - Order 5");
			System.out.println("#################################");		
			
				question9.Btree c = new question9.Btree(4); // A B-Tree with minium degree 3 
			   
			    c.insert('A'); 
			    c.insert('G'); 
			    c.insert('F'); 
			    c.insert('B'); 
			    c.insert('K'); 
			    c.insert('D'); 
			    c.insert('H'); 
			    c.insert('M'); 
			    c.insert('I');
			    c.insert('E');
			    c.insert('S');
			    c.insert('T');
			    c.insert('R');
			    c.insert('X');
			    c.insert('C');
			    c.insert('L');
			    c.insert('N');	 
			    c.insert('T');
			    c.insert('U');
			    c.insert('P');
			    
			
			     System.out.println("Constructing Btree (order 5) : ");
			     c.traverse();
		
			     System.out.println("After deleting elements E, F, M : ");
			     c.remove('E');
			     c.remove('F');
			     c.remove('M');
			     c.traverse();
		
		
	}
	
	

}

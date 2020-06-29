package driver;

import javax.swing.plaf.basic.BasicTreeUI;

import question1.StringReversal;
import question2.StringSort;
import question5.AVLTree;
import question5.BST;
import question5.BTree234Trail;
import question5.BST.Node;
import question5.Tree23;
import question5.Tree234;

public class DriverClass {
	
	public static void main(String[] args) {
		
		
		System.out.println("######################################");
		System.out.println("Question 1");
		StringReversal sr = new StringReversal();
		String t = "BooksToRead";
		System.out.println(" Reverse String, input "+t);
		long start = System.nanoTime();
		String s = sr.stringRev(t);
		long end = System.nanoTime();
		long revTime = (end-start);
		System.out.println(" Answer : "+s);
		System.out.println(" Reverse String method, time taken, (nano time) : "+revTime);
		
		

		String t1 = "BooksToRead";
		System.out.println(" Reverse StringBuilder, input "+t1);
		start = System.nanoTime();
		String s1 = sr.stringBuilderRev(t1);
		end = System.nanoTime(); // nanoTime();
		long revBuilderTime = (end-start);
		System.out.println(" Answer : "+s1);
		System.out.println(" Reverse StringBuilder method, time taken, (nano time) : "+revBuilderTime);
		
		
		
		/*
		 * Question 2
		 */
		System.out.println("\n\n\n######################################");	
		System.out.println("Question 2");
		
		question2.StringSort ss = new StringSort();
		System.out.println("Input : abdcceddfcabbeddccefddaaf");
		start = System.nanoTime();
		System.out.println("\nKey Indexed Sort : "+ss.keyIndexedSort("abdcceddfcabbeddccefddaaf"));
		end = System.nanoTime();
		long keyIndexedSortTime = (end-start);


		start = System.nanoTime();
		System.out.println("\nSelection Sort : "+ss.sortBySS("abdcceddfcabbeddccefddaaf"));
		end = System.nanoTime();
		long selectionSortTime = (end-start);

/*
		s  = "abdcceddfcabbeddccefddaaf";
		char[] ch  = s.toCharArray();
		start = System.nanoTime();
		char[] cc = ss.keyIndexedSort(ch);
		end = System.nanoTime();
		System.out.println("\nKey Char indexed Sort : "+String.valueOf(cc));
		long keyCharSortTime = (end-start);

				
		
		
		s  = "abdcceddfcabbeddccefddaaf";
		ch  = s.toCharArray();
		start = System.nanoTime();
		cc = ss.sortBySS(ch);
		end = System.nanoTime();
		System.out.println("\nSelection Char indexed Sort : "+String.valueOf(cc));
		long ssCharSortTime = (end-start);
		
	*/		
		System.out.println("\n\n(1) Key-Indexed Sorting time taken (nano time) : "+keyIndexedSortTime);
		
		System.out.println("\n\n(2) Selection-Sorting time taken (nano time) : "+selectionSortTime);
		
//		System.out.println("\n\n(3) (Char) Key-Indexed Sorting time taken (nano time) : "+keyCharSortTime);
		
//		System.out.println("\n\n(4) (Char) Selection-Sorting time taken (nano time) : "+ssCharSortTime);
		
		
		System.out.println("################################################");
				
		
		/*
		 * Question 5
		 */
		
		System.out.println("\n\nQuestion 5 ");
		
		
		int[] data = {9,23,45,1,5,14,55,24,13,11,8,19,4,31,35,56};
		System.out.println("\nInput Data : ");
		
		for(int i : data) {
			System.out.print(" "+i);
			
		}
		
		// Binary Search Tree
		BST binarySearch = new BST();
		Node root = null;
		
		for(int add : data) {
			root = binarySearch.insert(root, add);
		}
		
		System.out.println("\nBinary Search Tree (In-Order traversal) : ");		
		binarySearch.inOrderTraversal(root);
		
		
		// 2-3 Tree
		
		Tree234 t23 = new Tree234();
		
		for(int add : data) {
			t23.insert(add);
		}

		System.out.println("\n----------------------------");
		System.out.println("\n  2-3-4 Tree created with the data");
		
		
		System.out.println("################################################");
		// AVL Tree

		/*
		 * Question 6
		 */
		
		System.out.println("\n\nQuestion 6 ");
		
		AVLTree avlTree = new AVLTree();
		question5.AVLTree.Node root1 = null;
		for(int add : data) {
			root1 = avlTree.insert(root1, add);
		}

		System.out.println("\n AVL Tree created with the data");		
		System.out.println();
		System.out.println("AVL Tree preorder Traversal : ");avlTree.preOrder(root1);;
		
		
		
	}
}

package arrays_and_strings;

import java.util.HashMap;
import java.util.Hashtable;

public class HashTableImpl {
	
	public static void main(String args[]) {
	// To successfully add and extract objects from hashcode.
	// The objects used as keys must implement the hashcode and the equals method
	// matlab jo bhi objects hai hashtable mey, which are used as keys
		// should implement hc and equals method
		
	// Key and value associated with it. 
    // the key is then hashed, then the resulting hashcode is used
		// as the index at which the value is stored in the table.
		
		String s = "Rohit";
		
		char[] c = s.toCharArray();

		Hashtable<Integer, Character> ht = new Hashtable<Integer, Character>();
		int i = 0;
		for(char ch : c) {		
	
			if(ht.contains(ch)) ;// return false;
			else 
			{ 
					ht.put(i, ch); i++;
			}
		}

		
		
		
//		return true; 
		
//	}


}
		
		
		
		
		
		
		
		

	 
	
	
	
	

}

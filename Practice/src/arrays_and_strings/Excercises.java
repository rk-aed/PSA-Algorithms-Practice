package arrays_and_strings;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Excercises {
	

	
	// #1 String is unique
	public static boolean checkIfStringUnqiue(String s) {
		char[] ch = s.toCharArray();
		HashSet<Character> hs = new HashSet<Character>();
		for(char c : ch) {
			if(hs.contains(c)) return false;
			else hs.add(c);
	}
		return true;
	}
	
	// #2 Two strings are permutations or not. Same length, different order
	public static boolean checkIfPermutation(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
	
		String newS1 = String.valueOf(c1);
		String newS2 = String.valueOf(c2);		
		
		return newS1.equals(newS2);
	}
	
	
	// #3 URLify, replace spaces with %20
	
	public static String replaceSpaces(String s) {
		s = s.trim();
		char[] ch = s.toCharArray();
		
		int count = 0;
		
		for(int i = ch.length-1; i >= 0; i++)
		{
			if(ch[i] == ' ') count++;			
		}
		
		int index = count*2 + ch.length;
		
		for(int i = 0; i < index; i++) {
			
		}
		return "void";
	}
	
	public static boolean checkIfOddOne(Hashtable<Character, Integer> hm) {
		Enumeration<Integer> em = hm.elements();
		int count = 0;
		if(em.hasMoreElements()) {
			if(em.nextElement() == 1) count++;
		}
		return count==1;
	}
	
	
	// # 4 Palindrome Permutation
	public static boolean palinPerm(String s) {
		char[] ch = s.toCharArray();
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		for(char c : ch) { // O(N)
			if(ht.containsKey(c)) 
			{	int i = ht.get(c); i++; ht.put(c,i); }
			else ht.put(c, 1);			
		}
		if(ch.length%2 == 0) {  
			for(char c : ch) { // O(n)
				if(ht.get(c)%2 != 0) return false;
			}
			return true;
		}
		else 
		{
			int count = 0;
			for(char c : ch) {
				if(ht.get(c)%2 != 0) {
					if(ht.get(c) == 1) count++;
					else return false;
				}
			}
			if(count == 1) return true;
			else return false;
			}
		}
	

	// One away 
	
	
	// convert them into array
	// then i can sort them
	// check lengths 
	// check each index
	
	
	public static boolean oneAway(String s1, String s2) {
		char[] ch1 = s1.toCharArray();
		char[] ch2 =s2.toCharArray();
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		ht.put('%', 0);
		
		
		for(int i = 0; i < ch1.length; i++)  {
				if(ht.containsKey(ch1[i])) { 
					int value = ht.get(ch1[i]); 
					ht.put(ch1[i],++value);
				}
				else ht.putIfAbsent(ch1[i], 1);
		}
		
		for(int i = 0; i < ch2.length; i++)  {
			if(ht.containsKey(ch2[i])) { 
				int value = ht.get(ch2[i]); 
				ht.put(ch2[i],--value);
			}
			else {
				int value = ht.get('%'); 
				ht.put('%',++value);
			}
		}
		
		Enumeration<Integer> itr = ht.elements();
		
		while(itr.hasMoreElements()) {
			int temp = itr.nextElement();
			if(temp != 0) if(temp != 1) return false;
		}
		
		return true;
	}
	
	
	
	
	
	public static void main(String[] args)  
	{  
		
		// Test case for #1
		
		String s = "Rohit";
		System.out.println("Does String "+s+" contains unique characters : "+checkIfStringUnqiue(s));
		
		// Test case for #2
	    String str1 = "test";  
	    String str2 = "estt" ; //"ttew";  
	    if (checkIfPermutation(str1, str2))  
	    	System.out.println("Yes");  
	    else
	    	System.out.println("No");  
	    
	    
	  
	    
	    
	    // Test case for #4
	    
	    s = "RohhhhhhhitRohhhhhhhitx";
	    System.out.println("Is string "+s+" palindromic "+palinPerm(s));

	
	
	

	    // Test case for #5
	    String str3 = "pale";
	    String str4 = "bake";
	    System.out.println("##########################################");
	    
	    System.out.println("Are strings S1 : "+str3+"' and S2 : '"+str4+"' one away? - "+oneAway(str3, str4));
	    
	    
	    
	    
	    
	    
	
	
	
	} 
	
	
	

}

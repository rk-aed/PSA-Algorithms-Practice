package question2;

import java.util.ArrayList;
import java.util.HashMap;

public class StringSort {
	 public char[] keyIndexedSort(char[] ch) {
		
//		char[] ch = s.toCharArray();
		
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
//		char[] aux = new char[s.length()];
		
		char[] aux = new char[ch.length];
			
		
		// Compute frequency counts.
		for(char c : ch) {
			if(hm.containsKey(c)) hm.put(c, (hm.get(c)+1));
			else hm.put(c, 1);
		}
		
		// Transform counts to indices.
        ArrayList<Character> sortedKeys = 
                new ArrayList<Character>(hm.keySet());
        int[] temp = new int[sortedKeys.size()];
        // Collections.sort(sortedKeys); 
        int count = 0;
        for(char c : sortedKeys) {
        	temp[count] = hm.get(c);
        	count++;
        }
        
        // Cummulative add
        
		for(int i = 1; i < temp.length; i++) {
			temp[i] = temp[i-1] + temp[i];
		}
		
        // Shift by 1
		for(int i = temp.length-2; i >= 0; i--) {
			temp[i+1] = temp[i];
		}		
		temp[0] = 0;
		
		
		/*
		System.out.println("Temp Contents : ");
		for(int i : temp) {
			System.out.print(" "+i);
		} 
		System.out.println();
		System.out.println("Sorted Keys Contents : ");
		for(char C : sortedKeys) {
			System.out.print(" "+C);
		}
		
		System.out.println();
		*/
		
		
		
		// Distribute the data.
		count = 0;
		for(int i : temp) {
			aux[i] = sortedKeys.get(count); 
			count++;
		} 
		char select = ' ';
		for(int i = 0; i < aux.length; i++) {
			if(aux[i] == 0) aux[i] = select;
			else {  
				select = aux[i];
				
			}
		}
		
		
		return aux;
	}
	
	
	// ###########################
	
	
	
	
	public String keyIndexedSort(String s) {
		
		char[] ch = s.toCharArray();
		
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		char[] aux = new char[s.length()];
		
		
		
		// Compute frequency counts.
		for(char c : ch) {
			if(hm.containsKey(c)) hm.put(c, (hm.get(c)+1));
			else hm.put(c, 1);
		}
		
		// Transform counts to indices.
        ArrayList<Character> sortedKeys = 
                new ArrayList<Character>(hm.keySet());
        int[] temp = new int[sortedKeys.size()];
        // Collections.sort(sortedKeys); 
        int count = 0;
        for(char c : sortedKeys) {
        	temp[count] = hm.get(c);
        	count++;
        }
        
        // Cummulative add
        
		for(int i = 1; i < temp.length; i++) {
			temp[i] = temp[i-1] + temp[i];
		}
		
        // Shift by 1
		for(int i = temp.length-2; i >= 0; i--) {
			temp[i+1] = temp[i];
		}		
		temp[0] = 0;
		
		
		/*
		System.out.println("Temp Contents : ");
		for(int i : temp) {
			System.out.print(" "+i);
		} 
		System.out.println();
		System.out.println("Sorted Keys Contents : ");
		for(char C : sortedKeys) {
			System.out.print(" "+C);
		}
		
		System.out.println();
		*/
		
		
		
		// Distribute the data.
		count = 0;
		for(int i : temp) {
			aux[i] = sortedKeys.get(count); 
			count++;
		} 
		char select = ' ';
		for(int i = 0; i < aux.length; i++) {
			if(aux[i] == 0) aux[i] = select;
			else {  
				select = aux[i];
				
			}
		}
		
		
		return String.valueOf(aux);
	}
	
	public String sortBySS(String s) {
		
		char[] ch = s.toCharArray();
		
		// Run through the array
		for(int i = 0; i < ch.length; i++) {
		
			// Pick a number, assign a minimum value
			int min = i;
			
			
			for(int j  = i+1; j < ch.length; j++)
			{
				if(ch[min] > ch[j]) min = j; 
				
			}
			
			if(min != i) {
				char temp   = ch[min];
				ch[min]   = ch[i];
				ch[i]     = temp;
				
			}
		}
		
		return String.valueOf(ch);
	}		

	
	
	public char[] sortBySS(char[] ch) {
		
	// = s.toCharArray();
		
		// Run through the array
		for(int i = 0; i < ch.length; i++) {
		
			// Pick a number, assign a minimum value
			int min = i;
			
			
			for(int j  = i+1; j < ch.length; j++)
			{
				if(ch[min] > ch[j]) min = j; 
				
			}
			
			if(min != i) {
				char temp   = ch[min];
				ch[min]   = ch[i];
				ch[i]     = temp;
				
			}
		}
		
		return ch;
	}		

	
	
	

}

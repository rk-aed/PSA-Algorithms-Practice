package q3;

import java.util.ArrayList;
import java.util.List;

// Link Referred : https://algs4.cs.princeton.edu/53substring/Brute.java.html

public class Brute {

	    public static int search1(char[] pattern, char[] text) {
	        int m = pattern.length;
	        int n = text.length;

	        for (int i = 0; i <= n - m; i++) {
	            int j;
	            for (j = 0; j < m; j++) {
	                if (text[i+j] != pattern[j])
	                    break;
	            }
	            if (j == m) return i;            // found 
	        }
	        return n;                            // not found
	    }


	    public static List<Integer> search2(char[] pattern, char[] text) { 

	        char[] textArray = text;
	        char[] patternArray = pattern;

	        int textLength = textArray.length;
	        int patternLength = patternArray.length;

	        List<Integer> matchedIndexes = new ArrayList<>();

	        int textIndex = 0;


	        for(textIndex = 0; textIndex < textLength; textIndex++){
	            int textIndexLocal = textIndex;
	            Boolean match = true;
	            int matchedIndex = textIndex;
	            for(int patternIndex = 0; patternIndex < patternLength; patternIndex++){
	                if(textArray[textIndexLocal] != patternArray[patternIndex]) {
	                    match = false;
	                    break;
	                }
	                textIndexLocal = textIndexLocal + 1;
	            }
	            if(match)
	                matchedIndexes.add(matchedIndex);
	        }
	        return matchedIndexes;
	    
	    } 


//	    /** 
//	     * Takes a pattern string and an input string as command-line arguments;
//	     * searches for the pattern string in the text string; and prints
//	     * the first occurrence of the pattern string in the text string.
//	     *
//	     * @param args the command-line arguments
//	     */
	    public static void main(String[] args) {
	       
	        System.out.println("Q3) a) The pattern 'BCD' found in text 'ABCADCBABABCDABCD' on index : "+ search2("BCD".toCharArray(),"ABCADCBABABCDABCD".toCharArray()));
	        
	    }

}

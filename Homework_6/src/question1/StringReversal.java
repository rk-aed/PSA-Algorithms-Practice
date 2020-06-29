package question1;

public class StringReversal {

	public String stringRev(String s) {
		
		String result = "";
		for(int i = s.length() - 1; i >= 0; i--) {
			result += s.charAt(i);	
		}
		return result;
		
	}
	

	public String stringBuilderRev(String s) {
		StringBuilder sb = new StringBuilder(s);
		for(int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));	
		}
		return sb.toString();
	}
	

	
	
	
	
	
	
	
}

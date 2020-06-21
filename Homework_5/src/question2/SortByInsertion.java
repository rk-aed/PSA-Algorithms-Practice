package question2;

public class SortByInsertion {
	public void sortByIS(int[] arr) {
		for(int i = 0; i< arr.length; i++) {
			int currNum = arr[i];
			int j = i;
			while(j > 0 && currNum < arr[j-1] ) {
				arr[j] = arr[j-1];				
				j--;
			}
			arr[j]=currNum;
			
		}
	}
}

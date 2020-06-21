package question1;

public class SortByQuick {
	
	
	public void quickSort(int[] array, int start, int end) {
			if (start < end) {
				int pivot = partition(array, start, end);
				quickSort(array, start, pivot-1 );
				quickSort(array, pivot + 1,end);
			}
		}
		
	private int partition(int[] array, int p, int q) {
			int pivot = q;
			int i = p-1;
			for (int j = p; j <= q; j++) {
				if (array[j] <= array[pivot]) {
					i++;
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
			return i;
	
		}
	
	
	
	

}

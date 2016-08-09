public class InsertionSort {

	public static void main(String[] args) {
		int[] unsorted = {7, 3, 2, 4, 9, 1, 14, 12};
		int[] sorted = doInsertionSort(unsorted);
		
		for(int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i]);
		}
		
	}

	private static int[] doInsertionSort(int[] input) {
		//Your code here
        int holder;
        int counter = 0;
		for (int i = input.length-1; i > 0 ; i--) {

			for (int j = i; j > 0 + counter ; j--) {
				if (input[j]<input[j-1]){
                    holder = input[j];
                    input[j] = input[j-1];
                    input[j-1] = holder;
				}
			}
            counter++;
		}
		return input;
	}
}

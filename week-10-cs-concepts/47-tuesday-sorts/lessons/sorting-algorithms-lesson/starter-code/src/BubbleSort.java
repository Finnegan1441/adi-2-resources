public class BubbleSort {

    public static void main(String[] args) {
        int[] unsorted = {10, 15, 1, 3, 14, 2, 17, 9, 51, 6, 16, 22, 8};
        bubbleSort(unsorted);

        for (int i = 0; i < unsorted.length; i++) {
            System.out.println(unsorted[i]);
        }
    }

    private static void bubbleSort(int[] unsorted) {
        //Your code here. Include a print statement
        //declaring after which pass (iteration through
        //the outside loop) the algorithm. It should be the 9th.
        int holder;
        for (int i = 0; i < unsorted.length ; i++) {
            for (int j = 0; j <unsorted.length-1-i; j++) {
                if (unsorted[j]>unsorted[j+1]){
                    holder = unsorted[j];
                    unsorted[j] = unsorted[j+1];
                    unsorted[j+1]=holder;
                }
                
            }

        }

    }

}

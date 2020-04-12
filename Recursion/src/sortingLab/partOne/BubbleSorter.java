package sortingLab.partOne;

/**
 * This class sorts an array, using the selection sort algorithm.
 */
public class BubbleSorter {

    /**
     * Constructs a selection sorter.
     *
     * @param anArray the array to sort
     */
    public BubbleSorter(int[] anArray) {
        a = anArray;
    }

    /**
     * Sorts the array managed by this selection sorter.
     */
    public void sort() {
        for (int i = 0; i < a.length - 1; i++) {

            for (int j = 0; j < a.length-i-1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }



    private int[] a;
}

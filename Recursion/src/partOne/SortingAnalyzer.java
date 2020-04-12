package partOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class SortingAnalyzer {

    private static StopWatch stopWatch;
    private static BubbleSorter bubbleSorter;
    private static InsertionSorter insertionSorter;
    private static SelectionSorter selectionSorter;
    private static int[] array = ArrayUtil.randomlntArray(10000, 10000);


    public static void stopWatchStart() {
        stopWatch = new StopWatch();
        stopWatch.start();
    }

    public static Integer[] toObjectConverter(int[] array) {
        Integer[] boxedArray = new Integer[array.length];

        for (int i = 0; i < array.length; i++) {
            boxedArray[i] = Integer.valueOf(array[i]);
        }
        return boxedArray;
    }

    public static int[] toPrimitiveConverter(Integer[] array) {
        int[] boxedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            boxedArray[i] = array[i];
        }
        return boxedArray;
    }

    public static void stopAndShowTime() {
        stopWatch.stop();
        System.out.println("Time elapsed: " + stopWatch.getElapsedTime() + " millis");
        System.out.println("/****************************************/");
    }

    public static void measureAndBubbleSort() {
        stopWatchStart();
        bubbleSorter.sort();
        stopAndShowTime();
    }

    public static void measureAndInsertionSort() {
        stopWatchStart();
        insertionSorter.sort();
        stopAndShowTime();
    }

    public static void measureAndSelectionSort() {
        stopWatchStart();
        selectionSorter.sort();
        stopAndShowTime();
    }

    private static ArrayList <Integer> numbers = new ArrayList <>();

    public static void initializeList() {
        for (int number : array) {
            numbers.add(number);
        }
    }

    public static int[] getInitialArrayValues() {
        int[] array = new int[numbers.size()];
        int index = 0;
        for (int number : numbers) {
            array[index] = number;
            index++;
        }
        return array;
    }


    public static void main(String[] args) {
        initializeList();

        /** BUBBLE SORT RELATED METHODS: **/

        int[] random = getInitialArrayValues();

        bubbleSorter = new BubbleSorter(random);

        System.out.println("Sorting random using BUBBLE SORT: ");
        measureAndBubbleSort();

        /* creating new array of random numbers */
        random = getInitialArrayValues();

        /* converting array to Objects to be able to use the sort(reverseOrder()) function */
        Integer[] randomArray = toObjectConverter(random);
        Arrays.sort(randomArray, Collections.reverseOrder());

        random = toPrimitiveConverter(randomArray);
        bubbleSorter = new BubbleSorter(random);

        System.out.println("Sorting descending array using BUBBLE SORT: ");
        measureAndBubbleSort();

        bubbleSorter = new BubbleSorter(random);
        System.out.println("Sorting in order array using BUBBLE SORT: ");
        measureAndBubbleSort();

        /** INSERTION SORT RELATED METHODS: **/

        random = getInitialArrayValues();
        insertionSorter = new InsertionSorter(random);
        System.out.println("Sorting random using INSERTION SORT: ");
        measureAndInsertionSort();

        /* creating new array of random numbers */
        random = getInitialArrayValues();

        /* converting array to Objects to be able to use the sort(reverseOrder()) function */
        randomArray = toObjectConverter(random);
        Arrays.sort(randomArray, Collections.reverseOrder());

        random = getInitialArrayValues();
        insertionSorter = new InsertionSorter(random);

        System.out.println("Sorting descending array using INSERTION SORT: ");
        measureAndInsertionSort();


        insertionSorter = new InsertionSorter(random);
        System.out.println("Sorting in order array using INSERTION SORT: ");
        measureAndInsertionSort();


        /** SELECTION SORT RELATED METHODS: **/

        random = getInitialArrayValues();
        selectionSorter = new SelectionSorter(random);
        System.out.println("Sorting random using SELECTION SORT: ");
        measureAndSelectionSort();

        /* creating new array of random numbers */
        random = getInitialArrayValues();

        /* converting array to Objects to be able to use the sort(reverseOrder()) function */
        randomArray = toObjectConverter(random);
        Arrays.sort(randomArray, Collections.reverseOrder());

        random = toPrimitiveConverter(randomArray);
        selectionSorter = new SelectionSorter(random);

        System.out.println("Sorting descending array using SELECTION SORT: ");
        measureAndSelectionSort();

        selectionSorter = new SelectionSorter(random);
        System.out.println("Sorting in order array using SELECTION SORT: ");
        measureAndSelectionSort();


    }
}

package sortingLab.partTwo;

import java.util.Random;

import quadratic.StopWatch;

public class Sorts {
    private int[] nos;
    private int steps;

    private static Random generator;

    // Constructs a default array of size 10
    public Sorts() {
        nos = new int[10];
        nos[0] = -10001;
        nos[1] = 3;
        nos[2] = 7;
        nos[3] = 19;
        nos[4] = 15;
        nos[5] = 19;
        nos[6] = 7;
        nos[7] = 3;
        nos[8] = 19;
        nos[9] = -100;
    }

    public Sorts(int[] temp) {
        nos = temp;
    }


    public static int[] randomlntArray(int length, int n) {
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++)
            a[i] = generator.nextInt(n);
        return a;
    }


    // Constructs an array with size random Sorts from [0,range)
    public Sorts(int size, int range) {
        generator = new Random();
        nos = randomlntArray(size, range);
    }

    // Constructs an array of random Sorts [0-range) array of size count with a seed
    // The seed allows you to use the same set of random numbers
    public Sorts(int count, int range, long seed) {
        generator = new Random(seed);
        nos = randomlntArray(count, range);
    }

    // This constructor will create an ordered array of consecutive integers
    // true will yield ascending order
    // false will yield descending order
    public Sorts(int count, boolean ordered) {
        generator = new Random(count);
        nos = randomlntArray(count, 100);
        if (ordered) {
            bubbleSort();
        } else {
            sortDescending();
        }
    }


    public void sortDescending() {
        for (int i = 0; i < (nos.length - 1); i++) {
            steps += 3;
            for (int j = 0; j < nos.length - i - 1; j++) {
                steps += 3;
                if (nos[j] < nos[j + 1]) {
                    steps += 3;
                    int temp = nos[j];
                    nos[j] = nos[j + 1];
                    nos[j + 1] = temp;
                }
            }
        }
    }

    public int getSteps() {
        return steps;
    }

    public void display() {
        for (int x : nos)
            System.out.print(x + " ");
        System.out.println();
    }

    public int[] getNos() {
        return nos;
    }

    public void swap(int x, int y) {
        int temp = nos[x];
        nos[x] = nos[y];
        nos[y] = temp;
        steps += 3;
    }

    public void bubbleSort() {
//Consecutive values are compared and swapped if necessary
        steps = 0;
        boolean swapped = true;
        steps++;
        int lastSwap = nos.length - 1;

        steps++;
        int temp = 0;
        steps++;
        steps++; // initialize for loop
        for (int i = 0; i < nos.length; i++) {
            steps += 3; // boundary check, increment,if
            if (swapped) {
                swapped = false;
                steps++;
                steps++; // initialize for loop
                for (int j = 0; j < lastSwap; j++) {
                    steps += 3; // boundary check, increment,if
                    if (nos[j] > nos[j + 1]) {
                        swap(j, j + 1);
                        swapped = true;
                        steps++;
                        temp = j;
                        steps++;
                    }
                }
                lastSwap = temp;
                steps++;
            }
        }
    }

    public static void main(String[] args) {
        Sorts one = new Sorts();
        StopWatch timer = new StopWatch();
        timer.start();
        one.bubbleSort();
        timer.stop();
        one.display();
        System.out.println("Default Array Steps: " + one.getSteps());
        System.out.println("Default Array time: " + timer.getElapsedTime() + "milliseconds.");
        System.out.println("----------------------------------------------------------------");

        //This is a sample code for testing bubble sort for data in reverse order
        Sorts two = new Sorts(10, false);
        timer.reset();
        timer.start();
        timer.stop();
        two.display();
        System.out.println("Reverse order Steps: " + two.getSteps());
        System.out.println("Reverse order time: " + timer.getElapsedTime() + " milliseconds");
        System.out.println();

    }
}

import java.util.Scanner;

/**
 * This program measures how long it takes to sort an
 * array of user-specified size with the quicksort algorithm.
 *
 * The core of the program is a loop that allows repeated timings until the user
 * enters a negative number as the array size.
 *
 * @author Michael Sammels
 * @version 25.05.2019
 */

public class QuickSortTimer {
    /**
     * The main launcher method
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        System.out.println("Timing Quicksort");
        System.out.println();

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter size of random array to sort, negative to quit: ");
            int n = in.nextInt();

            if (n < 0) {    // Stop now?
                break;      // Yes, escape from the while loop
            }

            // Construct random array: n random values, each in the range of 0 - n-1
            int[] a = ArrayUtil.randomIntArray(n, n);

            // Use stopwatch to time selection sort
            StopWatch timer = new StopWatch();

            timer.start();
            quickSort(a);
            timer.stop();

            System.out.println("To sort " + n + " elements: Elapsed time: " + timer.getElapsedTime() + " milliseconds");
            System.out.println();
        }
        System.out.println();
        System.out.println("Finished");
    }

    /**
     * Sorts an array, using quick sort.
     * @param a the array to sort
     */
    private static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    /**
     * Sorts a portion of an array, using quick sort.
     * @param a the array to sort
     * @param from the first index of the portion to be sorted
     * @param to the last index of the portion to be sorted
     */
    private static void quickSort(int[] a, int from, int to) {
        if (from >= to) { return; }
        int p = partition(a, from, to);
        quickSort(a, from, p);
        quickSort(a, p + 1, to);
    }

    /**
     * Partitions a portion of an array.
     * @param a the array to partition
     * @param from the first index of the portion to be partitioned
     * @param to the last index of the portion to be partitioned
     * @return the last index of the first partition
     */
    private static int partition(int[] a, int from, int to) {
        int pivot = a[from];
        int i = from - 1;
        int j = to + 1;
        while (i < j) {
            i++; while (a[i] < pivot) { i++; }
            j--; while (a[j] > pivot) { j--; }
            if (i < j) {
                ArrayUtil.swap(a, i, j);
            }
        }
        return j;
    }
}

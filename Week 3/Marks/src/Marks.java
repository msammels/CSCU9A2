import java.util.Scanner;

/**
 * This program reads a student's marks into an array, discards the lowest mark,
 * adds up the remaining marks and displays the average.
 *
 * It is an exercise in top-down structured development of the methods in a program.
 *
 * @author Simon Jones (SBJ) Spring 2014
 * @author Michael Sammels (MIS) Spring 2019
 *
 * @version 25.05.2019
 */

public class Marks {
    /**
     * The main launcher method
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        // Step 1 - break down the problem into sub-tasks
        int numberOfMarks = readInteger();      // Take input from the user...
        int[] marks = new int[numberOfMarks];   // ...and assign it to an array

        // Read the marks in, discard the lowest mark and find the average
        readMarks(marks);
        discardLowestMark(marks);
        float average = averageTheMarksExceptTheLastOne(marks);

        // Report back the average mark
        System.out.println("The average mark is: " + average);
    }

    /**
     * Repeatedly read integers from the user, to fill all the elements of the given marks array
     * @param marks an array of marks to be filled up
     */
    private static void readMarks(int[] marks) {
        // Step 1 - outline of sub-task as a method
        Scanner scan = new Scanner(System.in);

        // Loop for the number of times the user specified in readInteger
        for (int i = 0; i < marks.length; i++) {
            // Ask for user input
            System.out.print("Enter mark " + (i + 1) + ": ");

            while (!scan.hasNextInt()) {    // While non-integers are present...
                scan.next();                // ...read and discard input, then prompt again
                System.out.println("Bad input. Please enter an integer");
            }

            // Store it in the array at index + 1
            marks[i] = scan.nextInt();
        }
    }

    /**
     * Assume that the given array is full of marks (integers). The lowest mark is discarded
     * by moving all the following marks down one element in the array. This leaves valid marks
     * in all except the last element of the array.
     */
    private static void discardLowestMark(int[] marks) {
        int position = findLowestMark(marks);
        removeMark(position, marks);
    }

    /**
     * Search the given array of marks, and return the index of the lowest mark (or an equal lowest mark)
     * @return the lowest mark
     */
    private static int findLowestMark(int[] marks) {
        int index = 0;                  // The current index in the array
        int min = marks[index];         // The index with the lowest number

        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < min) {       // If the current index is smaller than the previous one...
                min = marks[i];         // ...then change the lowest index to the current one
                index = i;
            }
        }
        return index;
    }

    /**
     * Remove the value at index position in array marks by moving all further values down one element
     * Return the new array
     */
    private static void removeMark(int position, int[] marks) {
        // Loop while the current position is one less than the end
        // Once we fnd the lowest mark, remove it
        if (marks.length - 1 - position >= 0)
            System.arraycopy(marks, position + 1, marks, position, marks.length - 1 - position);
    }

    /**
     * Add all the marks in the given array together, excluding the very last array element
     * (as that element contains junk left over from discarding the lowest mark). Return
     * the average as the result
     */
    private static float averageTheMarksExceptTheLastOne(int[] marks) {
        float average, total = 0;
        int newMarks = marks.length - 1;    // Remove one off the end of the array, as it is filled with junk

        // Here we are going to calculate the sum of all the numbers entered, up to the length of the array
        for (int i = 0; i < newMarks; i++) {
            total = total + marks[i];
        }

        // Once we have the sum of the numbers, let's find the average. We will need to cast to a float for precision
        // We divide s (the sum of the numbers) by the amount of digits entered (in this case, 10)
        average = total / newMarks;

        return average;
    }

    /**
     * A standard method:
     *
     * Display the prompt and then read the lines repeatedly until a valid integer is found, and return it.
     *
     * @return a valid integer
     */
    private static int readInteger() {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many marks? ");
        while (!scan.hasNextInt()) {    // While non-integers are present...
            scan.next();                // ...read and discard input, then prompt again
            System.out.println("Bad input. Please enter an integer");
        }
        return scan.nextInt();
    }
}

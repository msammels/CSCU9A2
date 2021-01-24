import java.util.Scanner;

/**
 * InputWords
 *
 * @author Michael Sammels
 * @version 20.01.2019
 */

public class Words {
    /**
     * The main launcher method
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {

        // Setup the array to store the words in
        String[] myList = new String[10];

        readArray(myList);                          // Function to read data into the array
        searchArray(myList);                        // Function to search the array and output the results
    }

    /**
     * Read strings from the user and store the result
     * Do not display the valid input
     * Do not count invalid input
     * @param a the array to read in
     */
    private static void readArray(String[] a) {
        Scanner scan = new Scanner(System.in);

        // Loop 10 times
        for (int i = 0; i < a.length; i++) {
            // Ask for user input
            System.out.print("Enter word " + (i + 1) + ": ");

            // Store it in the array at index + 1
            a[i] = scan.nextLine();
        }
    }

    /**
     * Search strings in the array and return the result case-insensitive
     * Returns word searched for to terminal
     * @param a the array to read in
     */
    private static void searchArray(String[] a) {
        Scanner scan = new Scanner(System.in);
        int idx = 0;                                // idx = index of current string
        boolean flag = false;                       // Flag to determine whether or not the string searched for was found

        // Ask for user input
        System.out.println("Search for word in the array: ");
        String search = scan.nextLine();

        for (int i = 0; i <= a.length - 1; i++) {
            if (search.equalsIgnoreCase(a[i])) {    // If the search (case-insensitive has been found...
                flag = true;                        // ...set the flag to true...
                idx = i;                            // ...and store the current index
            }
        }

        // If the search was found, report back with the word searched for and the index it was found at...
        if (flag) {
            System.out.println("Your search for \"" + search + "\" was found at index " + idx);

            // ...otherwise, report back with the word searched for, and a "failed" message
        } else {
            System.out.println("Your search for \"" + search + "\" was not found in the array");
        }
    }
}

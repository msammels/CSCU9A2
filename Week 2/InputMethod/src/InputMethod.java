import java.util.Scanner;

/**
 * InputMethod
 *
 * @author Michael Sammels
 * @version 20.01.2019
 */

public class InputMethod {
    /**
     * The main launcher method
     * @param args Command line argument (unused)
     */
    public static void main(String[] args) {
        int i, n, s = 0;    // i = integer (for loop), n = number (readInteger), s = sum of numbers
        double average;

        // Here we are going to calculate the sum of all the numbers entered, up to 10 numbers
        for (i = 0; i < 10; i++) {
            n = readInteger();

            s += n;         // A fancier way of saying "s = s + n"
        }

        // Once we have the sum of the numbers, let's find the average. We will need to cast to a double for precision
        // We divide s (the sum of the numbers) by the amount of digits entered (in this case, 10)
        average = (double) s / 10;

        // Displaying the final results (average) to the terminal
        System.out.println("The average of the numbers is: " + average);
    }

    /**
     * Read integers from the user and return the result
     * Do not display the valid input
     * Do not count invalid inputs
     */
    private static int readInteger() {
        Scanner scan = new Scanner(System.in);  // Scanner object to take input from the user

        // Ask the user to an enter an integer
        System.out.print("Enter an integer: ");
        while (!scan.hasNextInt()) {            // While non-integers are present...
            scan.next();                        // ...read and discard input, then prompt again
        }

        // Store the input in a variable
        return scan.nextInt();
    }
}

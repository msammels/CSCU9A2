import java.util.Scanner;

/**
 * InputLoop
 *
 * @author Michael Sammels
 * @version 20.01.2019
 */

public class InputLoop2 {
    /**
     * The main launcher method
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  // Scanner object to take input from the user

        // Ask the user to enter an integer
        System.out.println("Enter an integer: ");
        while (!scan.hasNextInt()) {            // While non-integers are present...
            scan.next();                        // ...read and discard input, then prompt again
        }

        // Store the input in a variable
        int input = scan.nextInt();

        // Output the results to the terminal
        System.out.println("You entered " + input + "!");
    }
}

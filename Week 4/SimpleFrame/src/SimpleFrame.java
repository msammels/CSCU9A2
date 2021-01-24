import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * This program displays an empty frame.
 *
 * @author Michael Sammels
 * @version 25.05.2019
 */

public class SimpleFrame extends JFrame {
    /**
     * The main launcher method
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        SimpleFrame frame = new SimpleFrame();

        final int FRAME_WIDTH = 640;
        final int FRAME_HEIGHT = 480;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocation(150, 150);
        frame.setTitle("An empty frame");

        frame.createGUI();

        frame.setVisible(true);
    }

    private static int readInteger() {
        Scanner scan = new Scanner(System.in);

        // Ask the user to enter an integer
        System.out.print("Enter an integer: ");
        while (!scan.hasNextInt()) {
            scan.next();
        }

        // Store the input in a variable
        return scan.nextInt();
    }

    /**
     * This method sets up the graphical user interface
     */
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        JTextField textA;
        JTextField textB;
        JTextField textC;

        // Nothing in the window yet!
        textA = new JTextField(15);
        textA.setFont(new Font("Arial", Font.BOLD, 40));
        textA.setEditable(false);

        textB = new JTextField(15);
        textB.setFont(new Font("Arial", Font.BOLD, 40));
        textB.setEditable(false);

        textC = new JTextField(15);
        textC.setFont(new Font("Arial", Font.BOLD, 40));
        textC.setEditable(false);

        window.add(textA);
        window.add(textB);
        window.add(textC);

        // Variables to hold sum declaration
        // a = first value, b = second value, c = sum of a + b
        int a, b, c;

        // Pulling in the numbers
        a = readInteger();
        b = readInteger();

        // Calculating the sum
        c = a + b;

        textA.setText("a is " + a);
        textB.setText("b is " + b);
        textC.setText("c is " + c);
    }
}

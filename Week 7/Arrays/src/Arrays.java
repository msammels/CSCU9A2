import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple arrays "laboratory" for exercises in Practical 5B.
 *
 * Provides basic storage for an array of strings, and a simple text area interface for displaying the array
 * and for invoking actions through a button and a slider.
 *
 * Exercises consist of various array processing algorithms to be inserted into doSomething method
 * (at the bottom of the program), which is called when the button is pressed
 *
 * @author Simon Jones
 * @author Michael Sammels
 * @version 25.05.2019
 */

public class Arrays extends JFrame implements ChangeListener, ActionListener {
    /**
     * Frame size constants
     */
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;

    /**
     * The number of data items to be held
     */
    private final int size = 10;

    /**
     * Holds the data items to be manipulated
     */
    private final String[] items = new String[size];

    /**
     * To indicate which item is currently selected, 0th item initially.
     */
    private int selected = 0;

    /**
     * The slider for selecting a data item (selectable 0 to size - 1)
     */
    private final JSlider selector = new JSlider(JSlider.HORIZONTAL, 0, size - 1, selected);

    /**
     * Click this button to do something
     */
    private final JButton act = new JButton("Act now");

    /**
     * For displaying the data items - enough lines for the whole array
     */
    private final JTextArea display = new JTextArea(size + 2, 20);

    /**
     * The main program launcher for the Arrays class
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        Arrays frame = new Arrays();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setUpData();
        frame.createGUI();
        frame.setVisible(true);
    }

    /**
     * Sets up the graphical user interface.
     */
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        // The Act Now button
        window.add(act);
        act.addActionListener(this);

        // The element selector slider
        window.add(selector);
        selector.addChangeListener(this);

        // Add text area display and immediately update it oon the screen
        window.add(display);
        displayItems();
    }

    /**
     * Helper method to set up the array data
     */
    private void setUpData() {
        // All the data is "built-in": set it up here
        // DO NOT CHANGE THESE ASSIGNMENT STATEMENTS
        items[0] = "Alpha";
        items[1] = "Beta";
        items[2] = "Gamma";
        items[3] = "Delta";
        items[4] = "Fred";
        items[5] = "Joe";
        items[6] = "Bill";
        items[7] = "Charlie";
        items[8] = "Java";
        items[9] = "HTML";
    }

    /**
     * This method redisplay the array's contents on the screen,
     * with the selected item followed by a *.
     */
    private void displayItems() {
        // Erase the text area
        display.setText("");

        // Redisplay data in
        for (int i = 0; i < size; i++) {        // Scan through the array indices
            // Now display the item's index and value
            display.append(i + " :    ");       // The item's index in left column
            display.append(items[i]);           // The item in right column

            // If this is the selected item, add a * to the line
            if (i == selected) {                // Is this, the i'th item, the "selected" one?
                display.append(" *");           // Yes
            }
            display.append("\n");               // Finish each line by adding a new line character
        }
    }

    /**
     * Reacts to adjustment of the slider.
     * Notes the new selector setting, then redisplay the array's contents.
     */
    public void stateChanged(ChangeEvent e) {
        selected = selector.getValue();
        displayItems();
    }

    /**
     * The button has been clicked: take action by calling doSomething, and then redisplay the array's contents.
     */
    public void actionPerformed(ActionEvent e) {
        doSomething();
        displayItems();
    }

    /**
     * This method is to have various algorithms programmed into its body, one at a time, to see the effect.
     * (Some are already here.) It will be useful to keep the solution for each step as you work on the
     * next, so comment out and keep each one as you start the next one!
     */
    private void doSomething() {
        // Exercise to fill the array with "Hello's"
        //for (int i = 0; i < size; i++) {
        //    items[i] = "Hello";
        //}

        // Exercise to set just the item at index 2 to "Hello"
        //items[2] = "Hello";

        // Exercise to set just the selected item to "Hello"
        //items[selected] = "Hello";

        // Exercise to fill the array with "Omega"
        //for (int i = 0; i <= size; i++) {
        //    items[i] = "Omega";
        //}

        // Exercise to fill the array from index to 0 up to and including the selected item with "Stirling"
        //for (int i = 0; i < selected + 1; i++) {
        //    items[i] = "Stirling";
        //}

        // Exercise to fill the array from index 0 up to and excluding the selected item with "Glasgow"
        //for (int i = 0; i < selected; i++) {
        //    items[i] = "Glasgow";
        //}

        // Exercise to fill the array from the selected index to the end of the array with "Paris"
        //for (int i = selected; i < size; i++) {
        //    items[i] = "Paris";
        //}

        // Exercise to fill the array from the index after the selected to the end of the array with "Berlin"
        //for (int i = selected + 1; i < size; i++) {
        //    items[i] = "Berlin";
        //}

        // Exercise to set the index after the selected one with "Cottrell"
        //int i = selected + 1;

        //if (i < 10) {
        //    items[i] = "Cottrell";
        //}

        // Exercise to set the index before the selected one with "Pathfoot"
        //int i = selected - 1;

        //if (i > -1) {
        //    items[i] = "Pathfoot";
        //}

        // Exercise to set the index before and after the selected one with the string in the selected element

        int i = selected;

        switch (selected) {
            case 0:
                items[i + 1] = items[selected];
                break;
            case size - 1:
                items[i - 1] = items[selected];
                break;
            default:
                items[i + 1] = items[selected];
                items[i - 1] = items[selected];
                break;
        }
    }
}

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Addresses
 *
 * A simple address database for Practical 5B
 * Demonstrates arras, graphics, election.
 *
 * @author Michael Sammels
 * @version 25.05.2019
 */

public class Addresses extends JFrame implements ChangeListener {
    /**
     * Frame size constants
     */
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 400;

    /**
     * The slider for selecting an address record (selectable 0 to size - 1)
     */
    private JSlider selector;

    /**
     * Array to hold the database.
     */
    private String[] names;
    private String[] addresses;
    private String[] telNumbers;

    /**
     * To indicate which entry is currently selected.
     */
    private int selected;

    /**
     * The main program launcher for the Addresses class.
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        Addresses frame = new Addresses();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setUpData();          // Initial data setup
        frame.createGUI();          // Initial GUI setup
        frame.setVisible(true);
    }

    /**
     * Sets up the graphical user interface
     */
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        // Slider for selecting an address entry
        selector = new JSlider(JSlider.VERTICAL, 0, names.length - 1, 0);
        // Note: the usable range of the slider is 0 - 0 at the moment
        window.add(selector);
        selector.addChangeListener(this);

        // Graphics panel for displaying the address list
        // paintComponent is called automatically when a screen refresh is needed
        // g is a cleared panel area
        // Paint the panel's background
        // Then the required graphics

        /*
          The drawing panel for display of information.
         */
        JPanel panel = new JPanel() {
            // paintComponent is called automatically when a screen refresh is needed
            public void paintComponent(Graphics g) {
                // g is a cleared panel area
                super.paintComponent(g);    // Paint the panel's background
                paintScreen(g);             // Then the required graphics
            }
        };

        /*
         * Drawing panel size constants
         */
        int PANEL_WIDTH = 400;
        int PANEL_HEIGHT = 300;
        panel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        panel.setBackground(Color.white);
        window.add(panel);
    }

    /**
     * Helper method to set up the array data, and the associated variable selected with their initial configuration.
     */
    private void setUpData() {
        // ALL the data is "built-in": set it up here - just one entry at the moment
        /*
         * Array size
         */
        int ARRAY_SIZE = 6;
        names = new String[ARRAY_SIZE];         // Create the array with space for one entry
        names[0] = "James";                     // The entry
        names[1] = "John";
        names[2] = "Jack";
        names[3] = "Jim";
        names[4] = "Jagger";
        names[5] = "Jarvis";

        addresses = new String[ARRAY_SIZE];
        addresses[0] = "1 Main Street";
        addresses[1] = "2 Main Street";
        addresses[2] = "3 Main Street";
        addresses[3] = "4 Main Street";
        addresses[4] = "5 Main Street";
        addresses[5] = "6 Main Street";

        telNumbers = new String[ARRAY_SIZE];
        telNumbers[0] = "01324 450000";
        telNumbers[1] = "01324 450001";
        telNumbers[2] = "01324 450002";
        telNumbers[3] = "01324 450003";
        telNumbers[4] = "01324 450004";
        telNumbers[5] = "01324 450005";

        selected = 0;                   // Indicate that entry 0 is selected
    }

    /**
     * This method redraws the screen.
     */
    private void paintScreen(Graphics g) {
        displayList(g);
        displaySelected(g);
    }

    /**
     * Display all the elements of the array names in a column on the screen
     */
    private void displayList(Graphics g) {
        int x = 20;             // Top x coordinate of the column
        int y = 100;            // Top y coordinate of the column

        g.setColor(Color.black);

        for (int i = 0; i < names.length; i++) {
            g.drawString(names[i], x, y + 15 * i);
        }
    }

    /**
     * Display the single element of array names that is currently selected by the slider
     */
    private void displaySelected(Graphics g) {
        int x = 200;            // Top x coordinate of the column

        g.setColor(Color.black);
        g.drawString("Current selection is:", x, 135);
        g.drawString(names[selected], x, 150);
        g.drawString(addresses[selected], x, 165);
        g.drawString(telNumbers[selected], x, 180);
    }

    /**
     * Reacts to adjustment of the slider
     * Notes the new selector setting, then forces screen refresh.
     */
    public void stateChanged(ChangeEvent e) {
        // Selector has been adjusted; record the new setting
        selected = selector.getValue();
        repaint();          // Refresh the screen
    }
}

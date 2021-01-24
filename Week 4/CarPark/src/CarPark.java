import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This program counts the cars entering and leaving a car park, always displaying the current number of cars
 * in the car park.
 *
 * @author Michael Sammels
 * @version 25.05.2019
 */

public class CarPark extends JFrame implements ActionListener {
    /**
     * Globally accessible counter for the number of cars in the car park
     */
    private int carCount, busCount = 0;
    private int spacesLeft = 20;

    /**
     * Buttons to simulate cars entering and leaving the car park
     */
    private JButton carEnter, carExit, busEnter, busExit;

    /**
     * Text field where the current number of cars is displayed
     */
    private JTextField carText, busText, spaceLeft;

    /**
     * The main launcher method
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        CarPark frame = new CarPark();
        frame.setSize(300, 240);
        frame.setLocation(150, 150);
        frame.setTitle("Car Park");
        frame.createGUI();
        frame.setVisible(true);
    }

    /**
     * Helper method to build up the GUI
     */
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        // Enter buttons
        carEnter = new JButton("Car Entering");
        busEnter = new JButton("Bus Entering");

        // Exit buttons
        carExit = new JButton("Car Exiting");
        busExit = new JButton("Bus Exiting");

        carExit.setEnabled(false);
        busExit.setEnabled(false);

        // Text fields
        carText = new JTextField("0   ");
        carText.setFont(new Font("Arial", Font.BOLD, 40));
        carText.setEditable(false);

        busText = new JTextField("0   ");
        busText.setFont(new Font("Arial", Font.BOLD, 40));
        busText.setEditable(false);

        // Add the action listeners
        carEnter.addActionListener(this);
        carExit.addActionListener(this);
        busEnter.addActionListener(this);
        busExit.addActionListener(this);

        // Add to frame
        window.add(carEnter);
        window.add(carText);
        window.add(carExit);

        window.add(busEnter);
        window.add(busText);
        window.add(busExit);

        // Spaces left
        JLabel spaceLabel = new JLabel("Spaces Remaining");
        window.add(spaceLabel);

        spaceLeft = new JTextField(5);
        spaceLeft.setText(Integer.toString(spacesLeft));
        spaceLeft.setFont(new Font("Arial", Font.BOLD, 40));
        spaceLeft.setEditable(false);
        window.add(spaceLeft);
    }

    /**
     * React to a GUI button press by adjusting the car counter correctly, and then updating the counter display
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == carEnter) {
            // Make sure the counter cannot go above 20 or below 0
            carCount = Math.min(20, carCount + 1);

            // Update the spaces left counter
            spacesLeft = Math.max(0, spacesLeft - 1);
            spaceLeft.setText(Integer.toString(spacesLeft));
        } else if (event.getSource() == carExit) {
            // Make sure the counter cannot go above 20 or below 0
            carCount = Math.max(0, carCount - 1);

            // Update the spaces left counter
            spacesLeft = Math.min(20, spacesLeft + 1);
            spaceLeft.setText(Integer.toString(spacesLeft));
        } else if (event.getSource() == busEnter) {
            // Make sure the counter cannot go above 20 or below 0
            busCount = Math.min(20, busCount + 1);

            // Update the spaces left counter
            spacesLeft = Math.max(0, spacesLeft - 1);
            spaceLeft.setText(Integer.toString(spacesLeft));
        } else if (event.getSource() == busExit) {
            // Make sure the counter cannot go above 20 or below 0
            busCount = Math.max(0, busCount - 1);

            // Update the spaces left counter
            spacesLeft = Math.min(20, spacesLeft + 1);
            spaceLeft.setText(Integer.toString(spacesLeft));
        }

        // Disable the buttons based on values
        switch (spacesLeft) {
            case 0:
                carEnter.setEnabled(false);
                busEnter.setEnabled(false);
                break;

            case 20:
                carExit.setEnabled(false);
                busExit.setEnabled(false);
                break;

            default:
                carEnter.setEnabled(true);
                busEnter.setEnabled(true);
                carExit.setEnabled(true);
                busExit.setEnabled(true);
                break;
        }

        // Disable the buttons to make sure that no cars can "sneak" out
        if (carCount == 0) {
            carExit.setEnabled(false);
        }

        if (busCount == 0) {
            busExit.setEnabled(false);
        }

        // Update the counters
        carText.setText(Integer.toString(carCount));
        busText.setText(Integer.toString(busCount));
    }
}

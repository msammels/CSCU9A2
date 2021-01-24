import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * StudentRecord
 *
 * A class to hold and manage a student record's data
 *
 * Note that this class does not have any direct appearance on the screen, and "understands" no events - that
 * is the responsibility of the associated main program GUI class
 *      - the GUI parts are in this cass
 *      - he parts managing the student's record are in class StudentRecord
 *
 * One record is displayed, for Pythagoras, and the address and credits obtained details can be updated
 *
 * @author SBJ April 2014
 * @author MIS Spring 2019
 */

public class Database extends JFrame implements ActionListener {
    // GUI variables: interface widgets
    private JButton     changeAddress,                        // Click to set the student's address from the text field
                        modulePassed,                         // Click when another module has been passed
                        twoCredits,                           // Adding two credits
                        threeCredits;                         // Adding three credits
    private JTextField  addressEntry;                         // For entering a new address
    private JTextArea   display;                              // For displaying the student's details

    private StudentRecord record, record1, record2;           // To hold the instance of class StudentRecord

    /**
     * The main method that is called when the program is run
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        Database frame = new Database();
        frame.setSize(600, 500);
        frame.createGUI();
        frame.setUpData();
        frame.setVisible(true);
    }

    /**
     * Sets up the graphical user interface
     */
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        changeAddress = new JButton("Change address to:");                     // Change address button
        window.add(changeAddress);
        changeAddress.addActionListener(this);

        addressEntry = new JTextField("Enter new address here", 20);  // New address field
        window.add(addressEntry);

        modulePassed = new JButton("Passed a module");                         // New credit button
        twoCredits = new JButton("Add two credits");
        threeCredits = new JButton("Add three credits");
        window.add(modulePassed);
        window.add(twoCredits);
        window.add(threeCredits);
        modulePassed.addActionListener(this);
        twoCredits.addActionListener(this);
        threeCredits.addActionListener(this);

        display = new JTextArea(20, 30);                              // To display the student's details
        window.add(display);
        display.setEditable(false);
        display.setFont(new Font("Sans Serif", Font.BOLD, 14));
    }

    /**
     * Sets up the initial student's details
     */
    private void setUpData() {
        // Set up the student record
        record = new StudentRecord("Pythagoras", "00214159", "Basket Weaving");
        record1 = new StudentRecord("Aristotle", "00214160", "Philosophy");
        record2 = new StudentRecord("Plato", "00214161", "Physics");


        displayDetails();   // Update the display with current details
    }

    private void displayDetails() {
        display.setText("Student record for: " + record.getName() + " \n");
        display.append("Registration number: " + record.getRegistrationNo() + "\n");
        display.append("Degree programme: " + record.getDegree() + "\n");
        display.append("Address: " + record.getAddress() + "\n");
        display.append("Credits: " + record.getCreditsObtained() + "\n");
        display.append("\n");

        display.append("Student record for: " + record1.getName() + " \n");
        display.append("Registration number: " + record1.getRegistrationNo() + "\n");
        display.append("Degree programme: " + record1.getDegree() + "\n");
        display.append("Address: " + record1.getAddress() + "\n");
        display.append("Credits: " + record1.getCreditsObtained() + "\n");
        display.append("\n");

        display.append("Student record for: " + record2.getName() + " \n");
        display.append("Registration number: " + record2.getRegistrationNo() + "\n");
        display.append("Degree programme: " + record2.getDegree() + "\n");
        display.append("Address: " + record2.getAddress() + "\n");
        display.append("Credits: " + record2.getCreditsObtained() + "\n");
        display.append("\n");


    }

    /**
     * Respond appropriately to a button click
     * @param e the event
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeAddress) {   // Change address: obtain address and set it into record
            record.setAddress(addressEntry.getText());
            addressEntry.setText("");
        }

        if (e.getSource() == modulePassed) {    // Module passed: increment the number of credits
            record.addACredit();
        }

        if (e.getSource() == twoCredits) {      // Add two credits
            record1.addMultipleCredits(2);
        }

        if (e.getSource() == threeCredits) {    // Add three credits
            record2.addMultipleCredits(3);
        }

        displayDetails();
    }
}

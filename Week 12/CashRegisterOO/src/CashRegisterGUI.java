import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * CashRegister
 *
 * This program displays a cash register graphical user interface
 * The actual cash register data is held in a separate class
 *
 * @author Michael Sammels
 * @version 25.03.2019
 */
public class CashRegisterGUI extends JFrame implements ActionListener {
    /**
     * Configuration constants for the frame size and position
     */
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;
    private static final int FRAME_X = 200;
    private static final int FRAME_Y = 200;

    /**
     * Configuration constants for the text area size
     */
    private static final int AREA_ROWS = 10;
    private static final int AREA_COLUMNS = 30;

    /**
     * Hold the GUI components
     */
    private JLabel priceLabel;
    private JTextField priceField;
    private JButton addItemButton, addItemButton2, newCustomerButton, newCustomerButton2;
    private JLabel totalDisplayR1, totalDisplayR2, itemCountDisplayR1, itemCountDisplayR2;

    /**
     * Hold the cash register key data
     */
    private CashRegister cashRegister, cashRegister2;

    /**
     * The main method that is called when the program is run
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        CashRegisterGUI frame = new CashRegisterGUI();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocation(FRAME_X, FRAME_Y);
        frame.setTitle("My Cash Register");
        frame.createGUI();
        frame.setUpData();
        frame.setVisible(true);
    }

    /**
     * This method builds the graphical user interface
     */
    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new GridLayout(5, 2));     // 5 rows and 2 columns
        setResizable(false);

        // First row
        priceLabel = new JLabel("Item price: ");
        window.add(priceLabel);

        final int FIELD_WIDTH = 5;
        priceField = new JTextField(FIELD_WIDTH);
        priceField.setText("");
        window.add(priceField);

        window.add(new JLabel());       // Dummy widget to add space

        // Second row
        addItemButton = new JButton("Add item");
        addItemButton2 = new JButton("Add item [2]");
        addItemButton.addActionListener(this);
        addItemButton2.addActionListener(this);
        window.add(addItemButton);
        window.add(new JLabel());       // Dummy widget to add space
        window.add(addItemButton2);

        // Third row
        totalDisplayR1 = new JLabel("R1 Sales total: 0");
        totalDisplayR2 = new JLabel("R2 Sales total: 0");
        window.add(totalDisplayR1);
        window.add(new JLabel());       // Dummy widget to add space
        window.add(totalDisplayR2);

        // Fourth row
        itemCountDisplayR1 = new JLabel("R1 # items: 0");
        itemCountDisplayR2 = new JLabel("R2 # items: 0");
        window.add(itemCountDisplayR1);
        window.add(new JLabel());       // Dummy widget to add space
        window.add(itemCountDisplayR2);

        // Fifth row
        newCustomerButton = new JButton("New customer");
        newCustomerButton2 = new JButton("New customer [2]");
        newCustomerButton.addActionListener(this);
        newCustomerButton2.addActionListener(this);
        window.add(newCustomerButton);
        window.add(new JLabel());       // Dummy widget to add space
        window.add(newCustomerButton2);
        //window.add(new JLabel());       // Dummy widget to add space
    }

    /**
     * This method sets up a single instance of the CashRegister class
     */
    private void setUpData() {
        cashRegister = new CashRegister();
        cashRegister2 = new CashRegister();
    }

    /**
     * React to click on Add item button by adding a new item to the cash register and updating the display. The
     * item's price is taken from the priceField. For the user's convenience, the price field is cleared, and the
     * input focus is returned to the price field ready for the next input
     * @param e The event
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addItemButton) {
            // Get the new item price and record it
            double price = Double.parseDouble(priceField.getText());
            cashRegister.addItem(price);
        }

        if (e.getSource() == addItemButton2) {
            // Get the new item price and record it
            double price = Double.parseDouble(priceField.getText());
            cashRegister2.addItem(price);
        }

        if (e.getSource() == newCustomerButton) {
            cashRegister.clearValues();
        }

        if (e.getSource() == newCustomerButton2) {
            cashRegister2.clearValues();
        }

        // Update the cash register display
        totalDisplayR1.setText("R1 Sales total:  " + cashRegister.getTotal());
        itemCountDisplayR1.setText(" R1 # items:  " + cashRegister.getCount());
        priceField.setText("");             // Clear the old entry
        priceField.requestFocusInWindow();  // And put the input focus back into the price field

        totalDisplayR2.setText("R2 Sales total:  " + cashRegister2.getTotal());
        itemCountDisplayR2.setText("R2 # items:  " + cashRegister2.getCount());
        priceField.setText("");             // Clear the old entry
        priceField.requestFocusInWindow();  // And put the input focus back into the price field

    }
}

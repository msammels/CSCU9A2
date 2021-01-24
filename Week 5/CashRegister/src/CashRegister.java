import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This program displays a cash register graphical user interface.
 *
 * @author Michael Sammels
 * @version 25.09.2019
 */

public class CashRegister extends JFrame implements ActionListener {
    /**
     * Configuration constants for the frame size
     */
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;

    /**
     * Configuration constants for the text area size
     */
    private static final int AREA_ROWS = 10;
    private static final int AREA_COLUMNS = 30;

    private JLabel totalLabel;
    private JTextField priceField, descField;
    private JTextArea itemsArea;

    private double totalPrice = 0;

    /**
     * The main launcher method
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        CashRegister frame = new CashRegister();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Cash Register");
        frame.setLocationRelativeTo(null);
        frame.createGUI();
        frame.setVisible(true);
    }

    // --------------------------------------------------------------------------------------------

    /**
     * This method builds the graphical user interface
     */
    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        JLabel descriptionLabel = new JLabel("Item description: ");
        /*
          Hold the GUI components
         */
        JLabel priceLabel = new JLabel("Item price: £");

        final int FIELD_WIDTH = 5;
        descField = new JTextField(FIELD_WIDTH);
        descField.setText("");
        descField.addActionListener(this);

        priceField = new JTextField(FIELD_WIDTH);
        priceField.setText("");
        priceField.addActionListener(this);

        window.add(descriptionLabel);
        window.add(descField);

        window.add(priceLabel);
        window.add(priceField);

        JButton addItemButton = new JButton("Add item");
        addItemButton.addActionListener(this);

        window.add(addItemButton);

        itemsArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        itemsArea.setText("");
        itemsArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(itemsArea);
        window.add(scrollPane);

        totalLabel = new JLabel("Sales total: £");
        window.add(totalLabel);
    }

    /**
     * React to click on Add item button by adding a new item to the cash register and updating the display.
     * The item's price is taken from the priceField. For the user's convenience, the price field is cleared,
     * and the input focus is returned to the price field ready for the next input.
     */
    public void actionPerformed(ActionEvent event) {
        double price = Double.parseDouble(priceField.getText());

        itemsArea.append(descField.getText() + "\t");
        addItem(price);
        itemsArea.append("£" + price + "\n");
        totalLabel.setText("Sales total: £" + getTotal());
        priceField.setText("");             // Clear the old entry
        priceField.requestFocusInWindow();  // And put the input focus back into the price field
    }

    /**
     * Adds an item to this cash register
     * @param price the price of the item
     */
    private void addItem(double price) {
        totalPrice = totalPrice + price;
    }

    private double getTotal() {
        return totalPrice;
    }
}

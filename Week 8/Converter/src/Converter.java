import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a simple temperature converter program
 *
 * @author Michael Sammels
 * @version 25.09.2019
 */

public class Converter extends JFrame implements ActionListener {
    JPanel      topPanel, guiPanel;
    JTextField  tempF;
    JLabel      resultLabel;

    /**
     * Button that initiates conversion
     */
    JButton     convertTemp;

    /**
     * Main method, called when the program runs
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        Converter myConv = new Converter();         // Creates the Swing frame and container.
        myConv.setTitle("Temperature Converter");
        myConv.setSize(400, 300);
        myConv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myConv.setVisible(true);
    }

    /**
     * Program to convert temperature from Fahrenheit to Celsius
     */
    public Converter() {                                    // Constructor
        // Now to create the GUI interface, using Swing components.

        guiPanel = new JPanel();
        guiPanel.setLayout(new BorderLayout());             // Using BorderLayout means that widgets can
                                                            // either be added to the centre
                                                            // of this panel or round the edges

        topPanel = new JPanel();                            // This "invisible panel" will hold the button and text field
        topPanel.setLayout(new FlowLayout());               // and it will lay components out from left to right

        convertTemp = new JButton("Convert");          // This is the button we'll press to convert the
                                                            // temperature from Fahrenheit to Celsius.

        // convertTemp = new JButton(new ImageIcon("fc.gif"));

        convertTemp.addActionListener(this);             // Now we can listen to events from our button.

        topPanel.add(convertTemp);                          // Adding the convertTemp button to the top panel

        tempF = new JTextField(10);                 // Creating the text field tempF
        tempF.addActionListener(this);                   // Now we can listen to events from our text field.
        topPanel.add(tempF);                               // Adding it to the top panel

        /*
        // GUI components for font size adjustment
        fontLabel = new JLabel("Font size:", SwingConstants.RIGHT);
        topPanel.add(fontLabel);

        // Firstly setting up an array of font sizes we might use
        String[] fontSizes = { "8", "10", "11", "12", "14", "16", "18", "20", };

        fontSizeChoice = new JComboBox(fontSizes);          // This JComboBox offers a drop-down menu of choices
        fontSizeChoice.addActionListener(this);             // Listens out for action events which get generated when
                                                            // we select from the choices
        topPanel.add(fontSizeChoice);
        */

        guiPanel.add(topPanel, BorderLayout.NORTH);         // This adds the top panel to the top of the GUI

        resultLabel = new JLabel("", SwingConstants.CENTER);
        // This label is where the result of
        // temperature conversion will appear
        guiPanel.add(resultLabel, BorderLayout.CENTER);     // The result label will appear in the centre of the GUI
        getContentPane().add(guiPanel);                     // Adds the panel to the application.
    }

    /*
    // This method adjusts the font sizes for various components
    private void setComponentFonts(int fontSize) {
        // Sets the font on the button
        Font f = new Font("Helvetica", Font.BOLD, fontSize);
        convertTemp.setFont(f);
    }
    */

    public void actionPerformed(ActionEvent e) {            // React to  button press, or Enter in the text field
        if (e.getSource() == convertTemp                    // If button pressed
            || e.getSource() == tempF) {                    // Or if the return key pressed (event from the text field)
            try {
                // Interpret (parse) degrees Fahrenheit as a double and convert to Celsius.
                double tempInF = Double.parseDouble(tempF.getText());
                int tempInC = (int) ((tempInF - 32) / 1.8);

                // Set resultLabel to new value
                resultLabel.setText(tempF.getText() + " degrees F converts to " + tempInC + " degrees C");
            } catch (Exception ex) {
                // Catch to handle the case where the user didn't type in
                // an understandable number
                System.out.println("No number in text field");
            }
        }

        /*
        if (e.getSource() == fontSizeChoice) {              // If a choice has been from the JComboBox
            int fontSize = Integer.parseInt((String) fontSizeChoice.getSelectedItem());
        }
        */
    }
}

/**
 * Converter
 *
 * This is a very small application which converts a temperature in degrees Fahrenheit to degrees Celsius.
 *
 * If it converted back again too, that would be more useful. This is a small application, but it does illustrate
 * a few Swing widgets, and shows you can do with them.
 *
 * @author Simon Jones, April 2014
 * @author Michael Sammels, Spring 2019
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Converter extends JFrame implements ActionListener {
    JPanel      topPanel, guiPanel;     // Some "invisible panels", or "layout areas"
    JTextField  tempF;                  // A textfield to type in the temperature
    JLabel      resultLabel, fontLabel; // A label to display the converted temperature and font label for later, when
                                        // font size choice is implemented
    JButton     convertTemp;            // The idea is, when you press the button, it converts the temperature
                                        // for you
    JComboBox   fontSizeChoice;         // To choose the size of the font
    char deg = '\u00B0';                // A use Unicode character for later on...

    // Main method, called when the program runs
    public static void main(String[] args) {
        Converter myConv = new Converter();             // Creates Swing frame and container
        myConv.setTitle("Temperature Converter");
        myConv.setSize(400, 300);
        myConv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myConv.setVisible(true);
    }

    // Class constructor (is called at new Converter() instantiation)
    public Converter() {
        // Now to create the GUI interface, using Swing components
        guiPanel = new JPanel();
        guiPanel.setLayout(new BorderLayout());         // Using BorderLayout means that widgets can either be added
        // to the centre of this panel or round the edges

        topPanel = new JPanel();                        // This "invisible panel" will hold the button and textfield
        topPanel.setLayout(new FlowLayout());           // and it will lay components from left to right

        //convertTemp = new JButton("Converter");       // This is the button we'll press to convert the temperature
                                                        // from Fahrenheit to Celsius

        convertTemp = new JButton(new ImageIcon("fc.gif"));
        System.out.println(System.getProperty("user.dir"));
        convertTemp.setToolTipText("Convert from Fahrenheit to Celsius");
        convertTemp.setMnemonic(KeyEvent.VK_C);

        convertTemp.addActionListener(this);         // Now we can listen to events from our button

        topPanel.add(convertTemp);                      // Adding the convertTemp button to the top panel

        tempF = new JTextField(10);            // Creating the textfield tempF
        tempF.addActionListener(this);               // Now we can listen to events from our textfield
        topPanel.add(tempF);                            // Adding it to the top panel

        // GUI components for font size adjustment
        fontLabel = new JLabel("Font size: ", SwingConstants.RIGHT);
        topPanel.add(fontLabel);

        // Firstly setting up an array of font sizes we might use
        String[] fontSizes = {"8", "10","11", "12", "14", "16", "18", "20"};

        fontSizeChoice = new JComboBox(fontSizes);      // This JComboBox offers a drop-down menu of choices
        fontSizeChoice.setSelectedIndex(3);             // Initial font size
        fontSizeChoice.addActionListener(this);      // Listens out for action events which get generated when we
        // select from the choices
        topPanel.add(fontSizeChoice);

        guiPanel.add(topPanel, BorderLayout.NORTH);     // This adds the top panel to the top of the GUI

        resultLabel = new JLabel("", SwingConstants.CENTER);
        // This label is where the result of the temperature conversion will appear
        guiPanel.add(resultLabel, BorderLayout.CENTER);  // The result label will appear in the centre of the GUI
        getContentPane().add(guiPanel);                 // Adds the pnael to the application
    }

    // This method adjusts the font size for various components
    private void setComponentFonts(int fontSize) {
        // Sets the font on the button
        Font f = new Font("Helvetica", Font.BOLD, fontSize);
        tempF.setFont(f);
        resultLabel.setFont(f);
        fontLabel.setFont(f);
        convertTemp.setFont(f);
        fontSizeChoice.setFont(f);
    }

    // React to button press, or Enter in the textfield
    public void actionPerformed(ActionEvent e) {
        // If the button is pressed or if the return key is pressed (event from the textfield)
        if (e.getSource() == convertTemp || e.getSource() == tempF) {
            try {
                // Interpret (parse) degrees Fahrenheit as a double and convert to Celsius.
                double tempInF = Double.parseDouble(tempF.getText());
                int tempInC = (int) ((tempInF - 32) / 1.8);

                // Set resultLabel to new value
                resultLabel.setText(tempF.getText() + deg + "F converts to " + tempInC + deg + "C");
            }
            catch (Exception ex) {
                // Catch to handle the case where the  user didn't type in an understandable number
                System.out.println("No number in textfield");
            }
        }

        if (e.getSource() == fontSizeChoice) {      // If a choice has been made from the JComboBox
            int fontSize = Integer.parseInt((String) fontSizeChoice.getSelectedItem());
            setComponentFonts(fontSize);
        }
    }
}
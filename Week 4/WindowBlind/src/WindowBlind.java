import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * This program is a Java application showing a single slider and drawing
 * a window frame with a blind adjustable using this slider.
 *
 * @author Michael Sammels
 * @version 25.05.2019
 */

public class WindowBlind extends JFrame implements ChangeListener {
    /**
     * This is the slider that appears in the display
     */
    private JSlider sliderA, sliderB;

    /**
     * This holds the current height of the blind, initially 50
     */
    private int blindHeightA = 50, blindHeightB = 50;

    /**
     * The main method is the main launch action for the WindowBlind program
     *
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        // Diagnostics
        System.out.println("Entering main method...");

        WindowBlind frame = new WindowBlind();
        frame.setSize(400, 400);
        frame.setLocation(200, 200);
        frame.createGUI();
        frame.setVisible(true);

        // Diagnostics
        System.out.println("Returning from main method...");
    }

    /**
     * The createGUI method is called by the main method to set up the graphical user interface
     */
    private void createGUI() {
        // Diagnostics
        System.out.println("Entering createGUI method...");

        // Set up the main window characteristics
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        // Create the adjustable slider, with correct initial settings
        sliderA = new JSlider(JSlider.HORIZONTAL, 0, 100, blindHeightA);
        sliderB = new JSlider(JSlider.HORIZONTAL, 0, 100, blindHeightB);

        /*
         * This is the label for the sliders
         */
        JLabel labelA = new JLabel("Slider A");
        JLabel labelB = new JLabel("Slider B");

        sliderA.setName("sliderA");
        sliderB.setName("sliderB");

        window.add(sliderA);
        window.add(labelA);

        window.add(sliderB);
        window.add(labelB);

        sliderA.addChangeListener(this);
        sliderB.addChangeListener(this);

        // Create the panel for drawing on
        // paintComponent is called automatically when a screen refresh is needed
        // g is a cleared panel area
        // Paint the panel's background
        // Then the required graphics

        /*
         * This is the panel that is drawn on
         */
        JPanel panel = new JPanel() {
            // paintComponent is called automatically when a screen refresh is needed
            public void paintComponent(Graphics g) {
                // g is a cleared panel area
                super.paintComponent(g);    // Paint the panel's background
                paintScreen(g);             // Then the required graphics
            }
        };

        panel.setPreferredSize(new Dimension(300, 300));
        panel.setBackground(Color.cyan);
        window.add(panel);

        // Diagnostics
        System.out.println("Returning from createGUI method...");
    }

    /**
     * The stateChanged method is called automatically when the slider is adjusted:
     * Fetch the setting, update blindHeight and refresh the screen
     */
    public void stateChanged(ChangeEvent e) {
        // Diagnostics
        System.out.println("Entering stateChanged method...");

        JSlider source;

        source = (JSlider) e.getSource();

        if (source.getName().equals("sliderA")) {
            blindHeightA = sliderA.getValue();
        } else if (source.getName().equals("sliderB")) {
            blindHeightB = sliderB.getValue();
        }
        repaint();  // Forces a screen refresh

        // Diagnostics
        System.out.println("Returning from stateChanged method...");
    }

    /**
     * Redraw the graphics panel when the screen is refreshed:
     * A window frame with a blind partially covering the opening
     */
    private void paintScreen(Graphics g) {
        // Diagnostics
        System.out.println("Entering paintScreen method...");

        drawWindow(g, Color.red, 120, blindHeightA);

        // Second slider
        drawWindow(g, Color.blue, 20, blindHeightB);

        // Diagnostics
        System.out.println("Returning from printScreen method...");
    }

    private void drawWindow(Graphics g, Color c, int x, int level) {
        // Diagnostics
        System.out.println("Entering drawWindow method...");

        g.setColor(c);
        g.drawRect(x, 80, 60, 100);
        g.fillRect(x, 80, 60, level);

        // Diagnostics
        System.out.println("Returning from drawWindow method...");
    }
}

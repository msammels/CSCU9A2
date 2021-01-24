import javax.swing.*;
import java.awt.*;

/**
 * A frame that shows a blank drawing area
 *
 * @author Michael Sammels
 * @version 25.05.2019
 */
public class Drawing extends JFrame {
    /**
     * Configuration constants for the position of the frame on the screen
     */
    private static final int FRAME_X = 200;
    private static final int FRAME_Y = 200;

    /**
     * Configuration constants for the frame size
     */
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    /**
     * Configuration constants for the drawing area size
     */
    private static final int DRAWING_WIDTH = 450;
    private static final int DRAWING_HEIGHT = 450;

    /**
     * The main method is the main launch action for the drawing program
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        Drawing frame = new Drawing();
        frame.setTitle("A drawing area");
        frame.setLocation(FRAME_X, FRAME_Y);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.createGUI();
        frame.setVisible(true);
    }

    /**
     * This method builds the graphical user interface - just one simple drawing panel in this application
     */
    private void createGUI() {
        // Set up main window characteristics
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();

        window.setLayout(new FlowLayout());

        // Create the panel for drawing on
        // paintComponent is called automatically when a screen refresh is needed
        // g is a cleared panel area
        // Paint the panel's background
        // Then the required graphics
        /*
         * This is the panel that is drawn on
         */
        JPanel drawingArea = new JPanel() {
            // paintComponent is called automatically when a screen refresh is needed
            public void paintComponent(Graphics g) {
                // g is a cleared panel area
                super.paintComponent(g);    // Paint the panel's background
                paintScreen(g);             // Then the required graphics
            }
        };
        drawingArea.setPreferredSize(new Dimension(DRAWING_WIDTH, DRAWING_HEIGHT));
        drawingArea.setBackground(Color.white);
        window.add(drawingArea);
    }

    /**
     * Redraw the drawing panel when the screen is refreshed
     */
    private void paintScreen(Graphics g) {
        // Put drawing instructions here, e.g.

        // To draw outer house
        g.drawLine(50, 300, 375, 300);     //  Line 1   Flooring of the house
        g.drawLine(80, 300, 80, 150);      //  Line 2   Left wall of outer house
        g.drawLine(200, 300, 200, 150);    //  Line 3   Right wall of outer house
        g.drawLine(50, 170, 140, 110);     //  Line 4   Left inclination of the roof
        g.drawLine(140, 110, 230, 170);    //  Line 5   Right inclination of the roof

        // To draw entrance(door frame)
        g.drawLine(110, 220, 110, 300);    //  Line 6   Entrance left
        g.drawLine(170, 220, 170, 300);    //  Line 7   Entrance right
        g.drawLine(110, 220, 170, 220);    //  Line 8   Entrance top

        // To draw the man
        g.drawLine(320, 280, 300, 300);    // Line 9    Left leg
        g.drawLine(320, 280, 340, 300);    //  Line 10  Right leg
        g.drawLine(320, 280, 320, 250);    //  Line 11   Body
        g.drawLine(300, 270, 320, 250);    //  Line 12   Left hand
        g.drawLine(340, 270, 320, 250);    //  Line 13   Right hand
        g.drawOval(310, 230, 20, 20);  //   Head
    }
}

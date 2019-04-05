import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;

/**
 * TextTwist is a game requiring the user to find the words contained in a given word.
 *
 * @author Eileen Bohen
 * @version Spring 2019
 */
public class TextTwist extends JPanel implements MouseListener {
    private int width;
    private int height;
    private Toolkit toolkit;
    private Image background;
    private ArrayList<String> givenWord;
    private ArrayList<String> secretWords1;
    private ArrayList<String> secretWords2;
    private ArrayList<String> secretWords3;

    /**
     * Constructor for objects of class TextTwist
     */
    public TextTwist() {
        setPreferredSize(new Dimension(500, 500));

        width = getPreferredSize().width;
        height = getPreferredSize().height;
        addMouseListener( this );
        givenWord.add("DARKEN");


    }

    /**
     * PaintComponent method for JPanel.
     *
     * @param  g   the Graphics object for this applet
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, 500, 500, this);

    }

    /**
     * Creates the window and GUI
     *
     */
    public static void createAndShowGUI(){
        //Create and set up the window.
        JFrame frame = new JFrame("Text Twist");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add label
        TextTwist panel = new TextTwist();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public void mouseEntered( MouseEvent e ) { }

    public void mouseExited( MouseEvent e ) { }

    public void mousePressed( MouseEvent e ) { }

    public void mouseReleased( MouseEvent e ) { }

    public void mouseWheelMoved( MouseWheelEvent e ){
    }
    public void mouseClicked( MouseEvent e ) {
    }


    /**
     * Main method to run program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

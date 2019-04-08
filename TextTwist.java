import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
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
    private Image image1;
    private Rectangle twist = new Rectangle(240, 300, 60, 30);
    private Rectangle twist2 = new Rectangle(242, 302, 56, 26);
    private boolean twistHighlight = false;
    private Rectangle enter = new Rectangle(310, 300, 60, 30);
    private Rectangle enter2 = new Rectangle(312, 302, 56, 26);
    private Rectangle lastWord = new Rectangle(380, 300, 60, 30);
    private Rectangle lastWord2 = new Rectangle(382, 302, 56, 26);
    private Rectangle clear = new Rectangle(450, 300, 60, 30);
    private Rectangle clear2 = new Rectangle(452, 302, 56, 26);
    private Ellipse2D.Double circ1 = new Ellipse2D.Double(230, 220, 40, 40);
    private Ellipse2D.Double circ2 = new Ellipse2D.Double(290, 220, 40, 40);
    private Ellipse2D.Double circ3 = new Ellipse2D.Double(350, 220, 40, 40);
    private Ellipse2D.Double circ4 = new Ellipse2D.Double(410, 220, 40, 40);
    private Ellipse2D.Double circ5 = new Ellipse2D.Double(470, 220, 40, 40);
    private Ellipse2D.Double circ6 = new Ellipse2D.Double(530, 220, 40, 40);

    /**
     * Constructor for objects of class TextTwist
     */
    public TextTwist() {
        setPreferredSize(new Dimension(600, 500));
        toolkit = Toolkit.getDefaultToolkit();
        image1 = toolkit.getImage("BG.jpg");
        setBackground(Color.WHITE);
        width = getPreferredSize().width;
        height = getPreferredSize().height;
        addMouseListener( this );
        //givenWord.add("DARKEN");

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
        g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
        g.drawImage(image1, 0, 0, this);
        g.setColor(Color.WHITE);
        ((Graphics2D)g).fill(twist);
        ((Graphics2D)g).fill(enter);
        ((Graphics2D)g).fill(lastWord);
        ((Graphics2D)g).fill(clear);
        g.drawRect(220, 120, 60, 60);
        g.drawRect(280, 120, 60, 60);
        g.drawRect(340, 120, 60, 60);
        g.drawRect(400, 120, 60, 60);
        g.drawRect(460, 120, 60, 60);
        g.drawRect(520, 120, 60, 60);
        ((Graphics2D)g).fill(circ1);
        ((Graphics2D)g).fill(circ2);
        ((Graphics2D)g).fill(circ3);
        ((Graphics2D)g).fill(circ4);
        ((Graphics2D)g).fill(circ5);
        ((Graphics2D)g).fill(circ6);
        g.drawString("SCORE", 220, 370);
        g.drawString("TIME", 220, 450);
        g.setColor(Color.YELLOW);
        ((Graphics2D)g).fill(twist2);
        ((Graphics2D)g).fill(enter2);
        ((Graphics2D)g).fill(lastWord2);
        ((Graphics2D)g).fill(clear2);
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

    public void mouseEntered( MouseEvent e ) { 
        int x = e.getX();
        int y = e.getY();
        if (twist.contains(x,y)) {
            twistHighlight = true;
            repaint();
        }
        else 
            twistHighlight = false;
    }

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

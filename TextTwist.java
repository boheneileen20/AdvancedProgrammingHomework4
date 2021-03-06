import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.*;
/**
 * TextTwist is a game requiring the user to find the words 
 * contained in a given word.
 *
 * @author Eileen Bohen Josh Rosenthal Greg MacGown
 * @version Spring 2019
 */
public class TextTwist extends JPanel implements MouseListener {
    /**
     * Variable to maintain JPanel
     */
    private int width;
    /**
     * Variable to maintain JPanel
     */
    private int height;
    /**
     * Object to maintain JPanel
     */
    private Toolkit toolkit;
    /**
     * Object to maintain JPanel
     */
    private Image background;
    /**
     * Object used to keep track of words and gameplay
     */
    Rectangle twist = new Rectangle(220, 280, 70, 50);
    /**
     * Object used to keep track of words and gameplay
     */
    Rectangle twist2 = new Rectangle(222, 282, 66, 46);
    /**
     * Object used to keep track of words and gameplay
     */
    Rectangle enter = new Rectangle(300, 280, 70, 50);
    /**
     * Object used to keep track of words and gameplay
     */
    Rectangle enter2 = new Rectangle(302, 282, 66, 46);
    /**
     * Object used to keep track of words and gameplay
     */
    Rectangle lastWord = new Rectangle(380, 280, 70, 50);
    /**
     * Object used to keep track of words and gameplay
     */
    Rectangle lastWord2 = new Rectangle(382, 282, 66, 46);
    /**
     * Object used to keep track of words and gameplay
     */
    Rectangle clear = new Rectangle(460, 280, 70, 50);
    /**
     * Object used to keep track of words and gameplay
     */
    Rectangle clear2 = new Rectangle(462, 282, 66, 46);
    /**
     * Object used to keep track of words and gameplay
     */
    Rectangle enterText = new Rectangle(220, 120, 360, 60);
    /**
     * Object used to keep track of words and gameplay
     */
    private ArrayList<String> wordConfig = new ArrayList();
    /**
     * Object used to keep track of words and gameplay
     */
    private Image image1;
    /**
     * Variable used to keep track of words and gameplay
     */
    private boolean twistHighlight = false;
    /**
     * Object used to keep track of words and gameplay
     */
    private static TextTwistDriver tTD;
    /**
     * Object used to keep track of words and gameplay
     */
    private String text = "";
    /**
     * Object used to keep track of words and gameplay
     */
    private String previousWord = "";
    /**
     * Boolean that tracks if player wins
     */
    private boolean won = false;
    /**
     * String used to draw score
     */
    private String score = "0";
    /**
     * Boolean used to improve functionality of buttons
     */
    private boolean clearText = false;
    /**
     * Boolean used to improve functionality of buttons
     */
    private boolean showPreviousWord = false;

    /**
     * Constructor for objects of class TextTwist
     */
    public TextTwist() {
        //sets size of window
        setPreferredSize(new Dimension(600, 500));
        toolkit = Toolkit.getDefaultToolkit();
        //sets graphics of window
        image1 = toolkit.getImage("BG.jpg");
        setBackground(Color.WHITE);
        width = getPreferredSize().width;
        height = getPreferredSize().height;
        //adds functionality of mouse
        addMouseListener( this );
        String letters = tTD.returnLetters();
        wordConfig.add(letters);

    }

    /**
     * PaintComponent method for JPanel.
     *
     * @param  g The graphics object for this applet
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image1, 0, 0, this);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
        g.setColor(Color.WHITE);
        // Create boxes under word buttons
        ((Graphics2D)g).fill(twist);
        ((Graphics2D)g).fill(enter);
        ((Graphics2D)g).fill(lastWord);
        ((Graphics2D)g).fill(clear);
        // Create boxes above word buttons
        g.drawRect(220, 120, 60, 60);
        g.drawRect(280, 120, 60, 60);
        g.drawRect(340, 120, 60, 60);
        g.drawRect(400, 120, 60, 60);
        g.drawRect(460, 120, 60, 60);
        g.drawRect(520, 120, 60, 60);
        // Create word buttons
        Ellipse2D.Double circ1 = new Ellipse2D.Double(230, 220, 40, 40);
        Ellipse2D.Double circ2 = new Ellipse2D.Double(290, 220, 40, 40);
        Ellipse2D.Double circ3 = new Ellipse2D.Double(350, 220, 40, 40);
        Ellipse2D.Double circ4 = new Ellipse2D.Double(410, 220, 40, 40);
        Ellipse2D.Double circ5 = new Ellipse2D.Double(470, 220, 40, 40);
        Ellipse2D.Double circ6 = new Ellipse2D.Double(530, 220, 40, 40);
        ((Graphics2D)g).fill(circ1);
        ((Graphics2D)g).fill(circ2);
        ((Graphics2D)g).fill(circ3);
        ((Graphics2D)g).fill(circ4);
        ((Graphics2D)g).fill(circ5);
        ((Graphics2D)g).fill(circ6);
        // Create score
        g.drawString("SCORE", 220, 370);
        g.drawString(score, 220, 410);
        // Create time
        g.drawString("TIME", 220, 450);
        g.setColor(Color.YELLOW);
        ((Graphics2D)g).fill(twist2);
        ((Graphics2D)g).fill(enter2);
        ((Graphics2D)g).fill(lastWord2);
        ((Graphics2D)g).fill(clear2);
        // read meta to make boxes for undiscovered words
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        g.drawString("TWIST", 226, 310);
        g.drawString("ENTER", 306, 310);
        g.drawString("LAST", 388, 300);
        g.drawString("WORD", 388, 315);
        g.drawString("CLEAR", 462, 310);
        g.setColor(Color.YELLOW);
        String meta = tTD.getMeta();
        Scanner s = new Scanner(meta);
        int threeLetter = s.nextInt();
        int fourLetter = s.nextInt();
        int fiveLetter = s.nextInt();
        int sixLetter = s.nextInt();
        int startX = 5;
        int startY = 10;
        int space = 21;
        final int WIDTH = 15;
        final int MAX3 = 5;
        final int OFFSET = 65;
        int count = 0;
        g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        //produces boxes for 3 letter words
        for (int i = 0; i < threeLetter; i++) {
            for (int j = 0; j < 3; j++) {
                if(i>=MAX3){
                    g.fillRect(startX + (j * space) + OFFSET + 10,
                        startY + ((i-MAX3) * space), WIDTH, WIDTH);
                    if (tTD.sols[count]) {
                        g.setColor(Color.BLACK);
                    }
                    g.drawString(Character.toString(tTD.words.get(count).charAt(j)),
                        startX + (j * space) + OFFSET + 12, startY + ((i-MAX3) * space) + 11);
                    g.setColor(Color.YELLOW);
                }
                else{
                    g.fillRect(startX + (j * space), startY + (i * space),
                        WIDTH, WIDTH);
                    if (tTD.sols[count]) {
                        g.setColor(Color.BLACK);
                    }
                    g.drawString(Character.toString(tTD.words.get(count).charAt(j)),
                        startX + (j * space) + 2, startY + (i * space) + 11);
                    g.setColor(Color.YELLOW);
                }
            }
            count++;
        }
        if (threeLetter > MAX3) 
            startY = startY + (MAX3*WIDTH) + (MAX3*6);
        else 
            startY = startY + (threeLetter*WIDTH) + (threeLetter*6);
        //produces boxes for 4 letter words
        for (int i = 0; i < fourLetter; i++) {
            for (int j = 0; j < 4; j++) {
                g.fillRect(startX + (j * space), startY + (i * space),
                    WIDTH, WIDTH);
                if (tTD.sols[count]) {
                    g.setColor(Color.BLACK);
                }
                g.drawString(Character.toString(tTD.words.get(count).charAt(j)),
                    startX + (j * space) + 2, startY + (i * space) + 11);
                g.setColor(Color.YELLOW);
            }
            count++;
        }
        startY = startY + (fourLetter*WIDTH) + (fourLetter*6);
        //produces boxes for 5 letter words
        for (int i = 0; i < fiveLetter; i++) {
            for (int j = 0; j < 5; j++) {
                g.fillRect(startX + (j * space), startY + (i * space), 
                    WIDTH, WIDTH);
                if (tTD.sols[count]) {
                    g.setColor(Color.BLACK);
                }
                g.drawString(Character.toString(tTD.words.get(count).charAt(j)),
                    startX + (j * space) + 2, startY + (i * space) + 11);
                g.setColor(Color.YELLOW);
            }
            count++;
        }
        startY = startY + (fiveLetter*WIDTH) + (fiveLetter*6);
        //produces boxes for 6 letter words
        for (int i = 0; i < sixLetter; i++) {
            for (int j = 0; j < 6; j++) {
                g.fillRect(startX + (j * space), startY + (i * space),
                    WIDTH, WIDTH);
                if (tTD.sols[count]) {
                    g.setColor(Color.BLACK);
                }
                g.drawString(Character.toString(tTD.words.get(count).charAt(j)),
                    startX + (j * space) + 2, startY + (i * space) + 11);
                g.setColor(Color.YELLOW);
            }
            count++;
        }
        g.setFont(new Font("TimesRoman", Font.PLAIN, 24));

        g.setColor(Color.BLACK);
        g.drawString(wordConfig.get(0).substring(0, 1).toUpperCase(), 242, 247);
        g.drawString(wordConfig.get(0).substring(1, 2).toUpperCase(), 302, 247);
        g.drawString(wordConfig.get(0).substring(2, 3).toUpperCase(), 362, 247);
        g.drawString(wordConfig.get(0).substring(3, 4).toUpperCase(), 422, 247);
        g.drawString(wordConfig.get(0).substring(4, 5).toUpperCase(), 482, 247);
        g.drawString(wordConfig.get(0).substring(5).toUpperCase(), 542, 247);

        //draw text to screen (user guess)
        if(!clearText && !showPreviousWord){
            ArrayList<String> textLetters = new ArrayList<>();
            for(int i = 0; i<text.length(); i++){
                textLetters.add(text.substring(i,i+1));
            }
            textLetters.add(text.substring(text.length()));
            int textStartx = 230;
            int textStarty = 175;
            int textSpace = 60;

            g.setFont(new Font("TimesRoman", Font.PLAIN, 60));
            for(int i = 0; i<textLetters.size(); i++){
                g.drawString(textLetters.get(i).toUpperCase(), 
                    textStartx + textSpace*i, textStarty);
            }
        }

        clearText = false;

        //if the user has selected last word, show previous word
        if(showPreviousWord){
            ArrayList<String> previousLetters = new ArrayList<>();
            for(int i = 0; i<previousWord.length(); i++){
                previousLetters.add(previousWord.substring(i,i+1));
            }
            previousLetters.add(previousWord.substring(previousWord.length()));
            int textStartx = 230;
            int textStarty = 175;
            int textSpace = 60;

            g.setFont(new Font("TimesRoman", Font.PLAIN, 60));
            for(int i = 0; i<previousLetters.size(); i++){
                g.drawString(previousLetters.get(i).toUpperCase(),
                    textStartx + textSpace*i, textStarty);
            }
        }

        showPreviousWord = false;

        //if won make popup to notify winning
        if (won) 
            win();

        if (tTD.winner()) {
            won = true;
            repaint();
        }
    }

    /**
     * This makes a dialog box appear stating the player has won.
     * 
     */
    public void win() {
        JOptionPane.showMessageDialog(null, "YOU WIN");
    }

    /**
     * This randomizes the letters that the user can choose from.
     * 
     */
    public void randomizeLetters() {
        wordConfig.remove(0);
        wordConfig.add(tTD.randomize());
        repaint();
    }

    /**
     * Clears the users guess from the screen
     * 
     */
    public void clearLetters() {
        clearText = true;
        text = "";
        repaint();
    }

    /**
     * Clears the users guess from the screen
     * 
     */
    public void showPrevious() {
        showPreviousWord = true;
        text = previousWord;
        repaint();
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

    /**
     * This makes the mouse do nothing when entering the panel.
     * 
     * @param e The event the mouse triggers
     * 
     */
    public void mouseEntered( MouseEvent e ) { }

    /**
     * This makes the mouse donothing when leaving the panel.
     * 
     * @param e The event the mouse triggers.
     * 
     */
    public void mouseExited( MouseEvent e ) { }

    /**
     * This makes the mouse do nothing when pressed down.
     * 
     * @param e The event the mouse triggers.
     * 
     */
    public void mousePressed( MouseEvent e ) { }

    /**
     * This makes nothing happen when the button is released.
     * 
     * @param e   the event the mouse triggers.
     * 
     */
    public void mouseReleased( MouseEvent e ) { }

    /**
     * This makes the mouse do nothing when moved.
     * 
     * @param e The event the mouse triggers.
     * 
     */
    public void mouseWheelMoved( MouseWheelEvent e ){ }

    /**
     * 
     * The user can type the word after clicking a button above the letters.
     * 
     * @param e The event the mouse triggers
     * 
     */
    public void mouseClicked( MouseEvent e ) {
        if (enter.contains(e.getPoint()) || enterText.contains(e.getPoint())) {
            JOptionPane jPane = new JOptionPane(text);
            previousWord = text;
            text = jPane.showInputDialog("Enter text");
            int pos = tTD.words.indexOf(text);
            if (tTD.checkInput(text) &&tTD.sols[pos]) {
                score = String.valueOf(tTD.score);
                repaint();
            }
        }
        if (twist.contains(e.getPoint())){
            randomizeLetters();
        }
        if (clear.contains(e.getPoint())){
            clearLetters();
        }
        if(lastWord.contains(e.getPoint())){
            showPrevious();
        }
    }

    /**
     * Main method to run program, please use "0", "1", or "2" to
     * select which text document to use
     *
     * @param args Determines text document used.
     */
    public static void main(String[] args) {
        String file = "";
        if(args[0].equals("0")){
            file = "reggor.txt";
        }
        else if(args[0].equals("1")){
            file = "kandre.txt";
        }
        else if(args[0].equals("2")){
            file = "usatel.txt";
        }
        else{
            String err = "To play the game, you must provide an input ";
            err += "argument. Enter 0,1, or 2.";
            System.err.println(err);
        }

        tTD = new TextTwistDriver(file);

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }
}

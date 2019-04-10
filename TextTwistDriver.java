import java.util.*;
import java.io.*;
/**
 * Class which provides a simple implementation of the
 * TextTwister game with no graphics. Methods to be used when
 * graphics are set up to keep game running. 
 *
 * @author Greg MacGown
 * @version 4/8/19
 */
public class TextTwistDriver
{
    public String[] letters;
    public ArrayList<String> words;
    private int size1;
    public boolean[] sols;
<<<<<<< HEAD
    public static String meta;
=======
    private int three;
    private int four;
    private int five;
    private int six;
    private int total; //temporary variable to keep track of words to be removed in final implementation
>>>>>>> 43756b3a7a0f22ef23b04385cf69a48b2bc57e30

    /**
     * Constructor for objects of class TextTwistDriver
     * 
     * @param fileName String of file to be read in
     */
    public TextTwistDriver(String fileName) 
    {
        try {
            //Declare variables and initialize objects
            three = 0;
            four = 0;
            five = 0;
            six = 0;
            letters = new String[6];
            words = new ArrayList<String>();
            Scanner s = new Scanner(new File(fileName));
            meta = s.nextLine();

            //Read in letters
            for (int i = 0; i < 6; i++) {
                letters[i] = s.next();   
            }

            //Read in words
            while (s.hasNext()) {
                String word = s.next();
                if (word.length() == 3) three++;
                if (word.length() == 4) four++;
                if (word.length() == 5) five++;
                if (word.length() == 6) six++;
                words.add(word);
            }
            s.close();
            size1 = words.size();
            total = size1;
            sols = new boolean[size1];
        }
        catch (FileNotFoundException e){
            System.err.println("File not found");
        }
    }
    
    /**
     * Method which checks to see if every word has been found
     * 
     * @return boolean whether every value in sols is true
     */
    public boolean winner() { 
        for (int i = 0; i < size1; i++) {
            if (sols[i] == false) return false;
        }
        return true;
    }

    
    /**
     * Method which checks to see if input string matches
     * with any words in the words array
     * @param input String to be compared to words in words array
     * @return boolean if input is contained in words array
     */
    public boolean checkInput(String input) {
        for (int i = 0; i < size1; i++) {
            if (input.equals(words.get(i))) {
                return true;   
            }
        }
        return false;
    }
    
    
    /**
     * Getter methods which return their respective variables
     * which represent the number of words of that numbers length
     * 
     * @return number of words of num length
     */
    public int getThree() {return three;}
    
    public int getFour() {return four;}
    
    public int getFive() {return five;}
    
    public int getSix() {return six;}
    
    public int getTotal() { return total;}

<<<<<<< HEAD
    public void printLetters() {
        for (int i = 0; i < 6; i++) {
            System.out.print(letters[i] + " "); 
        }
        System.out.println();
    }

    public void printWords() {
        for (int i = 0; i < words.size(); i++) {
            System.out.print(words.get(i) + " ");   
        }
    }
    
    public static String getMeta() {
        return meta;
    }

=======
    // Main method used for general testing
>>>>>>> 43756b3a7a0f22ef23b04385cf69a48b2bc57e30
    public static void main (String args[]) {
        TextTwistDriver test = new TextTwistDriver("usatel.txt");
        System.out.println(getMeta());
        Scanner s = new Scanner(System.in);
        do {
            if (test.checkInput((String)s.next()) == true) {
                test.total--;
                System.out.print("Word found! "+test.getTotal() +" words remaining"); 
            }
        }while (!test.winner());
        System.out.println("You are a winner!");
    }
}


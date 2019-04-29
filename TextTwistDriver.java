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
    /**
     * String array that stores the letters for the puzzle
     */
    public String[] letters;
    /**
     * String arraylist that stores the words for the puzzle
     */
    public ArrayList<String> words;
    /**
     * Variable for faster access to arraylist size
     */
    private int size1;
    /**
     * Boolean array that is used to track already found answers
     */
    public boolean[] sols;
    /**
     * String that stores number of each length of word for puzzle
     */
    public static String meta;
    /**
     * Ints that are obtained from metadata
     * Hold how many of their respective number - length words
     */
    private int three;
    private int four;
    private int five;
    private int six;
    /**
     * Variable that tracks the player's score
     */
    public int score;

    /**
     * Constructor for objects of class TextTwistDriver
     * Initializes needed variables for gameplay
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
            score = 0;
            letters = new String[6];
            words = new ArrayList<String>();
            Scanner s = new Scanner(new File(fileName));

            //Read in meta-data
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
     * 
     * @param input String to be compared to words in words array
     * @return boolean if input is contained in words array
     */
    public boolean checkInput(String input) {
        for (int i = 0; i < size1; i++) {
            if (input.equals(words.get(i)) && ! sols[i]) {
                sols[i] = true;
                if (input.length() == 3)
                    score += 90;
                if (input.length() == 4)
                    score += 140;
                if (input.length() == 5)
                    score += 250;
                if (input.length() == 6)
                    score += 360;
                return true;   
            }
        }
        return false;
    }

    /**
     * Method which randomizes the six given letters
     * and returns them in a random order in a string
     * 
     * @return random String that has the six letters in 
     *  a different order than the initial
     */
    public String randomize() {
        String[] lett = new String[6];
        String random = "";
        boolean[] used = new boolean[6];
        Random rand = new Random();
        while (checkFalse(used)){ 
            int next = rand.nextInt(6);
            if (used[next] == false){ 
                lett[next] = letters[next];
                random += letters[next];
                used[next] = true;
            }
        }
        for (int i = 0; i < 6; i++) {
            letters[i] = lett[i];
        }
        return random;
    }

    /**
     * Helper method which checks to see any array indexes
     * in the given boolean array are false, returning true if
     * a false value is found and true in all other cases
     * 
     * @param test boolean array to be checked for false values
     * @return falseFound boolean indicating if test contains any falses
     */
    public boolean checkFalse(boolean[] test) {
        boolean falseFound = false;
        for (int i = 0; i < test.length; i++) {
            if (test[i] == false) {
                falseFound = true;
                break;
            }
        }
        return falseFound;
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
    
    public int getScore() {return score;}

    /**
     * Prints each letter in the letters arrayList
     */
    public void printLetters() {
        for (int i = 0; i < 6; i++) {
            System.out.print(letters[i] + " "); 
        }
        System.out.println();
    }

    /**
     * Prints each word in words arrayList
     */
    public void printWords() {
        for (int i = 0; i < words.size(); i++) {
            System.out.print(words.get(i) + " ");   
        }
    }

    /**
     * Returns the letters the user can choose from.
     * 
     * @return lett String of letters for user to select
     */
    public String returnLetters() {
        String lett = "";
        for (int i = 0; i < 6; i++) {
            lett+= letters[i];
        }
        return lett;
    }

    /**
     * This returns the meta data.
     * 
     * @return String Meta data for how many of each length word
     */
    public static String getMeta() {
        return meta;
    }
}

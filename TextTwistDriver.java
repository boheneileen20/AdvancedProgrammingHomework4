import java.util.*;
import java.io.*;
/**
 * Write a description of class TextTwistDriver here.
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

    /**
     * Constructor for objects of class TextTwistDriver
     */
    public TextTwistDriver(String fileName) 
    {
        try {

            letters = new String[6];
            words = new ArrayList<String>();
            Scanner s = new Scanner(new File(fileName));

            //Read in letters
            for (int i = 0; i < 6; i++) {
                letters[i] = s.next();   
            }

            //Read in words
            while (s.hasNext()) {
                words.add(s.next());
            }
            size1 = words.size();
            sols = new boolean[size1];
        }
        catch (FileNotFoundException e){
            System.err.println("File not found");
        }
    }

    public boolean winner() { 
        for (int i = 0; i < size1; i++) {
            if (sols[i] == false) return false;
        }
        return true;
    }

    public boolean checkInput(String input) {
        for (int i = 0; i < size1; i++) {
            if (input.equals(words.get(i))) {
                sols[i] = true;
                return true;   
            }
        }
        return false;
    }

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

    public static void main (String args[]) {
        TextTwistDriver test = new TextTwistDriver("usatel.txt");
        Scanner s = new Scanner(System.in);
        do {
            test.checkInput((String)s.next());
        }while (!test.winner());
        System.out.println("You are a winner!");
    }
}

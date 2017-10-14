import java.util.Scanner;
import java.util.*;

/**
 *  Determines count of unique bit sequences that can be obtained for given length 
 *  without any concurrent zeros in sequence
 *
 *  Through analysis found that the count of such sequences follows fabonacii pattern
 *
 * @author Siddharth Bhatia
 */
public class BinarySubstream
{    
    HashMap<Integer, Integer> savedValues;

    BinarySubstream() {
        savedValues = new HashMap<Integer, Integer>();        
    }

    /**
     * Determines fabonacii value for any number
     *
     * @param bSL : binary substream length, Indicates length of bit string for 
     * which count of sequences is to be determined
     * 
     * @returns : fabonacii value for length bSL
     */
    public int fabonacii(int bSL)
    {
        if(bSL == 0) {
            return 1;
        } else if(bSL == 1) {
            return 2;
        }

        if(savedValues.containsKey(bSL)) {
            return savedValues.get(bSL);
        }

        int value =  fabonacii(bSL - 1) + fabonacii(bSL - 2);

        savedValues.put(bSL, value);
        return value;
    }

    /**
     * Accepts console argument indicating binary substream length
     *
     * @returns : null
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        BinarySubstream m = new BinarySubstream();  

        if (t == 0) {
            System.out.println(0);
        }
        else {
            System.out.println(m.fabonacii(t));
        }


    }
}

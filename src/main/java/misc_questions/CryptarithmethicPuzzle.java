package misc_questions;

import java.util.HashMap;
import java.util.Map;

public class CryptarithmethicPuzzle {
    /*
    * A cryptarithmetic puzzle is a mathematical game where the digits of some numbers are represented by letters.
    * Each letter represents a unique digit.

        For example, a puzzle of the form:

          SEND
        + MORE
        --------
         MONEY
may have the solution: {'S': 9, 'E': 5, 'N': 6, 'D': 7, 'M': 1, 'O', 0, 'R': 8, 'Y': 2}
Given a three-word puzzle like the one above, create an algorithm that finds a solution.
* */
    // PERMUTATION: NOT OPTIMIZED !
    /* Tip: One great tip for writing a backtracking function is to abstract away the details of
    managing the configuration (what choices are available, making a choice, checking for success, etc.)
    into other helper functions so that the body of the recursion itself is as clean as can be.
    This helps to make sure you have the heart of the algorithm correct and allows the other pieces to be developed,
    test, and debugged independently.*/
    public Map<Character, Integer> findSolutionWithExhaustiveRecursion(String op1, String op2, String res){
        char [] digits = new char[10];
        for(int i = 0; i < 10; i++) digits[i] = 0;

        char [] leadingDigits = new char[3]; // the digits that cannot be zero by nature
        leadingDigits[0] = op1.charAt(0);
        leadingDigits[1] = op2.charAt(0);
        leadingDigits[2] = res.charAt(0);

        String sb = op1 + op2 + res;
        Map<Character, Integer> hm = new HashMap<>();
        String remainingChars = "";
        for(int i = 0; i < sb.length(); i++){
            if(!hm.containsKey(sb.charAt(i))) {
                remainingChars = remainingChars + sb.charAt(i);
                hm.put(sb.charAt(i), -1);
            }
        }

        if(exhaustiveRecursion(remainingChars, hm, digits, op1, op2, res, leadingDigits)){
            System.out.println("Solution found");
        } else {
            System.out.println("No solution worked");
        }
        return hm;
    }

    /*A smarter algorithm could take into account the structure of the puzzle and avoid going
    down dead-end paths. For example, if we assign the characters starting from the ones place
    and moving to the left, at each stage, we can verify the correctness of what we have so far
    before we continue onwards. */
    public Map<Character, Integer> findSolutionWithSmartChecks(String op1, String op2, String res){
        Map<Character, Integer> hm = new HashMap<>();
        
        return hm;
    }

    private boolean exhaustiveRecursion(String remainingChars,
                                        Map<Character, Integer> hm,
                                        char[] digits,
                                        String op1, String op2, String res,
                                        char[] leadingDigits) {
        if(remainingChars.equals("")) {
            if(convert(res, hm) == convert(op1, hm) + convert(op2, hm))
                return true;
        } else {
            for(int i = 0; i < 10; i++){  // try every unused digit
                if(digits[i] == 0) { // unused
                    digits[i] = remainingChars.charAt(0);
                    hm.put(remainingChars.charAt(0), i);
                    if (zeroControlOk(hm, leadingDigits) &&
                            exhaustiveRecursion(remainingChars.substring(1), hm, digits, op1, op2, res, leadingDigits))
                        return true;
                    digits[i] = 0;
                    hm.remove(remainingChars.charAt(0));
                }
            }
        }
        return false; // nothing worked
    }

    private boolean zeroControlOk(Map<Character, Integer> hm, char[] leadingDigits) { // M and S cannot be zero, they are leading digits
        if(hm.getOrDefault(leadingDigits[0], 99) == 0 ||
                hm.getOrDefault(leadingDigits[1], 99   ) == 0 ||
                hm.getOrDefault(leadingDigits[2], 99   ) == 0) return false;
        else return true;
    }

    public int convert(String s, Map<Character,Integer> hm){
        int res = 0;
        for(char c: s.toCharArray()){
            res = res * 10 + hm.get(c);
        }
        return res;
    }

}

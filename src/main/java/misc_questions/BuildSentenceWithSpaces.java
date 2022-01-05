package misc_questions;

import java.util.HashMap;
import java.util.Map;

public class BuildSentenceWithSpaces {
    /*  Very basic question
    * Just build a sentence like following:
    * inputString: "iamflying"
    * output: "i am flying"
    *
    *  - You may use a dictionary structure as you like
    *  - Be careful about the nested words and possible wrong choices of yours
    * Example dictionary for iamflying is:  "i" "a" "iam" "flying" */
    Map<String, Integer> hm;
    StringBuilder sb;

    BuildSentenceWithSpaces(Map<String, Integer> hm){
        this.hm = hm;
    }

    public boolean buildSentenceRec(String s) {
        if(s.length() == 0) return true;

        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(hm.containsKey(s.substring(i, j + 2))) {
                sb.append(s.substring(i, j + 2)).append(" ");
                if(!buildSentenceRec(s.substring(j + 1))) {
                    sb.delete(sb.length() - (j + 2 - i), sb.length()); //rmv space + last word
                }
            }
            j++;
        }
        if(j != s.length()) return false;
        else return true;
    }

    public String getString(){
        return sb.toString();
    }
}

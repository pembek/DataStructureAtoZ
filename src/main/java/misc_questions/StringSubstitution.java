package misc_questions;

import java.util.HashMap;
import java.util.List;

public class StringSubstitution {

    // Let's build a class that will support string substitution operations
    // example operations are:
    /* OP.     Replacing String
    * "USER" -> "admin"
    * "HOME" -> "Users/%USER%"
    *
    * Input: "%HOME%"  Output: Users/admin
    *
    * BE CAREFUL!!: the order of the substitution operations matter!
    * What would you do to eliminate problems that it possibly cause?
    *
    * Another example:
    * OP.      New Strings
    * "%X%" -> "%Y%"
    * "%Y%" -> "%X%"
    *
    * Input: "%X%" Output: ?
    *
    * BE CAREFUL: What if the substitution operations form a cycle?
    * What would be your action to prevent an endless loop performing substitutions in that case?
    * hint: finding cycle on graph ?
    *  */
    List<String> replaceList;
    List<String> newStrings;
    HashMap<String, String> hm;

    // TODO that implementation can be developed, use forest instead off just adding to end
    // (use separate trees representing subs. operations that needs each other, then you can add
    // all the trees, dependants coming first than their dependees, in a list following each other)
    public void sortingRequests() {
        int l = replaceList.size();

        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                hm.put(replaceList.get(i), newStrings.get(j));
                if(newStrings.get(j).indexOf(replaceList.get(i)) >= 0) {
                    if(hm.get(newStrings.get(j)) == replaceList.get(i)) {
                        //throw exception
                    }
                    replaceList.remove(i);
                    replaceList.add(replaceList.get(i));
                    newStrings.remove(i);
                    newStrings.add(newStrings.get(i));
                }
            }
        }
    }

    public String substituteString(String s) {
        String res = s;

        sortingRequests();

        for(int i = 0; i < s.length(); i++) {
            res = res.replace("%" + replaceList.get(i) + "%", newStrings.get(i));
        }
        return res;
    }
}

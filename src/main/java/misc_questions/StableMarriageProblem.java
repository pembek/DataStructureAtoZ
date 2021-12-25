package misc_questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
The stable marriage problem is defined as follows:

Suppose you have N men and N women, and each person has ranked their prospective
opposite-sex partners in order of preference.

For example, if N = 3, the input could be something like this:

guy_preferences = {
    'andrew': ['caroline', 'abigail', 'betty'],
    'bill': ['caroline', 'betty', 'abigail'],
    'chester': ['betty', 'caroline', 'abigail'],
}

gal_preferences = {
    'abigail': ['andrew', 'bill', 'chester'],
    'betty': ['bill', 'andrew', 'chester'],
    'caroline': ['bill', 'chester', 'andrew']
}
Write an algorithm that pairs the men and women together in such a way that no
two people of opposite sex would both rather be with each other than with their current partners.

*/
public class StableMarriageProblem {
    // the Gale-Shapley algorithm
    public static HashMap<String,String> stableMarriages(HashMap<String,String[]> guy_preferences,
                                                  HashMap<String,String[]> gal_preferences){
        HashMap<String,String> couples = new HashMap<>();
        List<String> gals = gal_preferences.keySet().stream().toList();
        List<String> guys = guy_preferences.keySet().stream().toList();
        Deque<String> bachelors = new ArrayDeque<>();
        bachelors.addAll(guys);
        int l = gals.size();

        /* At each step, we consider one currently unmarried man.
        This man will go through his list of prospective partners, proposing to each one in turn.
        If the woman is currently unmarried, she agrees automatically.
        Otherwise, she will consider whether she prefers this new suitor to her current husband,
        and if so she will "trade up" to the new offer.*/

        boolean heIsMarried = false;
        while(!bachelors.isEmpty()){
            String guy = bachelors.pop();
            for(String possiblePartner: guy_preferences.get(guy)){
                heIsMarried = tryMatching(guy, possiblePartner, couples, gal_preferences, bachelors);
                if(heIsMarried) break;
            }
        }
        return couples;
    }

    private static boolean tryMatching(String guy, String gal, HashMap<String, String> couples,
                                       HashMap<String, String[]> gal_preferences, Deque<String> bachelors) {
        String currHusband = couples.getOrDefault(gal,"");
        int currScore = -1, newScore = -1;
        if(currHusband.equals("")){ // if she is not married
            couples.put(gal,guy);
            return true;
        } else {
            int i = 0;
            for(String tempGuy: gal_preferences.get(gal)){
                if(tempGuy.equals(guy)) newScore = i;
                if(tempGuy.equals(currHusband)) currScore = i;
                i++;
            }
            if(newScore < currScore) {
                couples.put(gal, guy);
                bachelors.push(guy);  //husband now has to find someone else
                return true;
            } else
                return false;
        }
    }
}

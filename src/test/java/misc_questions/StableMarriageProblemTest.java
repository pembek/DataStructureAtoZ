package misc_questions;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class StableMarriageProblemTest {

    @Test
    public void stableMarriageTest3Couples(){
        HashMap<String,String[]> guy_preferences = new HashMap<>();
        HashMap<String,String[]> gal_preferences = new HashMap<>();

        guy_preferences.put("andrew", new String[]{"caroline","abigail","betty"});
        guy_preferences.put("bill", new String[]{"caroline","betty","abigail"});
        guy_preferences.put("chester", new String[]{"betty","caroline","abigail"});

        gal_preferences.put("abigail", new String[]{"andrew","bill","chester"});
        gal_preferences.put("betty", new String[]{"bill","andrew","chester"});
        gal_preferences.put("caroline", new String[]{"bill","chester","andrew"});

        assertEquals("andrew",StableMarriageProblem.stableMarriages(guy_preferences,gal_preferences).get("abigail"));
        assertEquals("chester",StableMarriageProblem.stableMarriages(guy_preferences,gal_preferences).get("betty"));
        assertEquals("bill",StableMarriageProblem.stableMarriages(guy_preferences,gal_preferences).get("caroline"));

    }

}

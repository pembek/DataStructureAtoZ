package misc_questions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindMinMinutesTest {

    @Test
    public void getClassTest(){
        List<String> l = new ArrayList<>(List.of("11:00", "15:55", "12:11"));
        assertEquals(71, FindMinMinutes.getMinutes(l));
    }
}

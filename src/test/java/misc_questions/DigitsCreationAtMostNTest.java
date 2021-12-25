package misc_questions;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DigitsCreationAtMostNTest {
    @Test
    public void scheduleCourseBasicTest(){
        assertEquals(15,
                DigitsCreationAtMostN.atMostNGivenDigitSet(new String[]{"2","3","5","8"},55));

    }
    @Test
    public void scheduleCourseBasic2Test(){
        assertEquals(2,
                DigitsCreationAtMostN.atMostNGivenDigitSet(new String[]{"5","6"},19));

    }
    @Test
    public void scheduleCourseStressTest(){
        assertEquals(3,
                DigitsCreationAtMostN.atMostNGivenDigitSet(new String[]{"1"},834));
        assertEquals(14,
                DigitsCreationAtMostN.atMostNGivenDigitSet(new String[]{"1","2"},834));
        assertEquals(10,
                DigitsCreationAtMostN.atMostNGivenDigitSet(new String[]{"1","7"},231));
    }
    @Test
    public void scheduleCourseTest(){
        assertEquals(29523,
                DigitsCreationAtMostN.atMostNGivenDigitSet(new String[]{"1","4","9"},1000000000));

    }
}

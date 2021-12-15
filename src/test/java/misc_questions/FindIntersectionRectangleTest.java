package misc_questions;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class FindIntersectionRectangleTest {

    @Test
    public void maxSubsequenceTest(){
        int [] l = new int[]{2,1,3,3};

        assertEquals(2,FindIntersectionRectangle.maxSubsequence(l,2).length);
        assertEquals(3,FindIntersectionRectangle.maxSubsequence(l,2)[0]);
        assertEquals(3,FindIntersectionRectangle.maxSubsequence(l,2)[1]);
    }

    @Test
    public void maxSubsequenceTestWithNegatives(){
        int [] l = new int[]{-1,-2,3,4};

        assertEquals(3,FindIntersectionRectangle.maxSubsequence(l,3).length);
    }

    @Test
    public void maxSubsequenceTestWithRepeated(){
        int [] l = new int[]{3,4,3,3};

        assertEquals(2,FindIntersectionRectangle.maxSubsequence(l,2).length);
    }
}

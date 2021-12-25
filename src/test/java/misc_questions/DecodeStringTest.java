package misc_questions;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DecodeStringTest {

    @Test
    public void decodeStringBasicTest() {
        assertEquals("abccdcdcdxyz", DecodeString.decodeString("abc3[cd]xyz"));
    }
    @Test
    public void decodeStringBasicTestWithTwoBrackets() {
        assertEquals("aaabcbc", DecodeString.decodeString("3[a]2[bc]"));
    }
    @Test
    public void decodeStringBasicTestWithTwoNestedBrackets() {
        assertEquals("accaccacc", DecodeString.decodeString("3[a2[c]]"));
    }
    @Test
    public void decodeStringBasicTestWithBracketsLonger() {
        assertEquals("abcabccdcdcdef", DecodeString.decodeString("2[abc]3[cd]ef"));
    }
    @Test
    public void decodeStringBasicTestWithThreeNestedBrackets() {
        assertEquals("azdccccczdcccccazdccccczdcccccazdccccczdccccc", DecodeString.decodeString("3[a2[zd5[c]]]"));
    }
    @Test
    public void decodeStringBasicTestWithOneBrackets() {
        assertEquals("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode", DecodeString.decodeString("10[leetcode]"));
    }
    @Test
    public void decodeStringBasicTestMixed() {
        assertEquals("sdfeegfeegi", DecodeString.decodeString("sd2[f2[e]g]i"));
    }

}
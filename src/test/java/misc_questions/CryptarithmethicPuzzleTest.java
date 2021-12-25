package misc_questions;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class CryptarithmethicPuzzleTest {

    @Test
    public void cryptarithmethicPuzzleBasicTest() {
        CryptarithmethicPuzzle puzzle = new CryptarithmethicPuzzle();

        Map<Character, Integer> hm = puzzle.findSolutionWithExhaustiveRecursion("S", "W", "SF");

        assertEquals(1, hm.getOrDefault('S', 0).intValue());
        assertEquals(0, hm.getOrDefault('F', 0).intValue());
        assertEquals(9, hm.getOrDefault('W', 0).intValue());
    }

    @Test
    public void cryptarithmethicPuzzleSendMoneyTest(){
        CryptarithmethicPuzzle puzzle = new CryptarithmethicPuzzle();

        Map<Character, Integer> hm = puzzle.findSolutionWithExhaustiveRecursion("SEND", "MORE", "MONEY");

        assertEquals(9, hm.getOrDefault('S',0).intValue());
        assertEquals(5, hm.getOrDefault('E',0).intValue());
        assertEquals(6, hm.getOrDefault('N',0).intValue());
        assertEquals(7, hm.getOrDefault('D',0).intValue());
        assertEquals(1, hm.getOrDefault('M',0).intValue());
        assertEquals(0, hm.getOrDefault('O',0).intValue());
        assertEquals(2, hm.getOrDefault('Y',0).intValue());
    }
}

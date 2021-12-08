package misc_questions;

import misc_questions.RobotBoard;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RobotBoardTest {

        @Test
        public void robotBoardTest(){
            int [][] board = new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}};

            int n = 5, p = 4;
            int backPage = (p % 2 == 0) ? (n-p-1)/2+1 : (n-p)/2;
            System.out.println(backPage);

            assertEquals(2, RobotBoard.uniquePathsIII(board));
        }
}

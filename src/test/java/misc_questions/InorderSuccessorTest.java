package misc_questions;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class InorderSuccessorTest {

    public static InorderSuccessor c;

    @BeforeClass
    public static void init(){
        c = new InorderSuccessor();
    }

    @Before
    public void clear(){
        c.root = null;
    }
    /*
                           10
                          /   \
                         5    30
                        /   /   \
                       4   22   35
                          /  \   /
                         15  23 32
                        /     \  \
                       11     25 33
    */
    @Test
    public void findInorderSuccessorTest(){
        c.insertNode(10);
        c.insertNode(5);
        c.insertNode(30);
        c.insertNode(4);c.insertNode(22);c.insertNode(35);
        c.insertNode(15);c.insertNode(23);c.insertNode(32);
        c.insertNode(11);c.insertNode(25);c.insertNode(33);

        assertEquals(23, c.findInorderSuccessor(c.root.right.left));
        assertEquals(5, c.findInorderSuccessor(c.root.left.left));
        assertEquals(10, c.findInorderSuccessor(c.root.left));
        assertEquals(33, c.findInorderSuccessor(c.root.right.right.left));
        assertEquals(11, c.findInorderSuccessor(c.root));
        assertEquals(22, c.findInorderSuccessor(c.root.right.left.left));
        assertEquals(15, c.findInorderSuccessor(c.root.right.left.left.left));
        assertEquals(32, c.findInorderSuccessor(c.root.right));
        assertEquals(35, c.findInorderSuccessor(c.root.right.right.left.right));
        assertEquals(0, c.findInorderSuccessor(c.root.right.right));
    }
}


import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BinaryTreeTest {
    private static BinaryTree binaryTree;

    @BeforeClass
    public static void instantiate(){
        binaryTree = new BinaryTree();
    }

    @Before
    public void cleanBinaryTree(){
        binaryTree.clean();
    }

    @Test
    public void _01_hasPathSumBasicCaseShouldBeTrue() {
        binaryTree.insert(4);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(0);

        assertEquals(true, binaryTree.hasPathSum(11));
        assertEquals(true, binaryTree.hasPathSum(8));
        assertEquals(true, binaryTree.hasPathSum(10));
    }

    @Test
    public void _02_hasPathSumBasicCaseShouldBeFalse() {
        binaryTree.insert(4);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(0);

        assertFalse(binaryTree.hasPathSum(7));
        assertFalse(binaryTree.hasPathSum(19));
    }

    @Test
    public void _03_sameTreeEmptyTrees() {
        BinaryTree otherTree = new BinaryTree();
        assertTrue(binaryTree.sameTree(otherTree));
    }

    @Test
    public void _04_sameTreeOneNodeTrue() {
        BinaryTree otherTree = new BinaryTree();
        otherTree.insert(4);

        binaryTree.insert(4);
        assertTrue(binaryTree.sameTree(otherTree));
    }

    @Test
    public void _05_sameTreeOneNodeFalse() {
        BinaryTree otherTree = new BinaryTree();
        otherTree.insert(5);

        binaryTree.insert(4);
        assertFalse(binaryTree.sameTree(otherTree));
    }

    @Test
    public void _06_sameTreeMultipleNodesFalse() {
        BinaryTree otherTree = new BinaryTree();
        otherTree.insert(4);
        otherTree.insert(3);
        otherTree.insert(7);
        otherTree.insert(1);
        otherTree.insert(2);

        binaryTree.insert(4);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(0);
        assertFalse(binaryTree.sameTree(otherTree));
    }

    @Test
    public void _07_sameTreeMultipleNodesTrue() {
        BinaryTree otherTree = new BinaryTree();
        otherTree.insert(4);
        otherTree.insert(3);
        otherTree.insert(7);
        otherTree.insert(1);
        otherTree.insert(2);
        otherTree.insert(0);

        binaryTree.insert(4);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(0);

        assertTrue(binaryTree.sameTree(otherTree));
    }

    @Test
    public void _08_countTreesEmptyCase() {
        assertEquals(1, binaryTree.countTrees(0));
    }

    @Test
    public void _09_countTreesOneElementCase() {
        assertEquals(1, binaryTree.countTrees(1));
    }

    @Test
    public void _10_countTreesThreeElementCase() {
        assertEquals(5, binaryTree.countTrees(3));
    }

    @Test
    public void _11_countTreesFourElementCase() {
        assertEquals(14, binaryTree.countTrees(4));
    }

    @Test
    public void _12_lookupTest(){
        binaryTree.insert(4);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(0);

        assertTrue(binaryTree.lookup(4));
        assertTrue(binaryTree.lookup(3));
        assertTrue(binaryTree.lookup(7));
        assertTrue(binaryTree.lookup(1));
        assertTrue(binaryTree.lookup(2));
        assertTrue(binaryTree.lookup(0));
    }

    @Test
    public void _13_maxDepth(){
        binaryTree.insert(4);
        assertEquals(1,binaryTree.size());
        assertEquals(1,binaryTree.maxDepth());
        binaryTree.insert(3);
        assertEquals(2,binaryTree.size());
        assertEquals(2,binaryTree.maxDepth());
        binaryTree.insert(7);
        assertEquals(3,binaryTree.size());
        assertEquals(2,binaryTree.maxDepth());
        binaryTree.insert(1);
        assertEquals(4,binaryTree.size());
        assertEquals(3,binaryTree.maxDepth());
        binaryTree.insert(2);
        assertEquals(5,binaryTree.size());
        assertEquals(4,binaryTree.maxDepth());
        binaryTree.insert(0);
        assertEquals(6,binaryTree.size());
        assertEquals(4,binaryTree.maxDepth());
    }
}

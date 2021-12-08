package misc_questions;

import misc_questions.TowerBreakers;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TowerBreakersTest {
    @Test
    public void lowestCommonAncestor() {
        TowerBreakers.TreeNode n1 = new TowerBreakers.TreeNode(1);
        TowerBreakers.TreeNode n2 = new TowerBreakers.TreeNode(2);
        TowerBreakers.TreeNode n3 = new TowerBreakers.TreeNode(3);
        TowerBreakers.TreeNode n5 = new TowerBreakers.TreeNode(5, n2, n1);
        TowerBreakers.TreeNode n6 = new TowerBreakers.TreeNode(6, n3, null);
        TowerBreakers.TreeNode n7 = new TowerBreakers.TreeNode(7, n5, n6);

        assertEquals(n1,TowerBreakers.lowestCommonAncestor(n7,1,3));
    }

}

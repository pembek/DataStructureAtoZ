package misc_questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TowerBreakers {


      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public static TreeNode lowestCommonAncestor(TreeNode root, int s, int d) {
        if (root == null) {
            return root;
        }
        if (root.val == s || root.val == d) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, s, d);
        TreeNode right = lowestCommonAncestor(root.right, s, d);

        //current root contains both p and q, is the lca node, and this is postorder
        if (left != null && right != null)
            return root;

        //left or right at least one of them contains lca
        return left == null ? right : left;
    }
}

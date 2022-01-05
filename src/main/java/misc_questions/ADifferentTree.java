package misc_questions;

import java.util.List;

public class ADifferentTree {
    /* the question is implement a function that deletes a node from the tree
    * that the structure is given below
    * Nodes only have a pointer to their parent, not to their children
    * and the representation is not made by Node pointers but index numbers.
    *
    * As an example:
    *     A
    *    / \
    *   B   C
    *  / \   \
    * D  E    F
    *
    * The representation of this tree is at follows:
    * List<> list = {(A, -1), (B, 0), (C, 0), (D, 1), (E, 1), (F, 2)}
    *                   0        1       2       3       4       5
    *
    * NOTE1: It's only guaranteed that a parent comes "before" than it's child
    * NOTE2: it is not essentially a binary tree
    * NOTE3: deleting node edge case can be ignored thinking root will never be deleted
    * */
    public class DifferentTreeNode {
        int parentNode;
        char value;
    }

    // for instance if B is wanted to be deleted in the tree above, deleteNodeIndex will be 1
    public void deleteNode(List<DifferentTreeNode> tree, int deleteNodeIndex) {
        // 1. find children and update parent node pointers
        for(DifferentTreeNode n: tree) {
            if(n.parentNode == deleteNodeIndex) {
                n.parentNode = tree.get(deleteNodeIndex).parentNode;
            }
        }
        // 2. remove the node from list
        tree.remove(deleteNodeIndex);

        // 3. It's not over! after removed node the other elements are shifted by 1
        //(since one element is being deleted)
        for(int i = 0; i < tree.size(); i++) {
            if(tree.get(i).parentNode > deleteNodeIndex) {
                tree.get(i).parentNode -= 1;
            }
        }
    }
    // 2nd version of the question above. What if if we want to delete a subtree
    // beginning from 'deleteNodeIndex' (the root is deleteNodeIndex)
    public void deleteSubTree(List<DifferentTreeNode> tree, int deleteNodeIndex) {
        //TODO
    }

}

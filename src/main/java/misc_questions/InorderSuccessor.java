package misc_questions;

/**
 This is your coding interview problem for today.

 This problem was asked by Amazon.

 Given a node in a binary search tree, return the next bigger element, also known as the inorder successor.

 For example, the inorder successor of 22 is 30.

       10
     /   \
    5    30
   /   /   \
  4   22   35
    /  \   /
   15  23 32
  /     \  \
 11     25 33
 You can assume each node has a parent pointer.

 inorder =  left _  root _  right

 if have right leaf       = smallest element in your right subtree
 if don't have right leaf = crawl up until find left child
 */
public class InorderSuccessor {
    public class BSTNode{ // Node of BST tree
        BSTNode parent;
        BSTNode left;
        BSTNode right;
        int val;

        BSTNode(int val, BSTNode parent){
            this.val = val;
            this.parent = parent;
            left = null;
            right = null;
        }
    }

    BSTNode root;

    public int findInorderSuccessor(BSTNode n){
        BSTNode crawl = n;
        if(n.right == null){  // if right node is null, return first root of a LEFT child
            if(crawl.parent == null) return 0;

            while(crawl != null && crawl.parent != null &&
                    crawl.val > crawl.parent.val) crawl = crawl.parent;

            crawl = crawl.parent;
        } else {  // if right node is not null, smallest element in your right subtree
            crawl = n.right;
            while(crawl.left != null) crawl = crawl.left;
        }
        return (crawl == null) ? 0 : crawl.val;
    }

    public void insertNode(int val){
        root = insertNodeRec(root, val, null);
    }

    /**
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
    public BSTNode insertNodeRec(BSTNode node, int val, BSTNode parent){
        if(node == null){
            BSTNode newNode = new BSTNode(val, parent);
            return newNode;
        }
        else {
            if(val < node.val){
                node.left = insertNodeRec(node.left, val, node);
            }
            else if(val > node.val){
                node.right = insertNodeRec(node.right, val, node);
            }
        }
        return node;
    }
}

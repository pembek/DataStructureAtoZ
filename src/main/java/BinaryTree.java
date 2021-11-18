public class BinaryTree {

    public class Node{
        //The node is a "dumb" nested class -- we just use it for
        //storage; it does not have any methods.
        int data;
        Node right;
        Node left;

        Node(int data){
            this.data = data;
            right = null;
            left = null;
        }
    }

    private Node root;

    public BinaryTree(){
        root = null;
    }

    public void clean(){
        root = null;
    }

    public boolean lookup(int data){
        return lookup(this.root, data);
    }

    public boolean lookup(Node node, int data){
        if(node == null)
            return false;

        if(node.data == data) {
            return true;
        } else if(data < node.data) {
            return lookup(node.left, data);
        }
        else {
            return lookup(node.right, data);
        }
    }

    // There is a change. So changed pointer should be communicated between recursive calls
    // Returns the new
    //   node pointer (the standard way to communicate
    //   a changed pointer back to the caller).
    //  */
    public void insert(int data){
        root = insert(root, data);
    }

    public Node insert(Node node, int data){
        if(node == null){
            node = new Node(data);
        } else{
            if(data > node.data)
            {
                node.right = insert(node.right, data);
            }
            else
            {
                node.left = insert(node.left, data);
            }
        }
        return node;
    }

    public int size(){
        return size(root);
    }

    public int size(Node node){
        if(node == null){
            return 0;
        }
        else
        {
            return 1 + size(node.left) + size(node.right);
        }
    }

    public int maxDepth(){
        return maxDepth(root);
    }

    public int maxDepth(Node node){
        if(node == null){
            return 0;
        }
        else
        {
            int depthLeft = maxDepth(node.left);
            int depthRight = maxDepth(node.right);

            return(Math.max(depthLeft, depthRight) + 1);
        }
    }

    public int minValue(){
        return minValue(root);
    }

    public int minValue(Node node){
        Node currentNode = node;
        while(currentNode != null && currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.data;
    }

    public int maxValue(){
        return maxValue(root);
    }

    public int maxValue(Node node){
        Node currentNode = node;
        while(currentNode != null && currentNode.right != null){
            currentNode = currentNode.right;
        }
        return currentNode.data;
    }

    /**
     Prints the node values in the "inorder" order.
     Uses a recursive helper to do the traversal.
     */
    public void printTree() {
        printTree(root);
        System.out.println();
    }
    private void printTree(Node node) {
        if (node == null) return;

        // left, node itself, right
        printTree(node.left);
        System.out.print(node.data + "  ");
        printTree(node.right);
    }

    /**
     Prints the node values in the "postorder" order.
     Uses a recursive helper to do the traversal.
     */
    public void printPostorder() {
        printPostorder(root);
        System.out.println();
    }
    public void printPostorder(Node node) {
        if (node == null) return;

        // first recur on both subtrees
        printPostorder(node.left);
        printPostorder(node.right);

        // then deal with the node
        System.out.print(node.data + "  ");
    }

    /**
     Given a tree and a sum, returns true if there is a path from the root
     down to a leaf, such that adding up all the values along the path
     equals the given sum.
     Strategy: subtract the node value from the sum when recurring down,
     and check to see if the sum is 0 when you run out of tree.
     */
    public boolean hasPathSum(int sum) {
        return hasPathSum(root, sum);
    }

    public boolean hasPathSum(Node node, int sum){
        if(node == null) return false;

        if(sum == node.data && (node.left == null && node.right == null)){
            return true;
        }
        else
        {
            return hasPathSum(node.right,sum - node.data) || hasPathSum(node.left, sum - node.data);
        }
    }
    /**
     Given a binary tree, prints out all of its root-to-leaf
     paths, one per line. Uses a recursive helper to do the work.
     */
    public void printPaths() {

    }

    /**
     Changes the tree into its mirror image.

     So the tree...
     4
     / \
     2   5
     / \
     1   3

     is changed to...
     4
     / \
     5   2
     / \
     3   1

     Uses a recursive helper that recurs over the tree,
     swapping the left/right pointers.
     */
    public void mirror() {
       // TODO
    }

    /**
     Changes the tree by inserting a duplicate node
     on each nodes's .left.


     So the tree...
     2
     / \
     1   3

     Is changed to...
     2
     / \
     2   3
     /   /
     1   3
     /
     1

     Uses a recursive helper to recur over the tree
     and insert the duplicates.
     */
    public void doubleTree() {
     // TODO
    }

    /**
    Compares the receiver to another tree to
    see if they are structurally identical.
    */
    public boolean sameTree(BinaryTree other) {
        return sameTree(root, other.root);
    }

    public boolean sameTree(Node node1, Node node2){
        if(node1 == null && node2 == null)return true;

        if(node1 != null && node2 != null){
            if(node1.data != node2.data) return false;
            return sameTree(node1.right, node2.right) &&
                    sameTree(node1.left, node2.left);
        }else return false; // one empty, one not -> false
    }

    /**
     For the key values 1...numKeys, how many structurally unique
     binary search trees are possible that store those keys?
     Strategy: consider that each value could be the root.
     Recursively find the size of the left and right subtrees.
     */
    public static int countTrees(int numKeys) {
      if (numKeys <=1) {
            return(1);
        }
      else {
            // there will be one value at the root, with whatever remains
            // on the left and right each forming their own subtrees.
            // Iterate through all the values that could be the root...
            int sum = 0;
            int left, right, root;

            for (root=1; root<=numKeys; root++) {
                left = countTrees(root-1);
                right = countTrees(numKeys - root);

                // number of possible trees with this root == left*right
                sum += left*right;
            }
            return(sum);
        }
    }

    /**
     Tests if a tree meets the conditions to be a
     binary search tree (BST).
     */
    public boolean isBST() {
        return isBST(root);
    }

    /**
     Recursive helper -- checks if a tree is a BST
     using minValue() and maxValue() (not efficient).
     */
    public boolean isBST(Node node){
        if(node == null) return true;
        else
        {
           if(node.right != null && node.data >= maxValue(node.right)) return false;
           if(node.left != null && node.data < minValue(node.left)) return false;

           return(isBST(node.right) && isBST(node.left));
        }
    }

    /**
     Tests if a tree meets the conditions to be a
     binary search tree (BST). Uses the efficient
     recursive helper.
     */
    public boolean isBST2() {
        return isBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    /**
     Efficient BST helper -- Given a node, and min and max values,
     recurs down the tree to verify that it is a BST, and that all
     its nodes are within the min..max range. Works in O(n) time --
     visits each node only once.
     */
    public boolean isBST2(Node node, int min, int max){
        if(node == null) return true;

        if(node.data > min || node.data < max) return false;
        else{
            return isBST2(node.right, node.data, max) && isBST2(node.left, min, node.data);
        }
    }

}

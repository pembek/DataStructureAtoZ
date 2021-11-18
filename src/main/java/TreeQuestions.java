public class TreeQuestions {
    public static void main(String [] args){
        BinaryTree tree = new BinaryTree();

        tree.insert(4);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(2);
        tree.insert(0);

        System.out.println("depth: " + tree.maxDepth());
        System.out.println("min value :" + tree.minValue());
        System.out.println("max value :" + tree.maxValue());

        tree.printTree();
        tree.printPostorder();
    }

}

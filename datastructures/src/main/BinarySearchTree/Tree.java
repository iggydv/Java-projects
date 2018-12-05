package main.BinarySearchTree;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        System.out.print(value);
        if (root == null) {
            System.out.println(" root");
            System.out.println(" insert " +value);
            root = new TreeNode(value);
        } else {
            System.out.println(" child");
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        } else {
            return null;
        }

    }
}

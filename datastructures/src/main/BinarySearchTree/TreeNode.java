package main.BinarySearchTree;

public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {

        if (value == data) {
            return;
        }

        if (value < data) {
            System.out.println(value + "<"+ data + " left");
            if (left == null) {
                System.out.println(" insert "+value);
                left = new TreeNode(value);
            } else {
                left.insert(value);
            }
        } else {
            System.out.println(value + ">"+ data + " right");
            if (right == null) {
                System.out.println(" insert "+value);
                right = new TreeNode(value);
            } else {
                right.insert(value);
            }
        }
    }

    public void traverseInOrder() {
        if (left != null) {
            left.traverseInOrder();
        }
        System.out.print(data + ", ");
        if (right != null) {
            right.traverseInOrder();
        }

    }

    public TreeNode get(int value) {
        if (value == data ) {
            System.out.println("found "+ value);
            return this;
        }

        if (value < data) {
            if (left != null) {
                return left.get(value);
            }
        } else {
            if (right != null) {
                return right.get(value);
            }
        }
        return null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

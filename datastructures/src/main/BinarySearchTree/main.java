package main.BinarySearchTree;

public class main {

    public static void main(String[] arg) {
        Tree intTree = new Tree();

        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);

        intTree.traverseInOrder();

        intTree.get(27);

        System.out.println(intTree.get(27).getData());
        System.out.println(intTree.get(32).getData());
        System.out.println(intTree.get(40).getData());
        System.out.println(intTree.get(1).getData());
    }
}

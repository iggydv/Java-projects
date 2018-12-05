package main.BinarySearchTree;

import junit.framework.TestCase;
import org.junit.Test;

public class TreeTest extends TestCase {
    Tree intTree = new Tree();
    @Test
    public void testInsert() {
        createTreeData();
    }

    public void testTraverseInOrder() {
    }

    public void testGet() {
        createTreeData();
        TreeNode a = intTree.get(50);
        System.out.println(a.getData());
        //assertEquals(50, a.getData());
    }

    private void createTreeData() {

        intTree.insert(50);
        intTree.insert(562);
        intTree.insert(5);
        TreeNode a = intTree.get(50);
        System.out.println(a.getData());
    }
}
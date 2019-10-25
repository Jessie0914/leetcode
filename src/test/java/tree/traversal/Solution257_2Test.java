package tree.traversal;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution257_2Test {

    @Test
    public void binaryTreePaths() {
        Solution257_2 solution257_2 = new Solution257_2();
        TreeNode root = null;
        TreeNode p = new TreeNode(1);

        TreeNode p1 = new TreeNode(2);
        TreeNode p12 = new TreeNode(5);

        TreeNode p2 = new TreeNode(3);

        p.left = p1;
        p.right = p2;

        p1.right = p12;

        p12 = null;

        List<String> strings = solution257_2.binaryTreePaths(p);
        System.out.println("end");

    }
}
package tree.traversal;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution110Test {
    TreeNode p = new TreeNode(3);

    TreeNode p1 = new TreeNode(9);
    TreeNode p2 = new TreeNode(20);

    TreeNode p21 = new TreeNode(15);
    TreeNode p22 = new TreeNode(7);

    @Test
    public void isBalanced() {
        p.left = p1;
        p.right = p2;
        p2.left = p21;
        p2.right = p22;
        p21.left = p21.right = p22.left = p22.right = null;

        Solution110 solution110 = new Solution110();
        boolean balanced = solution110.isBalanced(p);
        System.out.println(balanced);
    }
}
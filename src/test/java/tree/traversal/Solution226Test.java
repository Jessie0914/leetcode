package tree.traversal;

import org.junit.Test;

public class Solution226Test {
    TreeNode p = new TreeNode(1);

    TreeNode p1 = new TreeNode(2);
    TreeNode p11 = new TreeNode(3);
    TreeNode p12 = new TreeNode(4);

    TreeNode p2 = new TreeNode(5);
    TreeNode p21 = new TreeNode(6);
    TreeNode p22 = new TreeNode(7);

    @Test
    public void invertTree() {
        p.left = p1;
        p.right = p2;

        p1.left = p11;
        p1.right = p12;
        p2.left = p21;
        p2.right = p22;

        p11 = p12 = p21 = p22 = null;

        Solution226 solution226 = new Solution226();
        TreeNode treeNode = solution226.invertTree(p);
        System.out.println(treeNode.left.right.val);
    }
}
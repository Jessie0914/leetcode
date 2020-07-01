package tree.traversal;

import org.junit.Test;

public class Solution101Test {
    TreeNode p = new TreeNode(1);

    TreeNode p1 = new TreeNode(2);
    TreeNode p11 = new TreeNode(3);
    TreeNode p12 = new TreeNode(4);

    TreeNode p2 = new TreeNode(2);
    TreeNode p21 = new TreeNode(4);
    TreeNode p22 = new TreeNode(4);

    @Test
    public void isSymmetric() {
        p.left = p1;
        p.right = p2;

        p1.left = p11;
        p1.right = p12;
        p2.left = p21;
        p2.right = p22;

        p11 = p12 = p21 = p22 = null;

        Solution101 solution101 = new Solution101();
        boolean symmetric = solution101.isSymmetric(p);
        System.out.println(symmetric);
    }
}
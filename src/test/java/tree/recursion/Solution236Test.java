package tree.recursion;

import org.junit.Test;

public class Solution236Test {
    TreeNode p = new TreeNode(3);
    TreeNode p1 = new TreeNode(5);
    TreeNode p2 = new TreeNode(1);
    TreeNode p11 = new TreeNode(6);
    TreeNode p12 = new TreeNode(2);
    TreeNode p21 = new TreeNode(0);
    TreeNode p22 = new TreeNode(8);


    @Test
    public void lowestCommonAncestor() {
        p.left = p1;
        p.right = p2;
        p1.left = p11;
        p1.right = p12;
        p2.left = p21;
        p2.right = p22;

        Solution236 solution236 = new Solution236();
        solution236.lowestCommonAncestor(p,p1,p22);
    }
}
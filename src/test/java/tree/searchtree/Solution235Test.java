package tree.searchtree;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution235Test {

    @Test
    public void lowestCommonAncestor() {
        TreeNode p = new TreeNode(6);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(8);
        TreeNode p11 = new TreeNode(0);
        TreeNode p12 = new TreeNode(4);
        TreeNode p21 = new TreeNode(7);
        TreeNode p22 = new TreeNode(9);

        p.left = p1;
        p.right = p2;
        p1.left = p11;
        p1.right = p12;
        p2.left = p21;
        p2.right = p22;

        Solution235 solution235 = new Solution235();
        solution235.lowestCommonAncestor(p,p1,p12);
    }
}
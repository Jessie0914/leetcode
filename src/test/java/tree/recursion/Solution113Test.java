package tree.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution113Test {

    @Test
    public void pathSum() {
        TreeNode p = new TreeNode(5);
        TreeNode p1 = new TreeNode(4);
        TreeNode p2 = new TreeNode(8);
        TreeNode p11 = new TreeNode(11);
        TreeNode p111 = new TreeNode(7);
        TreeNode p112 = new TreeNode(2);
        TreeNode p21 = new TreeNode(13);
        TreeNode p22 = new TreeNode(4);
        TreeNode p221 = new TreeNode(5);
        TreeNode p222 = new TreeNode(1);

        p.left = p1;
        p.right = p2;
        p1.left = p11;
        p1.right = null;
        p2.left = p21;
        p2.right = p22;
        p11.left = p111;
        p11.right = p112;
        p22.left = p221;
        p22.right = p222;

        Solution113 solution113 = new Solution113();
        solution113.pathSum(p,22);
    }
}
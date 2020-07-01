package tree.traversal;

import org.junit.Test;

public class Solution100Test {
    TreeNode p = new TreeNode(1);
    TreeNode p1 = new TreeNode(2);
    TreeNode p2 = new TreeNode(3);

    TreeNode q = new TreeNode(1);
    TreeNode q1 = new TreeNode(2);
    TreeNode q2 = new TreeNode(3);
    @Test
    public void isSameTree() {
        p.left = p1;
        p.right = p2;
        p1.left = p1.right = p2.left = p2.right = null;

        q.left = q1;
        q.right = q2;
        q1.left = q1.right = q2.left = q2.right = null;

        Solution100 solution100 = new Solution100();
        boolean sameTree = solution100.isSameTree(p, q);
        System.out.println(sameTree);
    }
}
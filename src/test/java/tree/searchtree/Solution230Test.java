package tree.searchtree;

import org.junit.Test;


public class Solution230Test {
    TreeNode p = new TreeNode(3);
    TreeNode p1 = new TreeNode(1);
    TreeNode p12 = new TreeNode(2);
    TreeNode p2 = new TreeNode(4);

    @Test
    public void kthSmallest() {
        p.left = p1;
        p.right = p2;
        p1.right = p12;

        Solution230 solution230 = new Solution230();
        int kthSmallest = solution230.kthSmallest(p, 1);
        System.out.println(kthSmallest);
    }
}
package tree.recursion;

import org.junit.Test;

public class Solution129Test {

    @Test
    public void sumNumbers() {
        TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);

        p.left = p1;
        p.right = p2;

        Solution129 solution129 = new Solution129();
        int sum = solution129.sumNumbers(p);
        System.out.println(sum);
    }
}
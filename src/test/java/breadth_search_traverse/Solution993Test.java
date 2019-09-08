package breadth_search_traverse;

import org.junit.Test;

public class Solution993Test {

    @Test
    public void isCousins() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t11 = new TreeNode(2);
        TreeNode t12 = new TreeNode(3);
        TreeNode t112 = new TreeNode(4);
        TreeNode t122 = new TreeNode(5);

        t1.left = t11;
        t1.right = t12;
        t11.right = t112;
        t12.right = t122;

        Solution993 solution993 = new Solution993();
        boolean cousins = solution993.isCousins(t1, 5, 4);
        System.out.println(cousins);
    }
}
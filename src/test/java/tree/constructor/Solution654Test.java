package tree.constructor;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution654Test {

    @Test
    public void constructMaximumBinaryTree() {
        Solution654 solution654 = new Solution654();
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = solution654.constructMaximumBinaryTree(nums);
        System.out.println(root.val);
    }
}
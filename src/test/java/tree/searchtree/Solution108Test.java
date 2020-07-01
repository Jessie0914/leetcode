package tree.searchtree;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution108Test {

    @Test
    public void sortedArrayToBST() {
        Solution108 solution108 = new Solution108();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution108.sortedArrayToBST(nums);
    }
}
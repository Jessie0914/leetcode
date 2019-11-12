package Depth_search_traverse.backtracing;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution698Test {

    @Test
    public void canPartitionKSubsets() {
        Solution698 solution698 = new Solution698();
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        boolean flag = solution698.canPartitionKSubsets(nums, k);
        System.out.println(flag);
    }
}
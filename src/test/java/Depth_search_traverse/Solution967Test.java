package Depth_search_traverse;

import org.junit.Test;

public class Solution967Test {

    @Test
    public void numsSameConsecDiff() {
        Solution967 solution967 = new Solution967();
        int[] nums = solution967.numsSameConsecDiff(2, 0);
        for (int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        System.out.println(nums.length);
    }
}
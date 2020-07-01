package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution283Test {

    @Test
    public void moveZeroes() {
        Solution283 solution283 = new Solution283();
        int[] nums={};
        solution283.moveZeroes(nums);
        for (int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
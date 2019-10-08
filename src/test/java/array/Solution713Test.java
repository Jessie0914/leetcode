package array;

import org.junit.Test;

public class Solution713Test {

    @Test
    public void numSubarrayProductLessThanK() {
        Solution713 solution713 = new Solution713();
        int[] nums = {10,5,2,6};
        int count = solution713.numSubarrayProductLessThanK(nums, 100);
        System.out.println(count);
    }
}
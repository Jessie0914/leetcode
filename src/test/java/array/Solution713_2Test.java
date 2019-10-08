package array;

import org.junit.Test;

public class Solution713_2Test {

    @Test
    public void numSubarrayProductLessThanK() {
        Solution713_2 solution713_2 = new Solution713_2();
        int[] nums = {10,5,2,6};
        int count = solution713_2.numSubarrayProductLessThanK(nums, 100);
        System.out.println(count);
    }
}
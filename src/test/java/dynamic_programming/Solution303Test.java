package dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution303Test {

    @Test
    public void sumRange() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Solution303 solution303 = new Solution303(nums);
        System.out.println(solution303.sumRange(0, 2));
        System.out.println(solution303.sumRange(2, 5));
        System.out.println(solution303.sumRange(0, 5));
    }
}
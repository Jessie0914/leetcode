package dynamic_programming;

import org.junit.Test;

public class Solution198Test {

    @Test
    public void rob() {
        Solution198 solution198 = new Solution198();
        int[] nums = {2,1,1,2};
        int rob = solution198.rob(nums);
        System.out.println(rob);
    }
}
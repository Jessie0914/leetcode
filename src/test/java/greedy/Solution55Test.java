package greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution55Test {

    @Test
    public void canJump() {
        Solution55 solution55 = new Solution55();
        int[] nums = {3,2,1,0,4};
        boolean b = solution55.canJump(nums);
        System.out.println(b);
    }
}
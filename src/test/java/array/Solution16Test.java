package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution16Test {

    @Test
    public void threeSumClosest() {
        Solution16 solution16 = new Solution16();
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int closest = solution16.threeSumClosest(nums, target);
        System.out.println(closest);
    }
}
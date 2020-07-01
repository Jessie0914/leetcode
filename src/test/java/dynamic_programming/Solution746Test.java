package dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution746Test {

    @Test
    public void minCostClimbingStairs() {
        Solution746 solution746 = new Solution746();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int minCostClimbingStairs = solution746.minCostClimbingStairs(cost);
        System.out.println(minCostClimbingStairs);
    }
}
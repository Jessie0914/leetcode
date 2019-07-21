package dynamic_programming;

import org.junit.Test;

public class Solution70Test {
    Solution70 solution70;
    @Test
    public void climbStairs() {
        solution70 = new Solution70();
        int climbStairs = solution70.climbStairs(44);
        System.out.println(climbStairs);
    }

    @Test
    public void climbStairs2() {
        solution70 = new Solution70();
        int stairs2 = solution70.climbStairs2(45);
        System.out.println(stairs2);
    }

    @Test
    public void climbStairs3() {
        solution70 = new Solution70();
        int stairs3 = solution70.climbStairs2(45);
        System.out.println(stairs3);
    }
}
package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number494Test {

    @Test
    public void findTargetSumWays() {
        Number494 number494 = new Number494();
        int[] nums = {7,9,3,8,0,2,4,8,3,9};
        int S = 0;
        int targetSumWays = number494.findTargetSumWays(nums, S);
        System.out.println(targetSumWays);
    }
}
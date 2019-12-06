package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number673Test {

    @Test
    public void findNumberOfLIS() {
        Number673 number673 = new Number673();
        int[] nums = {2,2,2,2,2};
        int res = number673.findNumberOfLIS(nums);
        System.out.println(res);
    }
}
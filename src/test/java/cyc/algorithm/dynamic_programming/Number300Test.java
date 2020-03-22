package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number300Test {

    @Test
    public void lengthOfLIS() {
        Number300 number300 = new Number300();
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = number300.lengthOfLIS(nums);
        System.out.println(res);
    }
}
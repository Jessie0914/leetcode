package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number303Test {

    @Test
    public void sumRange() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Number303 number303 = new Number303(nums);
        System.out.println(number303.sumRange(0,2));
        System.out.println(number303.sumRange(2,5));
        System.out.println(number303.sumRange(0,5));
    }
}
package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number416Test {

    @Test
    public void canPartition() {
        Number416 number416 = new Number416();
        int[] nums = {1, 5, 11, 5};
        boolean canPartition = number416.canPartition(nums);
        System.out.println(canPartition);
    }
}
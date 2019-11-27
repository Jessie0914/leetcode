package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number198Test {

    @Test
    public void rob() {
        Number198 number198 = new Number198();
        int[] nums = {1,2,3,1};
        int res = number198.rob(nums);
        System.out.println(res);

    }
}
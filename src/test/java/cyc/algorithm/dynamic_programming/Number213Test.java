package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number213Test {

    @Test
    public void rob() {
        Number213 number213 = new Number213();
        int[] nums = {2,3,2};
        int rob = number213.rob(nums);
        System.out.println(rob);

    }
}
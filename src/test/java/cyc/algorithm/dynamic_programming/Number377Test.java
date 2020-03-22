package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number377Test {

    @Test
    public void combinationSum4() {
        Number377 number377 = new Number377();
        int[] nums = {1,2,3};
        int target = 4;
        int combinationSum4 = number377.combinationSum4(nums, target);
        System.out.println(combinationSum4);
    }
}
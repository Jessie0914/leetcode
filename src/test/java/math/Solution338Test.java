package math;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution338Test {

    @Test
    public void countBits() {
        Solution338 solution338 = new Solution338();
        int[] nums = solution338.countBits(5);
        for (int i:nums){
            System.out.println(i);
        }
    }
}
package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution456Test {

    @Test
    public void find132pattern() {
        Solution456 solution456 = new Solution456();
        int[] nums = {3,1,4,2};
        boolean flag = solution456.find132pattern(nums);
        System.out.println(flag);
    }
}
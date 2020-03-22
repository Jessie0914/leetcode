package top_interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution26Test {

    @Test
    public void removeDuplicates() {
        Solution26 solution26 = new Solution26();
        int[] nums = {1,2,2,2,3,3,4};
        int result = solution26.removeDuplicates(nums);
        System.out.println(result);
    }
}
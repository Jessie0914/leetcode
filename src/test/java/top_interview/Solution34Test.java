package top_interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution34Test {

    @Test
    public void searchRange() {
        Solution34 solution34 = new Solution34();
        int[] nums = {1,4};
        int[] searchRange = solution34.searchRange(nums, 4);
        System.out.println(searchRange[0] + " " + searchRange[1]);
    }
}
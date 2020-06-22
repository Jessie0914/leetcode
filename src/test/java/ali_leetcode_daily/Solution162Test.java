package ali_leetcode_daily;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution162Test {

    @Test
    public void findPeakElement() {
        Solution162 solution162 = new Solution162();
        int[] nums = {-2147483647,-2147483648};
        int peakElement = solution162.findPeakElement(nums);
        System.out.println(peakElement);
    }
}
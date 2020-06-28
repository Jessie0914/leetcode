package ali_leetcode_daily;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution454Test {

    @Test
    public void fourSumCount() {
        Solution454 solution454 = new Solution454();
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        int count = solution454.fourSumCount(A, B, C, D);
        System.out.println(count);
    }
}
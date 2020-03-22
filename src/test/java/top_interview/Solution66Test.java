package top_interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution66Test {

    @Test
    public void plusOne() {
        Solution66 solution66 = new Solution66();
        int[] digits = {1,9,8};
        int[] one = solution66.plusOne(digits);
        for (int i : one)
            System.out.print(i+" ");
    }
}
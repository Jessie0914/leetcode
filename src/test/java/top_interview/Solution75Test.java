package top_interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution75Test {

    @Test
    public void sortColors() {
        Solution75 solution75 = new Solution75();
        int[] nums = {1, 0, 2};
        solution75.sortColors(nums);
        for (int i : nums)
            System.out.print(i + " ");
    }
}
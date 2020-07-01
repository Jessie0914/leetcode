package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution27Test {

    @Test
    public void removeElement() {
        Solution27 solution27 = new Solution27();
        int[] nums = {3,2,2,3};
        int val = 3;
        int result = solution27.removeElement(nums, val);
        System.out.println(result);
    }
}
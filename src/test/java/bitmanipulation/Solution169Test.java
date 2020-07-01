package bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution169Test {

    @Test
    public void majorityElement() {
        Solution169 solution169 = new Solution169();
        int[] nums = {2,2,1,1,1,2,2};
        int majorityElement = solution169.majorityElement(nums);
        System.out.println(majorityElement);
    }
}
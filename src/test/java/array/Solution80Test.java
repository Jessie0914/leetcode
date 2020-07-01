package array;

import org.junit.Test;

public class Solution80Test {

    @Test
    public void removeDuplicates() {
        Solution80 solution80 = new Solution80();
        int[] nums = {1,1,1,2,2,3};
        int result = solution80.removeDuplicates(nums);
        System.out.println(result);
    }
}
package array;

import org.junit.Test;

public class Solution525Test {

    @Test
    public void findMaxLength() {
        Solution525 solution525 = new Solution525();
        int[] nums = {0,1,1};
        int maxLength = solution525.findMaxLength(nums);
        System.out.println(maxLength);
    }
}
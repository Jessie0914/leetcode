package array;

import org.junit.Test;

public class Solution456_2Test {

    @Test
    public void find132pattern() {
        Solution456_2 solution456_2 = new Solution456_2();
        int[] nums = {1,5,4,2};
        boolean pattern = solution456_2.find132pattern(nums);
        System.out.println(pattern);
    }
}
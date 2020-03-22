package top_interview;

import org.junit.Test;

public class Solution11Test {

    @Test
    public void maxArea() {
        Solution11 solution11 = new Solution11();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = solution11.maxArea2(height);
        System.out.println(maxArea);
    }
}
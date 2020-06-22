package day_practice.april;

import org.junit.Test;

public class Solution42Test {

    @Test
    public void trap() {
        Solution42 solution42 = new Solution42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = solution42.trap3(height);
        System.out.println(trap);
    }
}
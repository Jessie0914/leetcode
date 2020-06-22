package day_practice.april;

import org.junit.Test;

public class Solution1111Test {

    @Test
    public void maxDepthAfterSplit() {
        Solution1111 solution1111 = new Solution1111();
        int[] ints = solution1111.maxDepthAfterSplit("(()())");
        for (int i : ints)
            System.out.print(i+" ");
    }
}
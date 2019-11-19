package math;

import org.junit.Test;

public class Solution835Test {

    @Test
    public void largestOverlap() {
        Solution835 solution835 = new Solution835();
        int[][] A = {{1,1,0},{0,1,0},{0,1,0}};
        int[][] B = {{0,0,0},{0,1,1},{0,0,1}};
        int largestOverlap = solution835.largestOverlap(A, B);
        System.out.println(largestOverlap);
    }
}
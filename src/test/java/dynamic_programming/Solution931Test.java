package dynamic_programming;

import org.junit.Test;

public class Solution931Test {

    @Test
    public void minFallingPathSum() {
        Solution931 solution931 = new Solution931();
        int[][] A = {{1,1,1},{5,3,1},{2,3,4}};
        int res = solution931.minFallingPathSum3(A);
        System.out.println(res);
    }
}
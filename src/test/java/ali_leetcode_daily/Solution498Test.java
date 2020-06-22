package ali_leetcode_daily;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution498Test {

    @Test
    public void findDiagonalOrder() {
        Solution498 solution498 = new Solution498();
        int[][] matrix = {{1,2,3},{3,4}};
        int[] diagonalOrder = solution498.findDiagonalOrder(matrix);
        for (int i : diagonalOrder)
            System.out.print(i+" ");
    }
}
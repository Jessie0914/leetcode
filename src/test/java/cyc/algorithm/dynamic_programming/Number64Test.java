package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number64Test {

    @Test
    public void minPathSum() {
        Number64 number64 = new Number64();
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        int minPathSum = number64.minPathSum(grid);
        System.out.println(minPathSum);
    }
}
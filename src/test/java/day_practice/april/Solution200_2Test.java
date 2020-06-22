package day_practice.april;

import org.junit.Test;

public class Solution200_2Test {

    @Test
    public void numIslands() {
        Solution200_2 solution200_2 = new Solution200_2();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int i = solution200_2.numIslands(grid);
        System.out.println(i);
    }
}
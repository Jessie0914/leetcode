package ali_leetcode_daily;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution200Test {

    @Test
    public void numIslands() {
        Solution200 solution200 = new Solution200();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int i = solution200.numIslands(grid);
        System.out.println(i);
    }
}
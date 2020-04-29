package DayPractice.April;

import org.junit.Test;

public class Solution200Test {

    @Test
    public void numIslands() {
        Solution200 solution200 = new Solution200();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int i = solution200.numIslands(grid);
        System.out.println(i);
    }
}
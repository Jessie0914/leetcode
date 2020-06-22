package day_practice.april;

/**
 * @ClassName Solution200
 * @Description 200. 岛屿数量
 * @Author shishi
 * @Date 2020/4/20 8:55
 **/

/**
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 */
public class Solution200 {
    int n;
    int m;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        n = grid.length;
        m = grid[0].length;

        int numOfIsland = 0;
        // dfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 如果碰到了1，就开始DFS
                if (grid[i][j] == '1') {
                    numOfIsland++;
                    helper(grid, i, j);
                }
            }
        }
        return numOfIsland;
    }

    private void helper(char[][] grid, int i, int j) {

        // 越界
        if (i < 0 || i >= n || j < 0 || j >= m)
            return;

        // 上下左右四个方向
        if (isArea(i - 1, j) && grid[i - 1][j] == '1') {
            // 设置为0，即"已访问"
            grid[i - 1][j] = '0';
            helper(grid, i - 1, j);
        }
        if (isArea(i + 1, j) && grid[i + 1][j] == '1') {
            // 设置为0，即"已访问"
            grid[i + 1][j] = '0';
            helper(grid, i + 1, j);
        }
        if (isArea(i, j - 1) && grid[i][j - 1] == '1') {
            // 设置为0，即"已访问"
            grid[i][j - 1] = '0';
            helper(grid, i, j - 1);
        }
        if (isArea(i, j + 1) && grid[i][j + 1] == '1') {
            // 设置为0，即"已访问"
            grid[i][j + 1] = '0';
            helper(grid, i, j + 1);
        }
    }

    private boolean isArea(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}

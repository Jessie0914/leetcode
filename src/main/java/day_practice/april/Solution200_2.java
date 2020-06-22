package day_practice.april;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution200_2
 * @Description 200. 岛屿数量
 * @Author shishi
 * @Date 2020/4/20 9:30
 **/

// BFS解决，效率会低一点
public class Solution200_2 {
    int n;
    int m;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        n = grid.length;
        m = grid[0].length;

        int numOfIsland = 0;
        // bfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    numOfIsland++;
                    // BFS
                    helper(grid, i, j);
                }
            }
        }
        return numOfIsland;
    }

    // BFS
    private void helper(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            grid[x][y] = 0;

            // 上下左右四个方向
            if (isArea(x - 1, y) && grid[x - 1][y] == '1') {
                // 设置为0，即"已访问"
                grid[x - 1][y] = '0';
                queue.offer(new int[]{x - 1, y});
            }
            if (isArea(x + 1, y) && grid[x + 1][y] == '1') {
                // 设置为0，即"已访问"
                grid[x + 1][y] = '0';
                queue.offer(new int[]{x + 1, y});
            }
            if (isArea(x, y - 1) && grid[x][y - 1] == '1') {
                // 设置为0，即"已访问"
                grid[x][y - 1] = '0';
                queue.offer(new int[]{x, y - 1});
            }
            if (isArea(x, y + 1) && grid[x][y + 1] == '1') {
                // 设置为0，即"已访问"
                grid[x][y + 1] = '0';
                queue.offer(new int[]{x, y + 1});
            }
        }
    }

    private boolean isArea(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}

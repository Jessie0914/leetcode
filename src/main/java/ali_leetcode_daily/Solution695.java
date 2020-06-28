package ali_leetcode_daily;

/**
 * @ClassName Solution695
 * @Description 695. 岛屿的最大面积
 * @Author shishi
 * @Date 2020/6/25 20:37
 **/
public class Solution695 {
    int m;
    int n;

    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    int result = 0;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        m = grid.length;
        n = grid[0].length;

        boolean[][] used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !used[i][j]) {
                    int count = 1;
                    int curResult = dfs(grid, i, j, used, count);
                    if (curResult > result) {
                        result = curResult;
                    }
                }
            }
        }

        return result;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] used, int count) {
        if (grid[i][j] == 0)
            return count;

        for (int k = 0; k < 4; k++) {
            if (!used[i][j]) {
                used[i][j] = true;
            }

            int newX = i + dx[k];
            int newY = j + dy[k];

            if (inArea(newX, newY) && !used[newX][newY] && grid[newX][newY] == 1) {
                count += dfs(grid, newX, newY, used, 1);
            }
        }
        return count;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}

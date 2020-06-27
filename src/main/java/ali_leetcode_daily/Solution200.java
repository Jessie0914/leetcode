package ali_leetcode_daily;

/**
 * @ClassName Solution200
 * @Description 200. 岛屿数量
 * @Author shishi
 * @Date 2020/6/25 15:07
 **/
public class Solution200 {
    int m;
    int n;
    int result;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        m = grid.length;
        n = grid[0].length;

        result = 0;
        boolean[][] used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !used[i][j]) {
                    result++;
                    dfs(grid, i, j, used);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] used) {
        if (used[i][j] || grid[i][j] == '0')
            return;

        for (int k = 0; k < 4; k++) {
            used[i][j] = true;

            int newX = i + dx[k];
            int newY = j + dy[k];

            if ((inArea(newX, newY)) && (grid[newX][newY] == '1' && !used[newX][newY])) {
                dfs(grid, newX, newY, used);
            }
        }
        // 不需要回退，比如说79题中，失败了回退是因为可能有其他解，所以回退继续找
        // 但是这里没有必要，只是碰到1就不断的深搜
//        used[i][j] = false;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}

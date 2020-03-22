package cyc.algorithm.dynamic_programming;

/**
 * @ClassName Number63
 * @Description 不同路径 II
 * @Author shishi
 * @Date 2020/3/22 13:46
 **/

/**
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: 2
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 */
public class Number63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        if (dp[0][0] == 0)
            return 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else {
                    if (i - 1 >= 0 && j - 1 >= 0)
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    else if (i - 1 >= 0)
                        dp[i][j] = dp[i - 1][j];
                    else if (j - 1 >= 0)
                        dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];

    }
}

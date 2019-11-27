package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 64. 最小路径和
 * @author: shishi
 * @create: 2019-11-27 17:14
 **/

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class Number64 {
    public int minPathSum(int[][] grid) {
        int len = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[len][width];
        for (int i = 0; i < len; i++) {
            if (i == 0)
                dp[i][0] = grid[i][0];
            else
                dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 0; j < width; j++) {
            if (j == 0)
                dp[0][j] = grid[0][j];
            else
                dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 动规
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < width; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[len - 1][width - 1];
    }
}

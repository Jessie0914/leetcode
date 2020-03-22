package top_interview;

/**
 * @ClassName Solution62
 * @Description 不同路径
 * @Author shishi
 * @Date 2020/3/9 12:45
 **/

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0)
            return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 向上、向左都有数据
                if (i - 1 >= 0 && j - 1 >= 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    // 只有向上有数据
                else if (i - 1 >= 0)
                    dp[i][j] = dp[i - 1][j];
                    // 只有向左有数据
                else if (j - 1 >= 0)
                    dp[i][j] = dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}

package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 62. 不同路径
 * @author: shishi
 * @create: 2019-11-27 17:29
 **/

public class Number62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0&&j==0) continue;

                int s1=0,s2=0;
                if (j-1>=0) s1 = dp[i][j-1];
                if (i-1>=0) s2 = dp[i-1][j];
                dp[i][j] = s1+s2;
            }
        }
        return dp[m-1][n-1];
    }
}

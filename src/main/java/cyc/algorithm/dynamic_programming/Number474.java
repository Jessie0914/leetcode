package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 474. 一和零
 * @author: shishi
 * @create: 2019-12-17 14:11
 **/

/**
 * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * 输出: 4
 * <p>
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 */
public class Number474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        // 三维数组
        int[][][] dp = new int[length][m + 1][n + 1];

        String s = strs[0];
        int count_0 = 0;
        int count_1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                count_0++;
            else count_1++;
        }

        // 初始化(和之前的稍有点不同)
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                // 只要大于等于就置为1，因为题意没有要求非要用掉所有的m和n
                if (i >= count_0 && j >= count_1)
                    dp[0][i][j] = 1;
            }
        }

        for (int i = 1; i < length; i++) {
            String str = strs[i];
            int zero = 0;
            int one = 0;
            for (int index = 0; index < str.length(); index++) {
                if (str.charAt(index) == '0')
                    zero++;
                else
                    one++;
            }

            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (j >= zero && k >= one) {
                        dp[i][j][k] = Math.max(dp[i - 1][j - zero][k - one] + 1, dp[i - 1][j][k]);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }

        return dp[length - 1][m][n];
    }

    // 优化空间解法(改了很多次)
    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        String s = strs[0];
        int count_0 = 0;
        int count_1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                count_0++;
            else count_1++;
        }

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i >= count_0 && j >= count_1)
                    dp[i][j] = 1;
            }
        }

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int zero = 0;
            int one = 0;
            for (int index = 0; index < str.length(); index++) {
                if (str.charAt(index) == '0')
                    zero++;
                else
                    one++;
            }

            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j >= zero && k >= one) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                    }
                }
            }
        }

        return dp[m][n];
    }

    // 自己尝试用二维数组做
    public int findMaxForm3(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        // 计算strs[0]中0和1的个数
        String s = strs[0];
        int count_0 = 0;
        int count_1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                count_0++;
            else count_1++;
        }
        // 初始化
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i >= count_0 && j >= count_1)
                    dp[i][j] = 1;
            }
        }

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int zero = 0;
            int one = 0;
            for (int index = 0; index < str.length(); index++) {
                if (str.charAt(index) == '0')
                    zero++;
                else
                    one++;
            }

            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j >= zero && k >= one) {
                        dp[j][k] = Math.max(dp[j][k],dp[j - zero][k - one] + 1);
                    }
                }
            }
        }

        return dp[m][n];
    }
}

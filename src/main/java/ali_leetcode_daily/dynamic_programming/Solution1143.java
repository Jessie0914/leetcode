package ali_leetcode_daily.dynamic_programming;

/**
 * @ClassName Solution1143
 * @Description 1143. 最长公共子序列
 * @Author shishi
 * @Date 2020/6/29 21:18
 **/

/**
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 */
public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
            return 0;

        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        // base case
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < len2 + 1; j++) {
            dp[0][j] = 0;
        }

        // dp
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[len1][len2];
    }
}

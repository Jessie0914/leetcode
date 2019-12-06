package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 1143. 最长公共子序列
 * @author: shishi
 * @create: 2019-12-06 14:36
 **/

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 */
public class Number1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, 0, text1.length(), text2, 0, text2.length());

    }

    private int helper(String text1, int s1, int e1, String text2, int s2, int e2) {
        if (s1 == e1 || s2 == e2) return 0;

        else {
            if (text1.charAt(e1 - 1) == text2.charAt(e2 - 1)) {
                return 1 + helper(text1, s1, e1 - 1, text2, s2, e2 - 1);
            } else {
                return Math.max(helper(text1, s1, e1 - 1, text2, s2, e2), helper(text1, s1, e1, text2, s2, e2 - 1));
            }
        }
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}

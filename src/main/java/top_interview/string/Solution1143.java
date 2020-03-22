package top_interview.string;

/**
 * @ClassName Solution1143
 * @Description 最长公共子序列
 * @Author shishi
 * @Date 2020/3/9 19:43
 **/

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 */
public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if ((i - 1) >= 0 && (j - 1) >= 0)
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = 1;
                } else {
                    if (i - 1 >= 0)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    if (j - 1 >= 0)
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}

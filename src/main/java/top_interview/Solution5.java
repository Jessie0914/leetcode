package top_interview;

/**
 * @ClassName Solution5
 * @Description 最长回文子串
 * @Author shishi
 * @Date 2020/2/28 14:07
 **/

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 0)
            return "";

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++)
            dp[i][i] = true;

        int left = 0;
        int right = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] || (j - i) <= 2;
                if (dp[i][j]) {
                    if ((j - i + 1) > (right - left + 1)) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}

package top_interview.string;

/**
 * @ClassName Solution5
 * @Description 最长回文子串
 * @Author shishi
 * @Date 2020/3/9 16:49
 **/

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        // 初始化，所有对角线的dp[i][i]都是true
        // 为了方便，把对角线左下角的部分也都填充成true（但其实没有意义，因为i<j）
        for (int i = 0; i < len; i++)
            for (int j = 0; j <= i; j++)
                dp[i][j] = true;

        int from = 0;
        int to = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (i + 1 < len && j - 1 >= 0) {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    if (dp[i][j] && (j - i + 1) > (to - from + 1)) {
                        from = i;
                        to = j;
                    }
                }
            }
        }

        return s.substring(from, to + 1);
    }
}

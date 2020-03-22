package top_interview.string;

/**
 * @ClassName Solution44
 * @Description 通配符匹配
 * @Author shishi
 * @Date 2020/3/9 21:02
 **/

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 */
public class Solution44 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        return judge(s, 0, p, 0);

    }

    private boolean judge(String s, int i, String p, int j) {
        if (i == s.length() && j == p.length())
            return true;

        if (i != s.length() && j == p.length())
            return false;

        // 如果当前是*
        // 注意i和j的边界判断
        if (j < p.length() && p.charAt(j) == '*') {
            if (i == s.length()) {
                if (j == p.length() - 1)
                    return true;
                    // 有可能p末尾全部剩*
                else
                    return judge(s, i, p, j + 1);
            } else
                return judge(s, i, p, j + 1) || judge(s, i + 1, p, j);
        } else if ((j < p.length() && i < s.length()) && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)))
            return judge(s, i + 1, p, j + 1);
        else
            return false;
    }

    // 动态规划
    public boolean isMatch2(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        // 初始化
        // 所有的dp[j][0]都是false，所有的dp[0][j]取决于dp[0][j-1]和是否是*
        dp[0][0] = true;
        for (int j = 1; j < len2 + 1; j++)
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }

        return dp[len1][len2];
    }
}

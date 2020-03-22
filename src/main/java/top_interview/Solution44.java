package top_interview;

/**
 * @ClassName Solution44
 * @Description 通配符匹配
 * @Author shishi
 * @Date 2020/3/4 13:32
 **/

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 输入:
 * s = "aa"
 * p = "*"
 * s = "cb"
 * p = "?a"
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 */
public class Solution44 {
    // 递归方法，会超时
    public boolean isMatch(String s, String p) {
        // 先将p数据a****bc**cc 清理为 a*bc*c
        p = simplify(p);
        return judge(s, 0, p, 0);
    }

    private String simplify(String p) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < p.length()) {
            if (p.charAt(i) != '*') {
                sb.append(p.charAt(i));
                i++;
            } else {
                while (i < p.length() && p.charAt(i) == '*')
                    i++;
                sb.append('*');
            }
        }
        return sb.toString();
    }

    private boolean judge(String s, int i, String p, int j) {
        if (i == s.length() && j == p.length())
            return true;

        if (i != s.length() && j == p.length())
            return false;

        // 判断当前是不是*
        if (j < p.length() && p.charAt(j) == '*') {
            if (i == s.length()) {
                if (j == p.length() - 1)
                    return true;
                else
                    return judge(s, i, p, j + 1);
            } else
                return judge(s, i, p, j + 1) || judge(s, i + 1, p, j);
        } else if (j < p.length() && i < s.length() && p.charAt(j) == '?') {
            return judge(s, i + 1, p, j + 1);
        } else if (j < p.length() && i < s.length() && p.charAt(j) == s.charAt(i))
            return judge(s, i + 1, p, j + 1);
        else
            return false;
    }



    // 动态规划
    // dp[i][j]代表s的前i个字符和p的前j个字符是否匹配
    public boolean isMatch2(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // 初始化部分
        dp[0][0] = true;
        // 所有的dp[i][0]都为false
        // 而所有的dp[0][j]取决于（p.charAt(j)是否是*以及dp[0][j-1]）
        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
        }

        // dp过程
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
            }
        }
        return dp[n][m];
    }

}

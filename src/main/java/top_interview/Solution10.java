package top_interview;

/**
 * @ClassName Solution10
 * @Description 正则表达式匹配
 * @Author shishi
 * @Date 2020/2/28 16:14
 **/

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        return helper(s, 0, p, 0);
    }

    private boolean helper(String s, int i, String p, int j) {
        if (i == s.length() && j == p.length())
            return true;

        if (i != s.length() && j == p.length())
            return false;

        // 判断下一位是不是*
        // 如果是*
        if ((j + 1 < p.length()) && p.charAt(j + 1) == '*') {
            if ((i < s.length() && j < p.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'))
                // 匹配0个或者1个
                return helper(s, i, p, j + 2) || helper(s, i + 1, p, j);
            else
                // 如果不相等的话，只能匹配0个
                return helper(s, i, p, j + 2);
        } else {
            if ((i < s.length() && j < p.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'))
                return helper(s, i + 1, p, j + 1);
            else
                return false;
        }
    }
}

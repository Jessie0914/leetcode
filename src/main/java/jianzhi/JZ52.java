package jianzhi;

/**
 * @Classname JZ52
 * @Description 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @Date 2020/7/24 2:52 下午
 * @Created by chiyue
 */
public class JZ52 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null && pattern == null)
            return true;

        if (str != null && pattern == null)
            return false;

        return judge(str, 0, pattern, 0);

    }

    private boolean judge(char[] str, int i, char[] pattern, int j) {
        if (i == str.length && j == pattern.length) {
            return true;
        }

        if (i != str.length && j == pattern.length)
            return false;

        if ((j + 1) < pattern.length && pattern[j + 1] == '*') {
            // 要注意的是先判断i是否越界
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.'))
                return judge(str, i, pattern, j + 2) || judge(str, i + 1, pattern, j);
            else
                return judge(str, i, pattern, j + 2);
        } else {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.'))
                return judge(str, i + 1, pattern, j + 1);
            else
                return false;
        }
    }
}

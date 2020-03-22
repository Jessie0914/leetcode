package top_interview;

/**
 * @ClassName Solution22
 * @Description 括号生成
 * @Author shishi
 * @Date 2020/3/1 13:10
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * n=3
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0)
            return res;

        dfs("", n, n, res);
        return res;
    }

    // 当前字符串，left为左括号剩下的数量，right为右括号剩下的数量
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 如果左右剩下的都为0,，添加到结果集合
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 如果剩下左括号的数量多余右括号，已经无效了，直接return
        if (left > right)
            return;

        // 否则，尝试添加一个左括号
        if (left > 0)
            dfs(curStr + "(", left - 1, right, res);
        // 尝试添加一个右括号
        if (right > 0)
            dfs(curStr + ")", left, right - 1, res);
    }
}

package day_practice.april;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution22
 * @Description 22. 括号生成
 * @Author shishi
 * @Date 2020/4/19 15:04
 **/

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Solution22 {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        String cur = "";
        generate(cur, n * 2, n, n);
        return res;
    }

    private void generate(String cur, int len, int leftNum, int rightNum) {
        if (cur.length() == len) {
            res.add(cur);
            return;
        }

        if (leftNum < 0 || rightNum < 0)
            return;

        // 说明构造不了了，直接返回
        if (leftNum > rightNum) {
            return;
        }

        if (leftNum > 0)
            generate(cur + "(", len, leftNum - 1, rightNum);

        if (rightNum > 0)
            generate(cur + ")", len, leftNum, rightNum - 1);

    }
}

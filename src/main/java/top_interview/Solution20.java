package top_interview;

/**
 * @ClassName Solution20
 * @Description 有效的括号
 * @Author shishi
 * @Date 2020/3/1 12:37
 **/

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 输入: "()[]{}"
 * 输出: true
 */
public class Solution20 {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (map.containsValue(c))
                stack.push(c);
            else {
                if (!stack.isEmpty() && stack.peek() == map.get(c))
                    stack.pop();
                else
                    return false;
            }
            i++;
        }
        return stack.isEmpty();
    }
}

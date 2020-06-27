package ali_leetcode_daily;

import java.util.Stack;

/**
 * @ClassName Solution227
 * @Description 227. 基本计算器 II
 * @Author shishi
 * @Date 2020/6/26 13:13
 **/
public class Solution227 {
    Stack<String> stack = new Stack<>();
    int index = 0;

    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.replaceAll(" ", "");
        s = "0" + s;
        if (s.length() == 0)
            return 0;

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int num = nextNum(s, index);
                stack.push(String.valueOf(num));
            } else {
                char op = s.charAt(index);
                index++;

                if (op == '+' || op == '-') {
                    stack.push(op + "");
                } else {
                    int first = 0;
                    int second = nextNum(s, index);
                    if (!stack.isEmpty()) {
                        String pop = stack.pop();
                        first = Integer.valueOf(pop);
                    }

                    int temp = 0;
                    if (op == '*') {
                        temp = first * second;
                    } else {
                        temp = first / second;
                    }
                    stack.push(temp + "");
                }
            }
        }

        if (stack.size() == 1)
            return Integer.valueOf(stack.peek());

        // 剩下的在栈内的元素只有加减的
        // 1-1+1
        // 所以剩下的需要按照顺序来计算
        // 直到只剩一个值，即为最后的值
        int i = 0;
        int result = Integer.valueOf(stack.get(i++));
        int first = 0, second = 0;
        String op = "";
        while (i < stack.size()) {
            first = result;

            if (i < stack.size())
                op = stack.get(i++);

            if (i < stack.size())
                second = Integer.valueOf(stack.get(i++));

            if (op.equals("+")) {
                result = first + second;
            } else {
                result = first - second;
            }
        }

        return result;
    }

    private int nextNum(String s, int i) {
        int num = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            char c = s.charAt(i);
            num = num * 10 + (c - '0');
            i++;
        }
        index = i;
        return num;
    }
}

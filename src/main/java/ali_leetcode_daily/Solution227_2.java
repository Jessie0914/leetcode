package ali_leetcode_daily;

import java.util.Stack;

/**
 * @ClassName Solution227_2
 * @Description 227. 基本计算器 II
 * @Author shishi
 * @Date 2020/6/26 15:00
 **/
public class Solution227_2 {
    Stack<Integer> stack = new Stack<>();
    int index = 0;

    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.replaceAll(" ", "");

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int num = nextNum(s, index);
                stack.push(num);
            } else {
                char op = s.charAt(index++);
                if (op == '+') {
                    int num = nextNum(s, index);
                    stack.push(num);
                } else if (op == '-') {
                    int num = nextNum(s, index);
                    stack.push(-num);
                } else if (op == '*') {
                    int first = stack.pop();
                    int second = nextNum(s, index);
                    int temp = first * second;
                    stack.push(temp);
                } else {
                    int first = stack.pop();
                    int second = nextNum(s, index);
                    int temp = first / second;
                    stack.push(temp);
                }
            }
        }

        while (stack.size() != 1) {
            Integer first = stack.pop();
            Integer second = stack.pop();
            stack.push(first + second);
        }

        return stack.peek();
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

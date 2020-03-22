package stack;

/**
 * @ClassName Solution150
 * @Description 150.逆波兰表达式求值
 * @Author shishi
 * @Date 2019/7/3 18:53
 **/

import java.util.HashMap;
import java.util.Stack;

/**
 * 题目要求：
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式
 * <p>
 * 示例：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 */
public class Solution150 {
    // 这里要记住一个String转换成Integer类型的函数，Integer.parseInt(s)
    public int evalRPN(String[] tokens) {
        // 便于判断是不是操作符
        HashMap<String, Character> hashMap = new HashMap<>();
        hashMap.put("+", '+');
        hashMap.put("-", '-');
        hashMap.put("*", '*');
        hashMap.put("/", '/');

        int i = 0;
        // 主要是利用这个栈，最终栈内只会有一个数字，就是结果
        Stack<Integer> stack = new Stack<>();
        while (i < tokens.length) {
            // 如果是数字，就压入栈
            if (!hashMap.containsKey(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            }
            // 如果是操作符，就从栈内取出来两个数字
            else {
                Character operator = hashMap.get(tokens[i]);
                Integer rightNum = stack.pop();
                Integer leftNum = stack.pop();
                switch (operator) {
                    case '+':
                        stack.push(leftNum + rightNum);
                        break;
                    case '-':
                        stack.push(leftNum - rightNum);
                        break;
                    case '*':
                        stack.push(leftNum * rightNum);
                        break;
                    case '/':
                        stack.push(leftNum / rightNum);
                        break;
                    default:
                        break;
                }
            }
            i++;
        }
        return stack.peek();
    }
}

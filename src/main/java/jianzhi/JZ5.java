package jianzhi;

import java.util.Stack;

/**
 * @ClassName JZ5
 * @Description 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * @Author shishi
 * @Date 2020/7/12 18:31
 **/
public class JZ5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        stack2.push(node);

        // 转移到stack1
        while (!stack2.isEmpty()) {
            stack1.add(stack2.pop());
        }
    }

    public int pop() {
        if (!stack1.isEmpty()) {
            return stack1.pop();
        }
        return Integer.MIN_VALUE;
    }
}

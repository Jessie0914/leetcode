package jianzhi;

import java.util.Stack;

/**
 * @ClassName JZ20
 * @Description 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * @Author shishi
 * @Date 2020/7/13 23:52
 **/
public class JZ20 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min_stack = new Stack<>();

    public void push(int node) {
        stack.push(node);

        if (min_stack.isEmpty()) {
            min_stack.push(node);
        } else {
            // 保证min_stack中是从小到大的
            // 不需要保证min_stack只有一个最小的元素，只需要保证最顶端是最小的即可
            if (min_stack.peek() > node) {
                min_stack.push(node);
            }
        }

    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop == min_stack.peek())
            min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min_stack.peek();
    }
}

package queue;

/**
 * @ClassName Solution232
 * @Description 232.用栈实现队列
 * @Author shishi
 * @Date 2019/7/3 18:41
 **/

import java.util.Stack;

/**
 * 题目要求：
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 */
public class Solution232 {
    // 用两个栈实现即可，tmp为辅助栈
    Stack<Integer> stack;
    Stack<Integer> tmp;

    /** Initialize your data structure here. */
    public Solution232() {
        this.stack = new Stack<>();
        this.tmp = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 把stack中的所有元素都先暂存在tmp中，再加入当前元素
        while (!stack.isEmpty()){
            tmp.push(stack.pop());
        }
        tmp.push(x);
        // 再一个一个推入到stack中，就是一样的效果
        while (!tmp.isEmpty()){
            stack.push(tmp.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

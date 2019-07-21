package stack;

/**
 * @ClassName Solution225
 * @Description 225.用队列实现栈
 * @Author shishi
 * @Date 2019/7/3 16:56
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目要求：
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 */
public class Solution225 {
    // 有很多种方法，大多是采用两个队列来实现的
    // 如下的方法是压入O(n),弹出O(1)
    // 也有压入O(1)，弹出O(n)的
    Queue<Integer> queue;
    Queue<Integer> tmp;

    /** Initialize your data structure here. */
    // 初始化，用的是LinkedList实现
    public Solution225() {
        this.queue = new LinkedList<>();
        this.tmp = new LinkedList<>();
    }

    /** Push element x onto stack. */
    // offer进去的时候，先offer到tmp队列
    // 然后再把queue队列里的所有的数据，一个个poll()出来放到tmp队列（这样就满足栈的顺序了）
    // 最后交换tmp和queue即可
    public void push(int x) {
        tmp.offer(x);
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            tmp.offer(poll);
        }
        Queue swap = tmp;
        tmp = queue;
        queue = swap;
    }

    /** Removes the element on top of the stack and returns that element. */
    // push的时候已经保证是栈的顺序了
    // 正常的pop即可
    // 其他操作都正常的top isEmpty即可
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

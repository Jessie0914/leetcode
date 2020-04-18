package DayPractice.March;

import java.util.LinkedList;

/**
 * @ClassName Solution225
 * @Description 225. 用队列实现栈
 * @Author shishi
 * @Date 2020/4/2 14:50
 **/
public class Solution225 {
    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;
    /** Initialize your data structure here. */
    public Solution225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 先把queue1中的元素移动到queue2
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        // 然后先push
        queue1.offer(x);
        // 再把queue2中的元素再移动回来
        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

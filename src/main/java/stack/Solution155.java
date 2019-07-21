package stack;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */

/**
 * 本来我写完提交之后，发现超时，解决方法之一是借助辅助栈
 * 借助一个辅助栈，minStack，才可以在常数时间内搜索到最小值
 */
public class Solution155 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public Solution155() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    // push的时候就要同时对minStack操作
    public void push(int x) {
        // 先压入普通栈
        stack.push(x);
        // 如果minStack为空，或者顶部元素大于当前值，就压入minStack
        if (minStack.isEmpty() || x<=minStack.peek()){
            minStack.push(x);
        }
    }

    // pop的时候同样也要对minStack操作
    // 这里的注意点是取出来的是一个对象，不能单纯的用==进行比较，需要用A.equals(B)来比较
    public void pop() {
        Integer pop = stack.pop();
        // 如果stack中弹出的元素跟minStack一样，那么minStack也需要弹出来
        if (pop.equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

package jianzhi;

import java.util.Stack;

/**
 * @ClassName JZ21
 * @Description 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * @Author shishi
 * @Date 2020/7/14 23:16
 **/
public class JZ21 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null)
            return false;

        if (pushA.length == 0 && popA.length == 0)
            return true;

        if (pushA.length != popA.length)
            return false;

        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();

        while (i < pushA.length) {
            if (pushA[i] != popA[j]) {
                stack.push(pushA[i]);
                i++;
            } else {
                i++;
                j++;
            }
        }

        // 这里先加一个stack判空的条件，不然如果真的为空，会报错
        while (!stack.isEmpty() && stack.peek() == popA[j] && j < popA.length) {
            stack.pop();
            j++;
        }
        return stack.isEmpty();
    }
}

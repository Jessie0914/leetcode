package DayPractice.April;

import DayPractice.ListNode;

import java.util.Stack;

/**
 * @ClassName Solution445
 * @Description 445. 两数相加 II
 * @Author shishi
 * @Date 2020/4/19 16:41
 **/

/**
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class Solution445 {
    // 如果将链表转换成数值的话，有可能会溢出的
    // 所以可以用栈
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        Stack<Integer> stack3 = new Stack<>();

        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int num1 = stack1.pop();
            int num2 = stack2.pop();

            int num = num1 + num2 + carry;

            if (num >= 10) {
                carry = num / 10;
                num %= 10;
            } else
                carry = 0;

            stack3.push(num);
        }

        while (!stack1.isEmpty()) {
            if (carry != 0) {
                int pop = stack1.pop();
                pop = pop + carry;
                if (pop >= 10) {
                    stack3.push(pop % 10);
                    carry = pop / 10;
                } else {
                    carry = 0;
                    stack1.push(pop);
                }
            } else
                stack3.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            if (carry != 0) {
                int pop = stack2.pop();
                pop = pop + carry;
                if (pop >= 10) {
                    stack3.push(pop % 10);
                    carry = pop / 10;
                } else {
                    carry = 0;
                    stack2.push(pop);
                }
            } else
                stack3.push(stack2.pop());
        }

        if (carry!=0){
            stack3.push(carry);
        }

        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (!stack3.isEmpty()){
            ListNode node = new ListNode(stack3.pop());
            head.next = node;
            head = node;
        }

        return p.next;
    }


}

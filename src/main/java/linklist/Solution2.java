package linklist;

/**
 * 题目要求：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution2 {
    public static void main(String[] args) {
        // 5->6->4链表
        ListNode l11 = new ListNode(5);
//        linklist.ListNode l12 = new linklist.ListNode(6);
//        linklist.ListNode l13 = new linklist.ListNode(4);
//        l11.next = l12;
//        l12.next = l13;

        // 2->4->3链表
        ListNode l21 = new ListNode(5);
//        linklist.ListNode l22 = new linklist.ListNode(4);
//        linklist.ListNode l23 = new linklist.ListNode(3);
//        l21.next = l22;
//        l22.next = l23;

        ListNode l = addTwoNumbers(l11, l21);
        System.out.println(l.toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        // 进位
        int carry = 0;

        // 定义一个虚假的头结点
        ListNode head = new ListNode(0);

        // 定义当前的结点，每次计算一个就把当前节点向后移动
        ListNode currentNode = new ListNode(0);

        // 先将创建好的两个结点连接起来
        head.next = currentNode;

        while (l1!=null || l2!=null || carry!=0){
            int sum = 0;
            if (l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            // 如果我加上else{l1.val=0} [5][5]的测试用例就会内存报错，其实不加这段就可以
            if (l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            if (sum>=10){
                carry = 1;
            }else{
                carry = 0;
            }
            int result = sum % 10;
            //将结果填入创建好的当前节点
            currentNode.val = result;

            // 接下来再创建一个新的结点，继续后面的操作
            // 但是创建之前先要判断一下，否则就会多出一个结点
            if (l1!=null || l2!=null || carry!=0){
                currentNode.next = new ListNode(0);
                currentNode = currentNode.next;
            }
        }
        return head.next;
    }
}


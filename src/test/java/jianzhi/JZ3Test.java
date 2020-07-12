package jianzhi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class JZ3Test {

    @Test
    public void printListFromTailToHead() {
        JZ3 jz3 = new JZ3();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ArrayList<Integer> list = jz3.printListFromTailToHead(head);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
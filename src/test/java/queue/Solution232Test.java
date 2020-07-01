package queue;

import org.junit.Test;

public class Solution232Test {

    @Test
    public void push() {
        Solution232 solution232 = new Solution232();
        solution232.push(1);
        solution232.push(2);
        solution232.push(3);
        solution232.push(4);
        solution232.push(5);
        System.out.println(solution232.pop());
        System.out.println(solution232.peek());
        System.out.println(solution232.empty());
    }
}
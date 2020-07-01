package stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution225Test {
    Solution225 solution225;

    @Test
    public void push() {
        solution225 = new Solution225();
        solution225.push(1);
        solution225.push(2);
        solution225.push(3);
        solution225.push(4);
        solution225.push(5);
        System.out.println(solution225.pop());
        System.out.println(solution225.top());
        System.out.println(solution225.pop());
        System.out.println(solution225.pop());
        System.out.println(solution225.pop());
        System.out.println(solution225.pop());
        System.out.println(solution225.empty());
    }

}
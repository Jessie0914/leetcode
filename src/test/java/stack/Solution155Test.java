package stack;

import org.junit.Test;

import java.io.PushbackInputStream;


public class Solution155Test {
    public static void main(String[] args) {
        Solution155 solution155 = new Solution155();
        solution155.push(512);
        solution155.push(-1024);
        solution155.push(-1024);
        solution155.push(512);
        solution155.pop();
        solution155.getMin();
        solution155.pop();
        solution155.getMin();
        solution155.pop();
        solution155.getMin();
    }

    @Test
    public void push() {
    }

    @Test
    public void pop() {
    }

    @Test
    public void top() {
    }

    @Test
    public void getMin() {
    }
}
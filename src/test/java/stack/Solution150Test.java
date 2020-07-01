package stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution150Test {

    @Test
    public void evalRPN() {
        Solution150 solution150 = new Solution150();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int polish = solution150.evalRPN(tokens);
        System.out.println(polish);
    }
}
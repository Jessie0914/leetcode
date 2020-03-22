package top_interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution29Test {

    @Test
    public void divide() {
        Solution29 solution29 = new Solution29();
        int divide = solution29.divide(-2147483648,2);
        System.out.println(divide);
    }
}
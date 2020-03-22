package top_interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution50Test {

    @Test
    public void myPow() {
        Solution50 solution50 = new Solution50();
        double result = solution50.myPow(1.000, -2147483648);
        System.out.println(result);
    }
}
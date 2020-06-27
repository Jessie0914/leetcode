package ali_leetcode_daily;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution227_2Test {

    @Test
    public void calculate() {
        Solution227_2 solution227_2 = new Solution227_2();
        String s = "   3 /  4+5";
        int calculate = solution227_2.calculate(s);
        System.out.println(calculate);
    }
}
package top_interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution20Test {

    @Test
    public void isValid() {
        String s = "[[]]";
        Solution20 solution20 = new Solution20();
        boolean valid = solution20.isValid(s);
        System.out.println(valid);
    }
}
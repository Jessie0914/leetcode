package top_interview;

import org.junit.Test;

public class Solution10Test {

    @Test
    public void isMatch() {
        Solution10 solution10 = new Solution10();
        String s = "ab";
        String p = ".*";
        boolean match = solution10.isMatch(s, p);
        System.out.println(match);
    }
}
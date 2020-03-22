package top_interview.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution44Test {

    @Test
    public void isMatch() {
        Solution44 solution44 = new Solution44();
        String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba";
        String p = "a*b";
        boolean match = solution44.isMatch2(s, p);
        System.out.println(match);
    }
}
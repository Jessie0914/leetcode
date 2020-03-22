package top_interview;

import org.junit.Test;

public class Solution44Test {
    @Test
    public void isMatch() {
        Solution44 solution44 = new Solution44();
        String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba";
        String p = "a*******b";
        boolean match = solution44.isMatch(s, p);
        System.out.println(match);
    }
}
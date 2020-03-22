package top_interview.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution76Test {

    @Test
    public void minWindow() {
        Solution76 solution76 = new Solution76();
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        String minWindow = solution76.minWindow(s, t);
        System.out.println(minWindow);
    }
}
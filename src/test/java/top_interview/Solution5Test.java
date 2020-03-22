package top_interview;

import org.junit.Test;

public class Solution5Test {

    @Test
    public void longestPalindrome() {
        Solution5 solution5 = new Solution5();
        String s = "aaabaaaa";
        String longestPalindrome = solution5.longestPalindrome(s);
        System.out.println(longestPalindrome);
    }
}
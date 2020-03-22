package top_interview.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution5Test {

    @Test
    public void longestPalindrome() {
        Solution5 solution5 = new Solution5();
        String s = "cbbd";
        String longestPalindrome = solution5.longestPalindrome(s);
        System.out.println(longestPalindrome);
    }
}
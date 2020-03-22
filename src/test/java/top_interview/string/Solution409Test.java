package top_interview.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution409Test {

    @Test
    public void longestPalindrome() {
        Solution409 solution409 = new Solution409();
        String s = "abccccdd";
        int i = solution409.longestPalindrome2(s);
        System.out.println(i);
    }
}
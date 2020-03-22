package top_interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution28Test {

    @Test
    public void strStr() {
        Solution28 solution28 = new Solution28();
        String haystack = "mississippi" ,needle = "pi";
        int index = solution28.strStr(haystack, needle);
        System.out.println(index);
    }
}
package String;

import org.junit.Test;


public class Solution28Test {

    @Test
    public void strStr() {
        Solution28 solution28 = new Solution28();
        String haystack = "hello", needle = "ll";
        int index = solution28.strStr(haystack, needle);
        System.out.println(index);
    }
}
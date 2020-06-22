package day_practice.april;

import org.junit.Test;

public class Solution151Test {

    @Test
    public void reverseWords() {
        Solution151 solution151 = new Solution151();
        String s = solution151.reverseWords("  hello world!  ");
        System.out.println(s);
    }
}
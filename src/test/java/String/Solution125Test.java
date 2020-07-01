package String;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution125Test {

    @Test
    public void isPalindrome() {
        Solution125 solution125 = new Solution125();
        String s = "0P";
        boolean palindrome = solution125.isPalindrome(s);
        System.out.println(palindrome);
    }
}
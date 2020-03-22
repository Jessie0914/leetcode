package top_interview;

import org.junit.Test;

public class Solution14Test {

    @Test
    public void longestCommonPrefix() {
        Solution14 solution14 = new Solution14();
        String[] strs = {"flower","flow","flight"};
        String s = solution14.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
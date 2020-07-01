package String;

import greedy.Solution3;
import org.junit.Test;

public class Solution3Test {

    @Test
    public void lengthOfLongestSubstring() {
        Solution3 solution3 = new Solution3();
        int length = solution3.lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);
    }
}
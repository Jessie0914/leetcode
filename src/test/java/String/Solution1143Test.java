package String;

import org.junit.Test;

public class Solution1143Test {

    @Test
    public void longestCommonSubsequence() {
        Solution1143 solution1143 = new Solution1143();
        int lcsNum = solution1143.longestCommonSubsequence("abcd", "ac");
        System.out.println(lcsNum);
    }
}
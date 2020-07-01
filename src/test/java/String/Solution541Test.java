package String;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution541Test {

    @Test
    public void reverseStr() {
        Solution541 solution541 = new Solution541();
        String s = "abcdefg";
        int k = 2;
        String reverseStr = solution541.reverseStr(s, k);
        System.out.println(reverseStr);
    }
}
package top_interview;

import org.junit.Test;

public class Solution13Test {

    @Test
    public void romanToInt() {
        Solution13 solution13 = new Solution13();
        String s = "MCMXCIV";
        int romanToInt = solution13.romanToInt(s);
        System.out.println(romanToInt);
    }
}
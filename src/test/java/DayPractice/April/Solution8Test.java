package DayPractice.April;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution8Test {

    @Test
    public void myAtoi() {
        Solution8 solution8 = new Solution8();
        int atoi = solution8.myAtoi("-91283472332");
        System.out.println(atoi);
    }
}
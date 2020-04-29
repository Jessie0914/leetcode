package DayPractice.April;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution151Test {

    @Test
    public void reverseWords() {
        Solution151 solution151 = new Solution151();
        String s = solution151.reverseWords("  hello world!  ");
        System.out.println(s);
    }
}
package String;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution344Test {

    @Test
    public void reverseString() {
        Solution344 solution344 = new Solution344();
        char[] s = {'h','e','l','l','o'};
        solution344.reverseString(s);
        System.out.println(s);
    }
}
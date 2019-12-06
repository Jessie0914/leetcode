package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number1143Test {

    @Test
    public void longestCommonSubsequence() {
        Number1143 number1143 = new Number1143();
        int longestCommonSubsequence = number1143.longestCommonSubsequence1("abcde", "adecde");
        System.out.println(longestCommonSubsequence);
    }
}
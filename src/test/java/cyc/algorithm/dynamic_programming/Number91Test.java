package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number91Test {

    @Test
    public void numDecodings() {
        Number91 number91 = new Number91();
        String s = "01";
        int res = number91.numDecodings(s);
        System.out.println(res);
    }
}
package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number70Test {

    @Test
    public void climbStairs() {
        Number70 number70 = new Number70();
        int res = number70.climbStairs(5);
        System.out.println(res);
    }
}
package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number343Test {

    @Test
    public void integerBreak() {
        Number343 number343 = new Number343();
        int max = number343.integerBreak(3);
        System.out.println(max);
    }

    @Test
    public void integerBreak1() {
        Number343 number343 = new Number343();
        int max = number343.integerBreak1(10);
        System.out.println(max);
    }
}
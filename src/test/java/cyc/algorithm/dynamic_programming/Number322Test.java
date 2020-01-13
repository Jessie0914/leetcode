package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number322Test {

    @Test
    public void coinChange() {
        Number322 number322 = new Number322();
        int[] coins = {2};
        int amount = 3;
        int i = number322.coinChange2(coins, amount);
        System.out.println(i);
    }
}
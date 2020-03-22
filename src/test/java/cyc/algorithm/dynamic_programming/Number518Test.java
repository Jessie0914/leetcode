package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number518Test {

    @Test
    public void change() {
        Number518 number518 = new Number518();
        int amount = 5;
        int[] coins = {1,2,5};
        int change = number518.change(amount, coins);
        System.out.println(change);
    }
}
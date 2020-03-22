package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number413Test {

    @Test
    public void numberOfArithmeticSlices() {
        Number413 number413 = new Number413();
        int[] A = {1, 2, 3, 4, 5};
        int sum = number413.numberOfArithmeticSlices(A);
        System.out.println(sum);
    }

    @Test
    public void numberOfArithmeticSlices1() {
        Number413 number413 = new Number413();
        int[] A = {1, 2, 3, 4, 5};
        int sum = number413.numberOfArithmeticSlices1(A);
        System.out.println(sum);
    }
}
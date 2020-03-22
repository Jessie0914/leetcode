package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number474Test {

    @Test
    public void findMaxForm() {
        Number474 number474 = new Number474();
        String[] strs = {"00101011"};
        int m = 36;
        int n = 39;
        int maxForm = number474.findMaxForm2(strs, m, n);
        System.out.println(maxForm);
    }
}
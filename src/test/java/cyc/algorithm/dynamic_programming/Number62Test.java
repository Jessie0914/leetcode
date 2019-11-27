package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number62Test {

    @Test
    public void uniquePaths() {
        Number62 number62 = new Number62();
        int uniquePaths = number62.uniquePaths(3, 2);
        System.out.println(uniquePaths);
    }
}
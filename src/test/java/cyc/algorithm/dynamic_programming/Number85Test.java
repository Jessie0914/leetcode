package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number85Test {

    @Test
    public void maximalRectangle() {
        Number85 number85 = new Number85();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int i = number85.maximalRectangle(matrix);
        System.out.println(i);
    }
}
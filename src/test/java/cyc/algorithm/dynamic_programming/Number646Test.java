package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number646Test {

    @Test
    public void findLongestChain() {
        Number646 number646 = new Number646();
        int[][] pairs = {{3,4},{2,3},{1,2}};
        int longestChain = number646.findLongestChain(pairs);
        System.out.println(longestChain);
    }
}
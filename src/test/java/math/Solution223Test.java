package math;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution223Test {

    @Test
    public void computeArea() {
        Solution223 solution223 = new Solution223();

        int area = solution223.computeArea(-2286,-1386,-2279,-1380,-2284,-1384,-2273,-1375);
        System.out.println(area);
    }
}
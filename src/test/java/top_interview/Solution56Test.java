package top_interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution56Test {

    @Test
    public void merge() {
        Solution56 solution56 = new Solution56();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}};
        int[][] merge = solution56.merge(intervals);
        for (int[] cur : merge) {
            System.out.println(cur[0] + " " + cur[1]);
        }
    }
}
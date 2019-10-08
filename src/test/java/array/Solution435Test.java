package array;

import org.junit.Test;

public class Solution435Test {

    @Test
    public void eraseOverlapIntervals() {
        Solution435 solution435 = new Solution435();
        int[][] intervals = {{1,100},{1,100},{1,100}};
        int count = solution435.eraseOverlapIntervals(intervals);
        System.out.println(count);
    }
}
package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution436Test {

    @Test
    public void findRightInterval() {
        Solution436 solution436 = new Solution436();
        int[][] intervals = {{1,4}, {2,3}, {3,4}};
        int[] res = solution436.findRightInterval(intervals);
        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
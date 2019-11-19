package violence;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution873Test {

    @Test
    public void lenLongestFibSubseq() {
        Solution873 solution873 = new Solution873();
        int[] A = {2,5,6,7,8,10,12,17,24,41,65};
        int longestFibSubseq = solution873.lenLongestFibSubseq(A);
        System.out.println(longestFibSubseq);
    }
}